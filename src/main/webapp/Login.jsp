<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foodie - Log In</title>
    <style>
        /* Global Reset & Styling */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        /* Pure CSS Animated Background (Same as Signup) */
        body {
            background: linear-gradient(-45deg, #fdfbf7, #ffe4e6, #fecdd3, #fff1f2);
            background-size: 400% 400%;
            animation: gradientBG 12s ease infinite;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        /* Interactive Card Container */
        .login-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 10px 30px rgba(244, 63, 94, 0.08);
            width: 100%;
            max-width: 420px;
            border: 1px solid rgba(254, 205, 211, 0.6);
            transition: transform 0.4s ease, box-shadow 0.4s ease;
        }

        .login-container:hover {
            transform: translateY(-6px);
            box-shadow: 0 18px 40px rgba(244, 63, 94, 0.15);
        }

        /* Header & Pulsing Icon */
        .brand-header {
            text-align: center;
            margin-bottom: 24px;
        }

        .brand-icon {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            width: 55px;
            height: 55px;
            border-radius: 50%;
            background-color: #f43f5e;
            color: #ffffff;
            font-size: 26px;
            font-weight: bold;
            margin-bottom: 12px;
            box-shadow: 0 6px 12px rgba(244, 63, 94, 0.3);
            animation: pulse 2s infinite;
        }

        @keyframes pulse {
            0% { transform: scale(1); box-shadow: 0 0 0 0 rgba(244, 63, 94, 0.4); }
            70% { transform: scale(1.03); box-shadow: 0 0 0 12px rgba(244, 63, 94, 0); }
            100% { transform: scale(1); box-shadow: 0 0 0 0 rgba(244, 63, 94, 0); }
        }

        .brand-header h2 {
            color: #1f2937;
            font-size: 28px;
            font-weight: 700;
        }

        .brand-header p {
            color: #6b7280;
            font-size: 14px;
            margin-top: 4px;
        }

        /* Form Group & Input Focus Effects */
        .form-group {
            margin-bottom: 18px;
            position: relative;
        }

        .form-group label {
            display: block;
            font-size: 11px;
            font-weight: 700;
            color: #4b5563;
            text-transform: uppercase;
            margin-bottom: 6px;
            letter-spacing: 0.6px;
            transition: color 0.2s ease;
        }

        .form-group input {
            width: 100%;
            padding: 12px 14px;
            border: 1.5px solid #e5e7eb;
            border-radius: 10px;
            font-size: 14px;
            color: #374151;
            outline: none;
            background-color: #fafafa;
            transition: all 0.25s ease;
        }

        .form-group input:focus {
            background-color: #ffffff;
            border-color: #f43f5e;
            box-shadow: 0 0 0 4px rgba(244, 63, 94, 0.12);
            transform: translateY(-1px);
        }

        .form-group:focus-within label {
            color: #f43f5e;
        }

        /* Pure CSS Password Toggle Feature */
        .password-container {
            position: relative;
        }

        .toggle-password {
            display: none;
        }

        .toggle-label {
            position: absolute;
            right: 12px;
            top: 50%;
            transform: translateY(-50%);
            font-size: 12px;
            color: #6b7280;
            cursor: pointer;
            user-select: none;
            font-weight: 600;
            padding: 2px 6px;
            border-radius: 4px;
            transition: color 0.2s ease;
        }

        .toggle-label:hover {
            color: #f43f5e;
        }

        /* Display Text when Checked */
        .toggle-password:checked ~ input {
            -webkit-text-security: none !important;
        }

        /* Dynamic Text Switcher */
        .toggle-password:not(:checked) ~ .toggle-label::after {
            content: "Show";
        }

        .toggle-password:checked ~ .toggle-label::after {
            content: "Hide";
        }

        /* Interactive Submit Button */
        .submit-btn {
            width: 100%;
            padding: 13px;
            background-color: #f43f5e;
            color: #ffffff;
            border: none;
            border-radius: 10px;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.25s ease;
            box-shadow: 0 4px 12px rgba(244, 63, 94, 0.25);
            margin-top: 10px;
            position: relative;
            overflow: hidden;
        }

        .submit-btn:hover {
            background-color: #e11d48;
            box-shadow: 0 6px 16px rgba(225, 29, 72, 0.35);
            transform: translateY(-1px);
        }

        .submit-btn:active {
            transform: scale(0.98);
        }

        /* Dynamic Footer Links */
        .form-footer {
            text-align: center;
            margin-top: 22px;
            font-size: 13px;
            color: #6b7280;
        }

        .form-footer a {
            color: #f43f5e;
            text-decoration: none;
            font-weight: 600;
            position: relative;
            padding-bottom: 2px;
        }

        .form-footer a::after {
            content: '';
            position: absolute;
            width: 0;
            height: 2px;
            bottom: 0;
            left: 0;
            background-color: #f43f5e;
            transition: width 0.3s ease;
        }

        .form-footer a:hover::after {
            width: 100%;
        }
    </style>
</head>
<body>

    <div class="login-container">
        <!-- Header -->
        <div class="brand-header">
            <div class="brand-icon">F</div>
            <h2>Welcome Back</h2>
            <p>Log in to order your favorite food!</p>
        </div>

        <!-- Form -->
        <form action="LoginServlet" method="POST">
            
            <!-- Username -->
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required placeholder="Enter your username" autocomplete="username">
            </div>

            <!-- Password with Pure CSS Show/Hide Toggle -->
            <div class="form-group">
                <label for="password">Password</label>
                <div class="password-container">
                    <input type="checkbox" id="togglePassword" class="toggle-password">
                    <input type="password" id="password" name="password" required placeholder="Enter your password" autocomplete="current-password">
                    <label for="togglePassword" class="toggle-label"></label>
                </div>
            </div>

            <!-- Submit Button -->
            <button type="submit" class="submit-btn">Log In</button>
        </form>

        <!-- Footer -->
        <div class="form-footer">
            Don't have an account? <a href="signup.jsp">Sign Up</a>
        </div>
    </div>

</body>
</html>