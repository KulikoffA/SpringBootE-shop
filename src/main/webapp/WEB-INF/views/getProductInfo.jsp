<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product info by ID</title>
    <link rel="stylesheet" href=${applicationScope.get("mainCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("normalizeCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("loginCss")}/>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/controller.js"></script>
    <style>
        #productInfo {
            margin-top: 20px;
            padding: 20px;
            border-radius: 2px;
            border: 2px solid #299a33;
        }
        .form {
            width: 500px;
            height: auto;
        }
        form> a:link,form> a:visited,form> a:active {
            padding: 0;
        }
    </style>
</head>
<body>
<div class="form">
    <form>
        <a href="#" id="getInfo">Get product info by id.</a>
        <input type="text" id="productId">
        <div id="productInfo"></div>
    </form>
</div>
<c:import url="include/footer.jsp"/>
</body>
</html>
