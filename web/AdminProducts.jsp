
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product administration</title>
        <style type="text/css">
            .tg  {border-collapse:collapse;border-spacing:0;}
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script>
            function submit()
            {
                var value = $("#productID").val();
                var searchBy = null;
                document.location.href="AdminProductSearch?searchBy=" + searchBy +"&value=" + value;
            }
        </script>
    </head>
    <body>
        <table class="tg">
            <tr>
                <td>Product ID</td>
                <td>Product category</td>
                <td>Brand</td>
                <td>Color</td>
                <td>Size</td>
                <td>Price</td>
                <td>Weight</td>
            </tr>
            <c:forEach items="${products.getAllProducts()}" var="product" >
                <tr>
                    <td>${product.getProductId()}</td>
                    <td>${product.getCategory()}</td>
                    <td>${product.getBrand()}</td>
                    <td>${product.getColor()}</td>
                    <td>${product.getSize()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getWeight()}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <table class="tg">
            <tr>
                <td>Item ID</td>
                <td>Product</td>
                <td>Stock</td>
                <td>Order</td>
            </tr>
            <c:forEach items="${items.getItems()}" var="item" >
                <tr>
                    <td>${item.getItemId()}</td>
                    <td>${item.getProductId()}</td>
                    <td>${item.getStockId()}</td>
                    <td><c:choose>
                            <c:when test="${empty item.getOrderId()}">(Not sold yet)</c:when>
                            <c:otherwise>${item.getItemId()}</c:otherwise>
                        </c:choose>    
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <input type="text" id="productID" size="50">
        <input type="text" id="category" size="50">
        <input type="text" id="brand" size="50">
        <input type="text" id="color" size="50">
        <input type="text" id="size" size="50">
        <input type="text" id="price" size="50">
        <input type="text" id="weight" size="50">
        <input type="button" onclick="submit()" value="submit">
    </body>
</html>