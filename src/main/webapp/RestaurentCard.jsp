<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foodie - Restaurants</title>
<style>
        /* Global Reset */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background-color: #fdfbf7;
            padding: 40px 20px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
        }

        .page-title {
            color: #1f2937;
            font-size: 32px;
            font-weight: 700;
            margin-bottom: 30px;
            text-align: center;
        }

        /* Responsive Grid System */
        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 30px;
        }

        /* Restaurant Card Styling */
        .restaurant-card {
            background-color: #ffffff;
            border-radius: 16px;
            overflow: hidden;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
            border: 1px solid #ffe4e6;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
        }

        /* Hover Animation Effect */
        .restaurant-card:hover {
            transform: translateY(-6px);
            box-shadow: 0 12px 24px rgba(244, 63, 94, 0.15);
        }

        /* Image Container to maintain proper aspect ratio */
        .card-image-wrapper {
            width: 100%;
            height: 200px;
            overflow: hidden;
            background-color: #f3f4f6;
        }

        .card-image-wrapper img {
            width: 100%;
            height: 100%;
            object-fit: cover; /* Image stretch nahi hogi, perfectly crop hogi */
            transition: transform 0.5s ease;
        }

        .restaurant-card:hover .card-image-wrapper img {
            transform: scale(1.08); /* Zoom-in effect on hover */
        }

        /* Card Content Area */
        .card-content {
            padding: 20px;
        }

        .restaurant-name {
            font-size: 20px;
            color: #1f2937;
            font-weight: 700;
            margin-bottom: 8px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis; /* Bada naam hone par dots (...) dikhenge */
        }

        .restaurant-meta {
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 14px;
            color: #6b7280;
            margin-top: 12px;
            padding-top: 12px;
            border-top: 1px solid #f3f4f6;
        }

        .rating-badge {
            background-color: #f43f5e;
            color: #ffffff;
            padding: 4px 8px;
            border-radius: 6px;
            font-weight: 600;
            font-size: 12px;
        }

        .cuisine-type {
            font-size: 14px;
            color: #4b5563;
            font-style: italic;
        }
    </style>
</head>
<body>
	<div class="container">
        <h1 class="page-title">Popular Restaurants</h1>

        <div class="restaurant-grid">
            
            <%-- 
               [TEMPORARY DUMMY DATA FOR VIEW TESTING]
               Abhi view test karne ke liye ye 6 baar static cards generate karega.
               Jab Controller ready ho jaye, toh bas is niche wale <c:forEach> line ko badal dena.
            --%>
            <c:forEach var="i" begin="1" end="6">
                <div class="restaurant-card">
                    <div class="card-image-wrapper">
                        <img src="https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?w=500" alt="Restaurant Image">
                    </div>
                    <div class="card-content">
                        <h3 class="restaurant-name">Restaurant Name ${i}</h3>
                        <p class="cuisine-type">North Indian, Fast Food</p>
                        <div class="restaurant-meta">
                            <span class="rating-badge">★ 4.5</span>
                            <span>30 mins</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
            
            <%--
               [FUTURE CONTROLLER INTEGRATION CODE]
               Jab aapka controller list bhejega, toh aap upar wale loop ko hata kar ise active kar dena:
               
               <c:forEach var="res" items="${restaurantList}">
                    <div class="restaurant-card">
                        <div class="card-image-wrapper">
                            <img src="${res.imagePath}" alt="${res.name}">
                        </div>
                        <div class="card-content">
                            <h3 class="restaurant-name">${res.name}</h3>
                            <p class="cuisine-type">${res.cuisineType}</p>
                            <div class="restaurant-meta">
                                <span class="rating-badge">★ ${res.rating}</span>
                                <span>${res.eta}</span>
                            </div>
                        </div>
                    </div>
               </c:forEach>
            --%>

        </div>
    </div>
</body>
</html>