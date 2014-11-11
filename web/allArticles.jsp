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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PLZ OH GOD</title>
    </head>
    <body>
            <table>
                <c:forEach items="${result.getArticles()}" var="article" >
                    <tr>
                        <td>Headline: ${article.getHeadline()}</td>
                    </tr>
                    <tr>
                        <td>Text: ${article.getText()}</td>
                    </tr>
                    <tr>
                        <td>CreationDate: ${article.getCreationDate()}</td>
                    </tr>
                    <tr>
                        <td>Category: ${article.getCategory()}</td>
                </tr>
                </c:forEach>
            </table>
    </body>
</html>
