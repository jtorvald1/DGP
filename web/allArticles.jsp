<%-- 
    Document   : allArticles
    Created on : Oct 27, 2014, 5:36:17 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYl>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PLZ OH GOD</title>
    </head>
    <body>
        <h1>WHATS WRONG</h1>
        <jsp:useBean id="bean" class="JavaBean.ArticlesBean" scope="request" />
        <center>
            <table>
                <c:forEach article="${result.getArticles}" var="article" >
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
                    <tr>
        </table>
        <br>
    </body>
</html>
