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
        <title>Member Options</title>
    </head>
    <body>
                <c:forEach items="${result.getUsers()}" var="user" >
                        <form method="get" action="SearchServlet">
                            Fornavn: <span id="id" onClick='javascript:test("${user.getUserId()}");'>${user.getFirstName()}</span> <br>
                            Efternavn: ${user.getLastName()} <br>
                            BrugerId: ${user.getUserId()} <br>
                            Brugernavn: ${user.getUserName()} <br>
                            Email: ${user.getEmail()}<br>
                            <div><input type="submit" value="Redigér Bruger" id="Edit_button" onsubmit='???'/></div>
                            
                            <br>
                            <br>
                        </form>
                </c:forEach>
            <script>
            function test(userid) {
                document.location.href = "memberInfo.jsp?user=" + userid;
            }
            </script>
    </body>
</html>