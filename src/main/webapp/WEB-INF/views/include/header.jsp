<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="menuWrapper">
    <div class="menu">
        <div class="menuTab one"><a href="/eshop/smartphone">Smartphone</a></div>
        <div class="menuTab two"><a href="/eshop/laptop">Laptop</a></div>
        <div class="menuTab three"><a href="/eshop/smartwatch">Smartwatch</a></div>
        <div class="menuTab four"><a href="/eshop/tv">TV</a></div>
    </div>
</div>

<div id="cart">
    <a href="/eshop/cart/checkout"><img id="cartImg" src="/img/cart.png"></a>
    Items in cart: <span id="cartCount">${itemsCount}</span><br>
    Total price: <span id="totalPrice">${price}</span> rub
</div>
