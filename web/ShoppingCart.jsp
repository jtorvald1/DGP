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
                <c:forEach items="${bean.getItems()}" var="cartItem">
                    <tr>
                        <td>${cartItem.getQuantity()}</td>
                        <td>${cartItem.getProduct().getDescription()}</td>
                    </tr>
                    <br>
                </c:forEach>
            </table>
        </center>
    </body>
</html>
