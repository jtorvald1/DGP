<%-- 
    Document   : ShoppingCart
    Created on : 31-10-2014, 14:28:13
    Author     : Jacob Nørgaard
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping cart</title>
    </head>
    <body>
        <center>
            <h1>Shopping cart</h1>
            <table>
                <c:forEach items="${cart.getItems()}" var="cartItem">
                    <tr>
                        <td>${cartItem.getQuantity()}</td>
                        <td>x</td>
                        <td>${cartItem.getProduct().getCategory()}</td>
                        <td>in</td>
                        <td>${cartItem.getProduct().getColor()}</td>
                    </tr>
                    <br>
                </c:forEach>
            </table>
                    Number of items in cart: ${cart.getNumberOfItems()}
                    <br>
                    Total price: ${cart.getTotalPrice()} kr.
                    <br>
                    <br>
                    <form method="post" action="CheckOut">
                        <input type="submit" value="Buy stuff">
                    </form>
        </center>
    </body>
</html>
