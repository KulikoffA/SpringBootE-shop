<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="productsWrap">

    <c:forEach var="product" items="${products}">
        <div class="singleProduct">
            <img src="/img/${product.category}/${product.name.concat('.png')}">
            <br>
                ${product.brand} ${product.name}<br><br>
            price: ${product.price} RUB <br>
                ${product.inStock} is available <br>
            description: ${product.description}
            <form action="" method="post">
                <input type="hidden" class="cartId" value="${cartId}" name="cartId">
                <input type="hidden" class="productId" value="${product.productId}" name="productId">
                <input type="hidden" class="quantity" value="1" name="quantity">
                <input class="addButton" type="button" value="Add to cart" >
            </form>
        </div>
    </c:forEach>

    <div id="brands">
        <ul>
            <c:forEach var="brand" items="${brands}">
                <li>
                    <a href="/eshop/${category}/${brand}">${brand}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div></div>

