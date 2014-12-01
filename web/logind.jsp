<%-- 
    Document   : logind
    Created on : Nov 29, 2014, 12:37:39 PM
    Author     : Jacob Nørgaard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Log ind</title>
<link rel="stylesheet" type="text/css" href="Css/index_css.css">
</head>

<body>
<div>
	<div id="login_triangle"></div>
	<div id="login_box">
    	
        <div><label for="name" id="login_text">Brugernavn: </label><br><input type="text" id="username" class="login_field"/></div>  
        <div class="glemt"><a href="#">Glemt brugernavn?</a></div><br>

        <div><label for="surname" id="login_text">Kode: </label><br><br><input type="password" id="password" class="login_field"/></div>
        <div class="glemt"><a href="#">Glemt adgangskode?</a></div><br>
		
        <div id="opret"><a href="#">Opret ny bruger</a></div>
		<a href="#"><div id="login_button">Log Ind</div></a>
	</div>
</div>
</body>
</html>
