<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Smartphones</title>
    <link rel="stylesheet" href=${applicationScope.get("mainCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("normalizeCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("productsCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("phoneCss")}/>

    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/cartUpdate.js"></script>

</head>
<body>
<jsp:include page="include/header.jsp"/>
<jsp:include page="include/productsLayout.jsp"/>
<c:import url="include/footer.jsp"/>
</body>
</html>
