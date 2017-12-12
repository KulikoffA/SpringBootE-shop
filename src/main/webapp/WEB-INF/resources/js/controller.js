$(document).ready(function () {
    $('#getInfo').on('click', function () {
        var productId = $('#productId').val();
        $('#productInfo').text('');

        $.ajax({
            type: "GET",
            dataType: "json",
            contentType: "application/json",
            url: "http://localhost:8080/rest/product/get/" + productId
        }).then(function (data) {
            $.each(data,function (key, value) {
                $('#productInfo').append(value + "<br><br>");
            });

        });

    });
});