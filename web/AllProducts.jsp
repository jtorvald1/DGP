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
                <c:forEach items="${result.getArticles()}" var="article" >
                    <tr>
                        <td>Description: ${article.getHeadline()}</td>
                    </tr>
                    <tr>
                        <td>Brand: ${article.getCreationDate()}</td>
                    </tr>
                    <tr>
                        <td>Category: ${article.getText()}</td>
                    </tr>
                    <tr>
                        <td>Price: ${article.getCategory()}</td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>