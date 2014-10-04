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
            Enter member information:
            <br>
            <br>
            First name: <input type="text" name="firstName">
            <br>
            Last name: <input type="text" name="lastName"> 
            <br>
            Address: <input type="text" name="address">
            <br>
            <br>
            <input type="submit" value="Create member">
        </form>
    </body>
</html>
