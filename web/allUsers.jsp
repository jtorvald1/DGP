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
                            <jsp:include page="/EditPayingMember"></jsp:include>
                            <a href="memberInfo.jsp">Redigér Bruger</a>
                            <%--<div><input type="Button" value="Redigér Bruger" name=Edit_button" 
                            onclick="document.forms[0].action = 'memberInfo.jsp'; return true;" /></div> 
                            This crap won't work with a button and I don't even know if it's needed............
                            
                            And why are comments so ridiculous in jsp!!??
                            --%>         
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