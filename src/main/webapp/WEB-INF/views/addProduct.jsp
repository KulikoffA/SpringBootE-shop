<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new product</title>
    <link rel="stylesheet" href=${applicationScope.get("mainCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("normalizeCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("loginCss")}/>
    <style>
        .form {
            width: 400px;
            height: 360px;
        }
        .form input[type=text], .form input[type=password], .form input[type=textarea] {
            width: 240px;
        }
    </style>
</head>
<body>
<div class="form">
    Add new product.<br><br>
    <form:form method="POST" modelAttribute="newProduct" enctype="multipart/form-data">
        <fieldset>
            <label for="productId">productId </label>
            <form:input path="productId" type="text" id="productId"/><br>

            <label for="brand">brand </label>
            <form:input path="brand" type="text" id="brand"/><br>

            <label for="name">name </label>
            <form:input path="name" type="text" id="name"/><br>

            <label for="price">price </label>
            <form:input path="price" type="text" id="price"/><br>

            <label for="description">description </label>
            <form:input path="description" type="textarea" id="description" rows="2"/><br>

            <label for="inStock">inStock </label>
            <form:input path="inStock" type="text" id="inStock"/><br>

            <label for="inStock">inOrder </label>
            <form:input path="inOrder" type="text" id="inOrder"/><br>

            <label for="category">category </label>
            <form:select path="category" type="text" id="category">
                <form:option value="smartphone"/>
                <form:option value="laptop"/>
                <form:option value="smartwatch"/>
                <form:option value="tv"/>
            </form:select><br>

            <label for="productImage">image </label>
            <form:input path="productImage" type="file" id="productImage"/><br>
            <br>
            <input type="submit" value="Add" id="btnAdd">
        </fieldset>

    </form:form>
</div>
<c:import url="include/footer.jsp"/>
</body>
</html>
