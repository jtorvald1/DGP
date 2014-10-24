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
        <title>Products</title>
    </head>
    <body>
        <jsp:useBean id="result" class="JavaBean.ProductsBean" scope="session" />
        <center>
            <table>
                <c:forEach items="${result.allProducts}" var="product" >
                    <tr>
                        <td>Description: ${product.getDescription()}</td>
                    </tr>
                    <tr>
                        <td>Brand: ${product.getBrand()}</td>
                    </tr>
                    <tr>
                        <td>Category: ${product.getCategory()}</td>
                    </tr>
                    <tr>
                        <td>Price: ${product.getPrice()}</td>
                    </tr>
                    <tr>
                        <td>Color: ${product.getColor()}</td>
                    </tr>
                    <tr>
                        <td>Weight: ${product.getWeight()}</td>
                    </tr>
                    <tr>
                        <td>Size: ${product.getSize()}</td>
                    </tr>
                    <tr>
                        <td><img src="data:image/jpg;base64,${product.getImage()}" width="500" /></td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>