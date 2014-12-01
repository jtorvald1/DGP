
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYl>
<html>
    <head>
        <style>
        body {background-color:lightgray}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TWERK IT</title>
    </head>
    <body>
                <c:forEach items="${result.getBlogs()}" var="blog" >
                    <tt>
                        <form>
                        <fieldset>
                            On ${blog.getCreationDate()}
                            <br>
                            <strong>${blog.getHeadline()}</strong>
                            <br>
                            <br>
                            ${blog.getText()}
                            <br>
                            <br>
                            <center>In ${blog.getCategory()}</center>
                    </tt>
                        </fieldset>
                        </form>
                </c:forEach>
    </body>
</html>
