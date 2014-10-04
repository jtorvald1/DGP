<%-- 
    Document   : CreatePayingCustomer
    Created on : 03-10-2014, 15:15:52
    Author     : Jacob Nørgaard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="CreatePayingMember">
            Create new article:
            <br>
            <br>
            Enter headline for article: <input type="text" name="firstName">
            <br>
            Enter article category: <input type="text" name="lastName"> 
            <br>
            <br>
            <textarea name="articleContent" style="width:250px;height:150px;"></textarea>
            <input type="submit" value="Create article">
        </form>
    </body>
</html>
