<%-- 
    Document   : Allproducts
    Created on : 14-10-2014, 13:45:28
    Author     : Jacob Nørgaard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <jsp:useBean id="result" type="Bean.ImagesBean" scope="request" />
        <img src="data:image/jpg;base64,${result.byteArrayString}" />
    </body>
</html>