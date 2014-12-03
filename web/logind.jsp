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
        
        <form method="post" action="LoginUser">
            
	<div id="login_box">
    	
        <div><label for="name" id="login_text">Brugernavn: </label><br><input type="text" name="email" id="username" class="login_field"/></div>  
        <div class="glemt"><a href="#">Glemt brugernavn?</a></div><br>

        <div><label for="surname" id="login_text">Kode: </label><br><br><input type="password" name="password" id="password" class="login_field"/></div>
        <div class="glemt"><a href="#">Glemt adgangskode?</a></div><br>
		
        <div id="opret"><a href="registrer.jsp">Opret ny bruger</a></div>
		<div><input id="login_button" type="submit" value="Login"></div>
	</div>
            
        </form>
        
</div>
</body>
</html>
