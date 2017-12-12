<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin panel</title>
    <link rel="stylesheet" href=${applicationScope.get("mainCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("normalizeCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("loginCss")}/>
    <script src="../resource/js/jquery-3.2.1.min.js"></script>
    <script src="../resource/js/controller.js"></script>
    <style>
        #productInfo {
            padding: 20px;
            border-radius: 2px;
            border: 2px solid #2bc239;
        }
        .form {
            width: 600px;
            height: auto;
        }
    </style>
</head>
<body>
<div class="form">
<form>
    <a href="/manager/add">Add new product +</a><br>

    <a href="/manager/del">Delete product -</a><br>

    <a href="/manager/info" >Get product info by id</a><br>
</form>
</div>
<c:import url="include/footer.jsp"/>
</body>
</html>
