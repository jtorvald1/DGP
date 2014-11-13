
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYl>
<html>
    <head>
        <style>
        body {background-color:lightgray}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRATATA</title>
    </head>
    <body>
                <c:forEach items="${article.getCategory()}" var="article" >
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
                            In ${article.getCategory()}
                    </tt>
                        </fieldset>
                        </form>
                </c:forEach>
    </body>
</html>
