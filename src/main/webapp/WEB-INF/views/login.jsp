<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href=${applicationScope.get("mainCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("normalizeCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("loginCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("productsCss")}/>
    <title>Login</title>
</head>
<body>
<c:if test="${(param.error != null) || (param.logout != null) || (param.accessDenied != null)}">
<div id="status">
    <c:if test="${param.error != null}">
        Invalid username and password.<br>
    </c:if>
    <c:if test="${param.logout != null}">
        You have been logged out successfully.<br>
    </c:if>
    <c:if test="${param.accessDenied != null}">
        Access Denied: You are not authorised!<br>
    </c:if>
</div>
</c:if>
<div class="form">
    <c:url var="loginUrl" value="/login"/>
    <form action="${loginUrl}" method="post">
        <label for="username">Username: </label>
        <input type="text" name="username" id="username" required><br>
        <label for="password">Password: </label>
        <input type="password" name="password" id="password" required><br>
        <input type="submit" value="Log in" class="addButton">
    </form>
</div>
<c:import url="include/footer.jsp"/>
</body>
</html>
