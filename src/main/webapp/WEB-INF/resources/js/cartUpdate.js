$(document).ready(function () {
    $('.addButton').on('click', function () {
        var cartId = $(this).closest('form').find('.cartId').val();
        var productId = $(this).closest('form').find('.productId').val();
        var quantity = $(this).closest('form').find('.quantity').val();

        var json = {};
        json["cartId"] = cartId;
        json["productId"] = productId;
        json["quantity"] = quantity;

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/rest/product/add",
            dataType: "json",
            data: JSON.stringify(json),
            contentType: "application/json"
        }).then(function (data) {
            $('#cartCount').text(data[0]);
            $('#totalPrice').text(data[1]);
        });
    });
});