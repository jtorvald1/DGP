
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order administration</title>
        <style type="text/css">
            body{font-family:Arial, sans-serif; font-size:14px;}
            .tg  {border-collapse:collapse;border-spacing:0;border-color:#aabcfe;background-color:#e8edff}
            .tg td{padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
            .tg th{font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;color:#039;background-color:#b9c9fe}
            .content {float: left; margin-left: 20px; margin-right: 20px;}
            #description {height: 150px;}
            .fields {width: 300px;}
            #container {margin-left: auto; margin-right: auto; width: 1200px;}
            body{color:#669;}
        </style>
        <script src="Js/alertify.min.js"></script>
        <link rel="stylesheet" href="Css/alertify.min.css" />
        <link rel="stylesheet" href="Css/default.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="Js/AdminOrders.js"></script>
    </head>
    <body>
        <center><h1>Order Administration</h1></center>
        <div id="container">
            <div class="content">
                <table class="tg">
                    <tr>
                        <th colspan="5">Orders</th>
                    </tr>
                    <tr>
                        <td>Order ID</td>
                        <td>Order date</td>
                        <td>Customer ID</td>
                        <td>First name</td>
                        <td>Last name</td>
                    </tr>
                    <c:forEach items="${orders.getOrders()}" var="order" >
                        <tr>
                            <td>${order.getOrderId()}</td>
                            <td>${order.getOrderDate()}</td>
                            <td>${order.getCustomerId()}</td>
                            <td>${order.getFirstName()}</td>
                            <td>${order.getLastName()}</td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <br>
                <table class="tg">
                    <tr>
                        <th colspan="4">Items</th>
                    </tr>
                    <tr>
                        <td>Item ID</td>
                        <td>Product ID</td>
                        <td>Stock</td>
                        <td>Order ID</td>
                    </tr>
                    <c:forEach items="${items.getItems()}" var="item" >
                        <tr>
                            <td>${item.getItemId()}</td>
                            <td>${item.getProductId()}</td>
                            <td>${item.getStockId()}</td>
                            <td>${item.getOrderId()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="content">
                <table>
                    <tr>
                        <td>Order ID: </td>
                        <td><input type="text" class="fields" id="orderId" name="orderId" value="${lastSearchedOrder.getOrderId()}"></td>
                        <td>
                            <select id="searchFor">
                                <option value="orderId">Order ID</option>
                                <option value="customerId">Customer ID</option>
                                <option value="firstName">First Name</option>
                                <option value="lastName">Last name</option>
                                <option value="allOrders">All orders</option>
                            </select>
                        <td>
                    </tr>
                    <tr>
                        <td>Customer ID: </td>
                        <td><input type="text" class="fields" id="customerId" name="customerId" value="${lastSearchedOrder.getCustomerId()}"></td>
                    </tr>
                    <tr>
                        <td>First name: </td>
                        <td><input type="text" class="fields" id="firstName" name="firstName" value="${lastSearchedOrder.getFirstName()}"></td>
                    </tr>
                    <tr>
                        <td>Last name: </td>
                        <td><input type="text" class="fields" id="lastName" name="lastName" value="${lastSearchedOrder.getLastName()}"></td>
                    </tr>
                    <tr>
                        <td><input type="button" onclick="search()" value="Search"></td>
                        <td><input type="button" onclick="deleteOrder()" value="Delete order"></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>