$(document).ready(function () {
    $('.increaseQuantity').on('click', function () {

        var quantity = $(this).closest('.quantityWrap').find('.quantity');
        quantity.text(+quantity.text() + 1);
        var updatedQuantity = quantity.text();
        updatePrice(this, updatedQuantity);

        var json = {};
        var cartId = $(this).closest('tr').find('.cartId').text();
        var productId = $(this).closest('tr').find('.productId').text();

        json["cartId"] = cartId;
        json["productId"] = productId;
        json["quantity"] = 1;

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/rest/cart/update/increase",
            dataType: "json",
            data: JSON.stringify(json),
            contentType: "application/json"
        }).then(function (data) {
            $('#cartCount').text(data[0]);
            $('#totalPrice').text(data[1]);
            $('#total').text(data[1]);
            $('#totalSum').val(data[1]);
        });
    });

    $('.decreaseQuantity').on('click', function () {

        var quantity = $(this).closest('.quantityWrap').find('.quantity');
        if (quantity.text() > 0) {
            quantity.text(+quantity.text() - 1);
            var updatedQuantity = quantity.text();
            updatePrice(this, updatedQuantity);

            var json = {};
            var cartId = $(this).closest('tr').find('.cartId').text();
            var productId = $(this).closest('tr').find('.productId').text();

            json["cartId"] = cartId;
            json["productId"] = productId;
            json["quantity"] = 1;

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/rest/cart/update/decrease",
                dataType: "json",
                data: JSON.stringify(json),
                contentType: "application/json"
            }).then(function (data) {
                $('#cartCount').text(data[0]);
                $('#totalPrice').text(data[1]);
                $('#total').text(data[1]);
                $('#totalSum').val(data[1]);
            });
        }
    });

    $('.deleteItem').on('click', function () {

        var json = {};
        var cartId = $(this).closest('tr').find('.cartId').text();
        var productId = $(this).closest('tr').find('.productId').text();
        var quantity = $(this).closest('tr').find('.quantity').text();

        json["cartId"] = cartId;
        json["productId"] = productId;
        json["quantity"] = quantity;

        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/rest/cart/update/delete",
            dataType: "json",
            data: JSON.stringify(json),
            contentType: "application/json"
        }).then(function (data) {
            $('#cartCount').text(data[0]);
            $('#totalPrice').text(data[1]);
            $('#total').text(data[1]);
            $('#totalSum').val(data[1]);
        });

        $(this).closest('tr').hide();

    });

    function updatePrice(obj, updatedQuantity) {
        var price = $(obj).closest('tr').find('.price').text();
        $(obj).closest('tr').find('.sum').text(+price * +updatedQuantity);
    }


});