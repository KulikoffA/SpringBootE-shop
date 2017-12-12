<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" href=${applicationScope.get("mainCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("normalizeCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("productsCss")}/>
    <link rel="stylesheet" href=${applicationScope.get("loginCss")}/>

    <link rel="stylesheet" href="/css/checkout.css"/>

    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/checkoutUpdate.js"></script>
    <script>
        $(document).ready(function () {
            $('#order').on('click', function () {
                event.preventDefault();

                var cartID = $(this).closest('form').find('#cartID').val();
                var sum = $(this).closest('form').find('#totalSum').val();
                var email = $(this).closest('form').find('#email').val();

                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/email/send?cartID="+cartID+"&totalPrice="+sum+"&email="+email
                });

                $.ajax({
                    type: "DELETE",
                    url: "http://localhost:8080/rest/cart/update/deletecart?cartId="+cartID
                }).then(function () {
                    $('#cartCount').text(0);
                    $('#totalPrice').text(0);
                });

                window.location.replace("http://localhost:8080/eshop");
            });
        });
    </script>
    <style>
        .dataProduct {
            display: none;
        }
    </style>

</head>
<body>
<jsp:include page="include/header.jsp"/>
<div id="cartInfo">
    <table>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Sum</th>
            <th></th>
        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td>
                    ${item.brand} ${item.name}<br>

                    <div class="dataProduct"><span class="cartId">${cartId}</span><br>
                    <span class="productId">${item.productId}</span><br></div>
                </td>
                <td class="price">
                    ${item.price}
                </td>
                <td class="quantityWrap">
                    <span class="quantity">${item.quantity}</span>
                    <a class="increaseQuantity" href="#">+</a> /
                    <a class="decreaseQuantity" href="#">-</a>
                </td>
                <td class="sum">
                    ${item.price * item.quantity}
                </td>
                <td>
                    <a class="deleteItem" href="#">X</a>
                </td>
            </tr>

        </c:forEach>
    </table>

    <br>
    Total is: <span id="total">${price}</span> RUB
    <form>
        <input type="hidden" id="cartID" name="cartID" value="${sessionScope.get("cartId")}">
        <input type="hidden" id="totalSum" name="totalSum" value="${price}">
        <br> Email ukazhi plz --><input type="email" id="email" name="email" required="required" autocomplete="off"> <br>
        <input type="submit" value="Send order" id="order" class="addButton">
    </form>
</div>
<c:import url="include/footer.jsp"/>

</body>
</html>
