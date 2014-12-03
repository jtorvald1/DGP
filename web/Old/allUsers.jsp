<%-- 
    Document   : allUsers
    Created on : Dec 3, 2014, 4:45:31 AM
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
        <title>yeay</title>
    </head>
    <body>
                <c:forEach items="${result.getUsers()}" var="user" >
                        <form method="get" action="SearchServlet">
                            ${user.getFirstName()}
                            <br>
                            ${user.getLastName()}
                            <br>
                            <br>
                            ${user.getEmail()}
                            <br>
                            <br>
                        </form>
                </c:forEach>
    </body>
</html>