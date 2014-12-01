<%-- 
    Document   : Allproducts
    Created on : 14-10-2014, 13:45:28
    Author     : Jacob Nørgaard
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Articles</title>
    </head>
    <body>
        <center>
            <table>
                <c:forEach items="${result.getAllProducts()}" var="product" >
                    <tr>
                        <td>Description: ${product.getDescription()}</td>
                    </tr>
                    <tr>
                        <td>Brand: ${product.getBrand()}</td>
                    </tr>
                    <tr>
                        <td>Color: ${product.getColor()}</td>
                    </tr>
                    <tr>
                        <td>Size ${product.getSize()}</td>
                    </tr>
                    <tr>
                        <td>Category: ${product.getCategory()}</td>
                    </tr>
                    <tr>
                        <td>Price: ${product.getPrice()}</td>
                    </tr>
                    <tr>
                        <td><img width="300" src="data:image/jpg;base64, ${product.getImage()}"></td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>