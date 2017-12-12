<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete by id</title>
    <link rel="stylesheet" href=${applicationScope.get("mainCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("normalizeCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("loginCss")}/>
</head>
<body>
<div class="form">
    <form method="POST" action="/manager/del">
        <label for="productId">Id to delete: </label>
        <input type="text" name="productId" id="productId">
        <br>
        <input type="submit" value="DELETE" id="btnAdd">
    </form>
</div>
<c:import url="include/footer.jsp"/>
</body>
</html>
