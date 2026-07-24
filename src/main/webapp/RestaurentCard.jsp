<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.foodie.model.Restaurant" %>
<%
    List<Restaurant> restaurantList = (List<Restaurant>) request.getAttribute("restaurantList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foodie - Restaurants</title>
    <!-- FontAwesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <style>
        /* Global Reset & Base Styles */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        /* Animated Background (Same Theme as Login/Signup) */
        body {
            background: linear-gradient(-45deg, #fdfbf7, #ffe4e6, #fecdd3, #fff1f2);
            background-size: 400% 400%;
            animation: gradientBG 12s ease infinite;
            min-height: 100vh;
            color: #1f2937;
            padding-bottom: 50px;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        /* Top Sticky Header */
        .header-bar {
            background: rgba(255, 255, 255, 0.9);
            backdrop-filter: blur(10px);
            border-bottom: 1px solid #ffe4e6;
            position: sticky;
            top: 0;
            z-index: 100;
            box-shadow: 0 4px 15px rgba(244, 63, 94, 0.05);
        }

        .header-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 16px 20px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            gap: 20px;
        }

        .logo {
            font-size: 24px;
            font-weight: 800;
            color: #f43f5e;
            text-decoration: none;
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .brand-icon {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            width: 40px;
            height: 40px;
            border-radius: 50%;
            background-color: #f43f5e;
            color: #ffffff;
            font-size: 18px;
            font-weight: bold;
            box-shadow: 0 4px 8px rgba(244, 63, 94, 0.25);
        }

        /* Search Box Styling */
        .search-box {
            position: relative;
            flex: 1;
            max-width: 450px;
        }

        .search-box input {
            width: 100%;
            padding: 11px 16px 11px 42px;
            border-radius: 25px;
            border: 1.5px solid #e5e7eb;
            outline: none;
            font-size: 14px;
            background-color: #fafafa;
            color: #374151;
            transition: all 0.25s ease;
        }

        .search-box input:focus {
            background-color: #ffffff;
            border-color: #f43f5e;
            box-shadow: 0 0 0 4px rgba(244, 63, 94, 0.12);
        }

        .search-box i {
            position: absolute;
            left: 16px;
            top: 50%;
            transform: translateY(-50%);
            color: #9ca3af;
            transition: color 0.2s ease;
        }

        .search-box:focus-within i {
            color: #f43f5e;
        }

        /* Hero / Welcome Banner */
        .hero-banner {
            max-width: 1200px;
            margin: 24px auto;
            background: linear-gradient(135deg, #f43f5e 0%, #e11d48 100%);
            border-radius: 20px;
            padding: 36px 32px;
            color: #ffffff;
            box-shadow: 0 10px 25px rgba(244, 63, 94, 0.25);
            position: relative;
            overflow: hidden;
        }

        .hero-banner h1 {
            font-size: 30px;
            font-weight: 800;
            margin-bottom: 8px;
        }

        .hero-banner p {
            color: #ffe4e6;
            font-size: 15px;
        }

        /* Main Container & Layout */
        .main-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        .section-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 24px;
        }

        .section-title {
            font-size: 22px;
            font-weight: 700;
            color: #1f2937;
        }

        .count-badge {
            font-size: 13px;
            color: #f43f5e;
            background: #ffe4e6;
            padding: 5px 14px;
            border-radius: 20px;
            font-weight: 700;
            border: 1px solid rgba(244, 63, 94, 0.2);
        }

        /* Restaurant Grid Layout */
        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(270px, 1fr));
            gap: 24px;
        }

        /* Interactive Card Styling */
        .restaurant-card {
            background: #ffffff;
            border-radius: 18px;
            overflow: hidden;
            border: 1px solid rgba(254, 205, 211, 0.6);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.04);
            transition: all 0.35s cubic-bezier(0.4, 0, 0.2, 1);
            text-decoration: none;
            color: inherit;
            display: flex;
            flex-direction: column;
        }

        .restaurant-card:hover {
            transform: translateY(-6px);
            box-shadow: 0 16px 32px rgba(244, 63, 94, 0.15);
            border-color: #f43f5e;
        }

        .card-img-wrapper {
            position: relative;
            width: 100%;
            height: 180px;
            background-color: #fff1f2;
            overflow: hidden;
        }

        .card-img-wrapper img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            transition: transform 0.5s ease;
        }

        .restaurant-card:hover .card-img-wrapper img {
            transform: scale(1.08);
        }

        /* Rating Tag */
        .rating-tag {
            position: absolute;
            top: 12px;
            right: 12px;
            background: rgba(255, 255, 255, 0.95);
            padding: 4px 10px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: 700;
            color: #1f2937;
            display: flex;
            align-items: center;
            gap: 4px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        .rating-tag i {
            color: #f59e0b;
        }

        /* Card Content */
        .card-body {
            padding: 18px;
            display: flex;
            flex-direction: column;
            flex: 1;
            justify-content: space-between;
        }

        .restaurant-title {
            font-size: 18px;
            font-weight: 700;
            color: #1f2937;
            margin-bottom: 6px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            transition: color 0.2s ease;
        }

        .restaurant-card:hover .restaurant-title {
            color: #f43f5e;
        }

        .cuisine-type {
            font-size: 13px;
            color: #6b7280;
            margin-bottom: 16px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .card-footer {
            padding-top: 12px;
            border-top: 1px solid #ffe4e6;
            display: flex;
            align-items: center;
            justify-content: space-between;
            font-size: 13px;
            color: #6b7280;
        }

        .eta-info {
            display: flex;
            align-items: center;
            gap: 6px;
            font-weight: 600;
        }

        .eta-info i {
            color: #f43f5e;
        }

        .view-link {
            color: #f43f5e;
            font-weight: 700;
            display: flex;
            align-items: center;
            gap: 4px;
            transition: transform 0.2s ease;
        }

        .restaurant-card:hover .view-link {
            transform: translateX(3px);
        }

        /* Empty State */
        .empty-state {
            grid-column: 1 / -1;
            text-align: center;
            padding: 60px 20px;
            color: #6b7280;
            background: #ffffff;
            border-radius: 20px;
            border: 1px solid #ffe4e6;
        }

        .empty-state i {
            font-size: 48px;
            color: #f43f5e;
            margin-bottom: 12px;
            opacity: 0.8;
        }

        .empty-state p {
            font-size: 16px;
            font-weight: 600;
        }
    </style>
</head>
<body>

    <!-- Top Header -->
    <header class="header-bar">
        <div class="header-container">
            <a href="#" class="logo">
                <span class="brand-icon">F</span> Foodie
            </a>
            <div class="search-box">
                <i class="fa-solid fa-magnifying-glass"></i>
                <input type="text" id="searchInput" onkeyup="filterRestaurants()" placeholder="Search restaurant or cuisine...">
            </div>
        </div>
    </header>

    <div class="main-container">
        <!-- Hero Banner -->
        <div class="hero-banner">
            <h1>Discover Best Food & Drinks</h1>
            <p>Explore top rated restaurants around you with fast doorstep delivery.</p>
        </div>

        <!-- Section Info Header -->
        <div class="section-header">
            <h2 class="section-title">All Restaurants</h2>
            <span class="count-badge"><%= (restaurantList != null) ? restaurantList.size() : 0 %> Places</span>
        </div>

        <!-- Grid Container -->
        <div class="restaurant-grid" id="restaurantGrid">
            <%
                if (restaurantList != null && !restaurantList.isEmpty()) {
                    for (Restaurant restaurant : restaurantList) {
            %>
                <a href="MenuServlet?restaurantId=<%= restaurant.getRestaurant_Id() %>" 
                   class="restaurant-card"
                   data-name="<%= restaurant.getRestaurant_Name().toLowerCase() %>"
                   data-cuisine="<%= restaurant.getCuisineType() != null ? restaurant.getCuisineType().toLowerCase() : "" %>">
                    
                    <div class="card-img-wrapper">
                        <img src="<%= restaurant.getImage_path() %>" 
                             alt="<%= restaurant.getRestaurant_Name() %>">
                        
                        <div class="rating-tag">
                            <i class="fa-solid fa-star"></i>
                            <span><%= restaurant.getRating() %></span>
                        </div>
                    </div>

                    <div class="card-body">
                        <div>
                            <div class="restaurant-title"><%= restaurant.getRestaurant_Name() %></div>
                            <div class="cuisine-type"><%= restaurant.getCuisineType() %></div>
                        </div>

                        <div class="card-footer">
                            <div class="eta-info">
                                <i class="fa-regular fa-clock"></i>
                                <span><%= restaurant.getETA() %></span>
                            </div>
                            <div class="view-link">
                                View Menu <i class="fa-solid fa-chevron-right" style="font-size: 10px;"></i>
                            </div>
                        </div>
                    </div>
                </a>
            <%
                    }
                } else {
            %>
                <div class="empty-state">
                    <i class="fa-solid fa-store-slash"></i>
                    <p>No restaurants found at the moment.</p>
                </div>
            <%
                }
            %>
        </div>
    </div>

    <!-- Client Search Filter JavaScript -->
    <script>
        function filterRestaurants() {
            const query = document.getElementById('searchInput').value.toLowerCase();
            const cards = document.querySelectorAll('.restaurant-card');

            cards.forEach(card => {
                const name = card.getAttribute('data-name') || '';
                const cuisine = card.getAttribute('data-cuisine') || '';

                if (name.includes(query) || cuisine.includes(query)) {
                    card.style.display = 'flex';
                } else {
                    card.style.display = 'none';
                }
            });
        }
    </script>
</body>
</html>