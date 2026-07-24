<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.foodie.model.Menu"%>
<%
    List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foodie - Delicious Menu</title>
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <style>
        /* Global Reset & Base Styling */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        /* Animated Background Theme */
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

        /* Header Bar */
        .header-bar {
            background: rgba(255, 255, 255, 0.95);
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

        /* Search Box */
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
        }

        /* Cart Button in Header */
        .cart-btn {
            background-color: #f43f5e;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            border-radius: 25px;
            font-weight: 600;
            font-size: 14px;
            cursor: pointer;
            display: flex;
            align-items: center;
            gap: 8px;
            box-shadow: 0 4px 12px rgba(244, 63, 94, 0.25);
            transition: all 0.25s ease;
        }

        .cart-btn:hover {
            background-color: #e11d48;
            transform: translateY(-1px);
            box-shadow: 0 6px 16px rgba(225, 29, 72, 0.35);
        }

        .cart-count {
            background-color: #ffffff;
            color: #f43f5e;
            padding: 2px 8px;
            border-radius: 12px;
            font-size: 12px;
            font-weight: 800;
        }

        /* Hero Banner */
        .hero-banner {
            max-width: 1200px;
            margin: 24px auto;
            background: linear-gradient(135deg, #f43f5e 0%, #e11d48 100%);
            border-radius: 20px;
            padding: 36px 32px;
            color: #ffffff;
            box-shadow: 0 10px 25px rgba(244, 63, 94, 0.25);
        }

        .hero-banner h2 {
            font-size: 30px;
            font-weight: 800;
            margin-bottom: 8px;
        }

        .hero-banner p {
            color: #ffe4e6;
            font-size: 15px;
        }

        /* Main Container */
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

        /* Menu Grid Layout */
        .menu-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(270px, 1fr));
            gap: 24px;
        }

        /* Menu Card Styling */
        .menu-card {
            background: #ffffff;
            border-radius: 18px;
            overflow: hidden;
            border: 1px solid rgba(254, 205, 211, 0.6);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.04);
            transition: all 0.35s cubic-bezier(0.4, 0, 0.2, 1);
            display: flex;
            flex-direction: column;
        }

        .menu-card:hover {
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

        .menu-card:hover .card-img-wrapper img {
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

        .menu-title {
            font-size: 18px;
            font-weight: 700;
            color: #1f2937;
            margin-bottom: 6px;
            transition: color 0.2s ease;
        }

        .menu-card:hover .menu-title {
            color: #f43f5e;
        }

        .menu-desc {
            font-size: 13px;
            color: #6b7280;
            margin-bottom: 16px;
            line-height: 1.4;
            display: -webkit-box;
            -webkit-line-clamp: 2;
            -webkit-box-orient: vertical;
            overflow: hidden;
        }

        .card-footer {
            padding-top: 12px;
            border-top: 1px solid #ffe4e6;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .price-label {
            font-size: 10px;
            color: #9ca3af;
            text-transform: uppercase;
            font-weight: 700;
            letter-spacing: 0.5px;
        }

        .price-value {
            font-size: 20px;
            font-weight: 800;
            color: #1f2937;
        }

        .add-btn {
            background-color: #1f2937;
            color: #ffffff;
            border: none;
            padding: 8px 16px;
            border-radius: 10px;
            font-size: 13px;
            font-weight: 700;
            cursor: pointer;
            display: flex;
            align-items: center;
            gap: 6px;
            transition: all 0.2s ease;
        }

        .add-btn:hover {
            background-color: #f43f5e;
            transform: scale(1.02);
            box-shadow: 0 4px 10px rgba(244, 63, 94, 0.3);
        }

        .add-btn:active {
            transform: scale(0.96);
        }

        /* Slide-over Cart Drawer */
        .cart-drawer {
            position: fixed;
            inset: 0;
            z-index: 1000;
            visibility: hidden;
            opacity: 0;
            transition: all 0.3s ease;
        }

        .cart-drawer.open {
            visibility: visible;
            opacity: 1;
        }

        .cart-overlay {
            position: absolute;
            inset: 0;
            background: rgba(0, 0, 0, 0.4);
            backdrop-filter: blur(4px);
        }

        .cart-content {
            position: absolute;
            right: 0;
            top: 0;
            height: 100%;
            width: 100%;
            max-width: 400px;
            background: #ffffff;
            box-shadow: -10px 0 30px rgba(0, 0, 0, 0.15);
            padding: 24px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            transform: translateX(100%);
            transition: transform 0.3s ease;
        }

        .cart-drawer.open .cart-content {
            transform: translateX(0);
        }

        .cart-header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding-bottom: 16px;
            border-bottom: 1px solid #ffe4e6;
        }

        .cart-header h3 {
            font-size: 20px;
            font-weight: 700;
            color: #1f2937;
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .close-cart {
            background: none;
            border: none;
            font-size: 20px;
            color: #9ca3af;
            cursor: pointer;
        }

        .close-cart:hover {
            color: #f43f5e;
        }

        .cart-items-list {
            padding: 16px 0;
            flex: 1;
            overflow-y: auto;
        }

        .cart-item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            background-color: #fff1f2;
            padding: 12px;
            border-radius: 12px;
            margin-bottom: 10px;
            border: 1px solid rgba(254, 205, 211, 0.6);
        }

        .cart-item-title {
            font-weight: 700;
            font-size: 14px;
            color: #1f2937;
        }

        .cart-item-price {
            font-size: 12px;
            color: #f43f5e;
            font-weight: 600;
        }

        .qty-controls {
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .qty-btn {
            width: 26px;
            height: 26px;
            border-radius: 6px;
            background: #ffffff;
            border: 1px solid #e5e7eb;
            cursor: pointer;
            font-weight: bold;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .qty-btn:hover {
            border-color: #f43f5e;
            color: #f43f5e;
        }

        .cart-footer {
            padding-top: 16px;
            border-top: 1px solid #ffe4e6;
        }

        .total-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 16px;
        }

        .checkout-btn {
            width: 100%;
            padding: 14px;
            background-color: #f43f5e;
            color: #ffffff;
            border: none;
            border-radius: 12px;
            font-size: 16px;
            font-weight: 700;
            cursor: pointer;
            box-shadow: 0 4px 12px rgba(244, 63, 94, 0.25);
            transition: all 0.2s ease;
        }

        .checkout-btn:hover {
            background-color: #e11d48;
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
    </style>
</head>
<body>

    <!-- Header Section -->
    <header class="header-bar">
        <div class="header-container">
            <!-- Logo -->
            <a href="home.jsp" class="logo">
                <span class="brand-icon">F</span> Foodie
            </a>

            <!-- Search Bar -->
            <div class="search-box">
                <i class="fa-solid fa-magnifying-glass"></i>
                <input type="text" id="searchInput" onkeyup="filterMenu()" placeholder="Dish search karein...">
            </div>

            <!-- Cart Button -->
            <button onclick="toggleCartDrawer()" class="cart-btn">
                <i class="fa-solid fa-cart-shopping"></i>
                <span>Cart</span>
                <span id="cartCount" class="cart-count">0</span>
            </button>
        </div>
    </header>

    <!-- Main Content -->
    <main class="main-container">
        
        <!-- Welcome Banner -->
        <div class="hero-banner">
            <h2>Aapka Favorite Food Bas Ek Click Door!</h2>
            <p>Freshly cooked delicious meals tailored for your cravings.</p>
        </div>

        <!-- Section Title Header -->
        <div class="section-header">
            <h3 class="section-title">Explore Menu</h3>
            <span class="count-badge"><%= (menuList != null) ? menuList.size() : 0 %> Items</span>
        </div>

        <!-- Menu Cards Grid -->
        <div class="menu-grid" id="menuGrid">
            <%
                if (menuList != null && !menuList.isEmpty()) {
                    for (Menu menu : menuList) {
            %>
            <div class="menu-card" data-name="<%= menu.getMenuItem_Name().toLowerCase() %>">
                
                <!-- Image Wrapper -->
                <div class="card-img-wrapper">
                    <img src="<%= menu.getMenuItem_ImagePath() %>" alt="<%= menu.getMenuItem_Name() %>">
                    
                    <!-- Rating Badge -->
                    <div class="rating-tag">
                        <i class="fa-solid fa-star"></i>
                        <span><%= menu.getMenuItem_Rating() %></span>
                    </div>
                </div>

                <!-- Details Wrapper -->
                <div class="card-body">
                    <div>
                        <div class="menu-title"><%= menu.getMenuItem_Name() %></div>
                        <p class="menu-desc"><%= menu.getMenuItem_Description() %></p>
                    </div>

                    <div class="card-footer">
                        <div>
                            <span class="price-label">Price</span>
                            <div class="price-value">₹<%= menu.getMenuItem_Cost() %></div>
                        </div>
                        <button onclick="addToCart('<%= menu.getMenuItem_Name().replace("'", "\\'") %>', <%= menu.getMenuItem_Cost() %>)" 
                                class="add-btn">
                            <i class="fa-solid fa-plus"></i>
                            <span>Add</span>
                        </button>
                    </div>
                </div>
            </div>
            <%
                    }
                } else {
            %>
            <div class="empty-state">
                <i class="fa-solid fa-utensils"></i>
                <p>Abhi koi menu items available nahi hain.</p>
            </div>
            <%
                }
            %>
        </div>
    </main>

    <!-- Slide-over Cart Drawer -->
    <div id="cartDrawer" class="cart-drawer">
        <div class="cart-overlay" onclick="toggleCartDrawer()"></div>
        <div class="cart-content">
            <div>
                <div class="cart-header">
                    <h3>
                        <i class="fa-solid fa-bag-shopping" style="color: #f43f5e;"></i>
                        <span>Aapka Order</span>
                    </h3>
                    <button onclick="toggleCartDrawer()" class="close-cart">
                        <i class="fa-solid fa-xmark"></i>
                    </button>
                </div>
                
                <!-- Cart Items Container -->
                <div id="cartItemsList" class="cart-items-list">
                    <p style="text-align: center; color: #9ca3af; padding: 30px 0; font-size: 14px;">Cart khali hai. Kuch tasty add karein!</p>
                </div>
            </div>

            <!-- Cart Footer -->
            <div class="cart-footer">
                <div class="total-row">
                    <span style="color: #6b7280; font-weight: 600;">Grand Total</span>
                    <span id="cartTotal" style="font-size: 22px; font-weight: 800; color: #1f2937;">₹0</span>
                </div>
                <button class="checkout-btn">Checkout Fast</button>
            </div>
        </div>
    </div>

    <!-- Client Interactive JavaScript -->
    <script>
        let cart = [];

        // Add to Cart Logic
        function addToCart(name, price) {
            const existingIndex = cart.findIndex(item => item.name === name);
            if (existingIndex > -1) {
                cart[existingIndex].qty += 1;
            } else {
                cart.push({ name: name, price: price, qty: 1 });
            }
            updateCartUI();
        }

        // Update Cart UI
        function updateCartUI() {
            const cartItemsList = document.getElementById('cartItemsList');
            const cartCount = document.getElementById('cartCount');
            const cartTotal = document.getElementById('cartTotal');

            const totalQty = cart.reduce((acc, item) => acc + item.qty, 0);
            const totalPrice = cart.reduce((acc, item) => acc + (item.price * item.qty), 0);

            cartCount.innerText = totalQty;
            cartTotal.innerText = '₹' + totalPrice;

            if (cart.length === 0) {
                cartItemsList.innerHTML = '<p style="text-align: center; color: #9ca3af; padding: 30px 0; font-size: 14px;">Cart khali hai. Kuch tasty add karein!</p>';
                return;
            }

            cartItemsList.innerHTML = cart.map((item, index) => `
                <div class="cart-item">
                    <div>
                        <div class="cart-item-title">${item.name}</div>
                        <div class="cart-item-price">₹${item.price} x ${item.qty}</div>
                    </div>
                    <div class="qty-controls">
                        <button onclick="changeQty(${index}, -1)" class="qty-btn">-</button>
                        <span style="font-weight: 700; font-size: 14px;">${item.qty}</span>
                        <button onclick="changeQty(${index}, 1)" class="qty-btn">+</button>
                    </div>
                </div>
            `).join('');
        }

        function changeQty(index, delta) {
            cart[index].qty += delta;
            if (cart[index].qty <= 0) {
                cart.splice(index, 1);
            }
            updateCartUI();
        }

        // Search Filter
        function filterMenu() {
            const query = document.getElementById('searchInput').value.toLowerCase();
            const cards = document.querySelectorAll('.menu-card');

            cards.forEach(card => {
                const name = card.getAttribute('data-name');
                if (name && name.includes(query)) {
                    card.style.display = 'flex';
                } else {
                    card.style.display = 'none';
                }
            });
        }

        // Toggle Cart Drawer
        function toggleCartDrawer() {
            const drawer = document.getElementById('cartDrawer');
            drawer.classList.toggle('open');
        }
    </script>
</body>
</html>