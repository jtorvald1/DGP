<%-- 
    Document   : SearchResult
    Created on : 23-10-2014, 19:45:14
    Author     : Nicole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Holy crap! It worked!         ... or not</h1>
        <jsp:useBean id="bean" class="JavaBean.SearchBean" scope="request" />
        
        Searching by <%= bean.getSearchBy() %>.<br>
        All the products shown for <%= bean.getSearchFor() %>.<br>
        <%= bean.getSearchResult() %><br>
        <br>
        <br>
        <br>
        <br>
        Perform a new <a href="Search.html">search</a>.
    </body>
</html>
