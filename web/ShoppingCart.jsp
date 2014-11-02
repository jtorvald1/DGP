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
                <c:forEach items="bean.getItems()" var="cartItem">
                    <tr>
                        <td>${cartItem.getDescription()}</td>
                    </tr>
                    <br>
                    <tr>
                        <td>${cartItem.getColor()}</td>
                    </tr>
                    <br>
                    <tr>
                        <td>${cartItem.getBrand()}</td>
                    </tr>
                    <br>
                    <br>
                </c:forEach>
            </table>
        </center>
    </body>
</html>
