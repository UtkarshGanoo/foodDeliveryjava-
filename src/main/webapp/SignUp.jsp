<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foodie - Sign Up</title>
<style>
        /* Global Styles */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background: linear-gradient(135deg, #fdfbf7 0%, #ffe4e6 100%);
            min-height: 100-vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }

        /* Card Container */
        .signup-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 16px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
            width: 100%;
            max-width: 420px;
            border: 1px solid #ffe4e6;
        }

        /* Header Section */
        .brand-header {
            text-align: center;
            margin-bottom: 24px;
        }

        .brand-icon {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            background-color: #f43f5e;
            color: white;
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 12px;
            box-shadow: 0 4px 6px rgba(244, 63, 94, 0.2);
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

        /* Form Controls */
        .form-group {
            margin-bottom: 16px;
        }

        .form-group label {
            display: block;
            font-size: 12px;
            font-weight: 600;
            color: #4b5563;
            text-transform: uppercase;
            margin-bottom: 6px;
            letter-spacing: 0.5px;
        }

        .form-group input {
            width: 100%;
            padding: 10px 14px;
            border: 1px solid #e5e7eb;
            border-radius: 8px;
            font-size: 14px;
            color: #374151;
            outline: none;
            transition: border-color 0.2s ease, box-shadow 0.2s ease;
        }

        /* Input Focus Effect */
        .form-group input:focus {
            border-color: #f43f5e;
            box-shadow: 0 0 0 3px rgba(244, 63, 94, 0.1);
        }

        /* Submit Button */
        .submit-btn {
            width: 100%;
            padding: 12px;
            background-color: #f43f5e;
            color: #ffffff;
            border: none;
            border-radius: 8px;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            transition: background-color 0.2s ease, transform 0.1s ease;
            box-shadow: 0 4px 6px rgba(244, 63, 94, 0.2);
            margin-top: 8px;
        }

        .submit-btn:hover {
            background-color: #e11d48;
        }

        .submit-btn:active {
            transform: scale(0.98);
        }

        /* Footer Link */
        .form-footer {
            text-align: center;
            margin-top: 20px;
            font-size: 13px;
            color: #6b7280;
        }

        .form-footer a {
            color: #f43f5e;
            text-decoration: none;
            font-weight: 500;
        }

        .form-footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="signup-container">
        <!-- Header -->
        <div class="brand-header">
            <div class="brand-icon">F</div>
            <h2>Create Account</h2>
            <p>Join Foodie today for delicious experiences!</p>
        </div>

        <!-- Form -->
        <form action="/#" method="POST">
            
            <!-- Name -->
            <div class="form-group">
                <label for="name">Full Name</label>
                <input type="text" id="name" name="name" required placeholder="Utkarsh Ganoo">
            </div>

            <!-- Email -->
            <div class="form-group">
                <label for="email">Email Address</label>
                <input type="email" id="email" name="email" required placeholder="name@gmail.com">
            </div>

            <!-- Phone -->
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="tel" id="phone" name="phone" required placeholder="9876543210" pattern="[0-9]{10}" title="Please enter a valid 10-digit number">
            </div>

            <!-- Address -->
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" required placeholder="123 Street, City">
            </div>

            <!-- Username -->
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required placeholder="Ut207456">
            </div>

            <!-- Password -->
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required placeholder="145@Abc">
            </div>

            <!-- Submit -->
            <button type="submit" class="submit-btn">Sign Up</button>
        </form>

        <!-- Footer -->
        <div class="form-footer">
            Already have an account? <a href="login.jsp">Log In</a>
        </div>
    </div>

</body>
</html>