<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

    <title>Welcome page</title>
    <c:url value="/css/main.css" var="mainCss" scope="application"/>
    <c:url value="/css/normalize.css" var="normalizeCss" scope="application"/>
    <c:url value="/css/products.css" var="productsCss" scope="application"/>
    <c:url value="/css/smartphones.css" var="phoneCss" scope="application"/>
    <c:url value="/css/laptops.css" var="laptopCss" scope="application"/>
    <c:url value="/css/tvs.css" var="tvCss" scope="application"/>
    <c:url value="/css/smartwatches.css" var="watchCss" scope="application"/>
    <c:url value="/css/login.css" var="loginCss" scope="application"/>

    <link rel="stylesheet" href=${applicationScope.get("mainCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("normalizeCss")}/>
</head>
<body>
<c:import url="include/header.jsp"/>
<div id="lvl1">
    <section class="smartphone">
        <div class="rotateIt"><a href="/eshop/smartphone">Smartphone</a></div>
        <div class="brands">
            <ul>
                <li>Xiaomi</li>
                <li>Meizu</li>
                <li>Hauwei</li>
                <li>OnePlus</li>
                <li>Lg</li>
            </ul>
        </div>
        <div class="categoryPic">
            <img src="/img/Mi6.png">
        </div>
    </section>
    <section class="laptop">
        <div class="rotateIt"><a href="/eshop/laptop">Laptop</a></div>
        <div class="brands">
            <ul>
                <li>MSI</li>
                <li>Lenovo</li>
                <li>Asus</li>
                <li>Apple</li>
                <li>Dell</li>
            </ul>
        </div>
        <div class="categoryPic">
            <img src="/img/laptop.png">
        </div>
    </section>
</div>

<div id="lvl2">
    <section class="smartwatch">
        <div class="rotateIt"><a href="/eshop/smartwatch">Smartwatch</a></div>
        <div class="brands">
            <ul>
                <li>Apple</li>
                <li>Xiaomi</li>
                <li>Samsung</li>
                <li>Garmin</li>
                <li>Motorola</li>
            </ul>
        </div>
        <div class="categoryPic">
            <img src="/img/smartwatch.png">
        </div>
    </section>

    <section class="tv">
        <div class="rotateIt"><a href="/eshop/tv">TV</a></div>
        <div class="brands">
            <ul>
                <li>Sony</li>
                <li>LG</li>
                <li>Sharp</li>
                <li>BBK</li>
                <li>Toshiba</li>
            </ul>
        </div>
        <div class="categoryPic">
            <img src="/img/tv.png">
        </div>
    </section>
</div>
<c:import url="include/footer.jsp"/>
</body>
</html>
