<%-- 
    Document   : allArticles
    Created on : Oct 27, 2014, 5:36:17 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYl>
<html>
    <head>
        <style>
        body {background-color:lightgray}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PLZ OH GOD</title>
    </head>
    <body>
                <c:forEach items="${result.getArticles()}" var="article" >
                    <tt>
                        <form>
                        <fieldset>
                            On ${article.getCreationDate()}
                            <br>
                            <strong>${article.getHeadline()}</strong>
                            <br>
                            <br>
                            ${article.getText()}
                            <br>
                            <br>
                            <center>In ${article.getCategory()}<</center>
                    </tt>
                        </fieldset>
                        </form>
                </c:forEach>
    </body>
</html>
