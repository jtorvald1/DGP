
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="Js/index_javascript.js"></script>
<meta charset="utf-8">
<title>Front Page</title>
<link rel="stylesheet" type="text/css" href="Css/index_css.css">
</head>

<body>

<header>
<div id="index_image">
<!---------MENU START--------------->
     <a href="#"><img src="Images/JJ_logo.png" id="logo"></a><!--------LOGO: height and width 100 px ---------->
     <nav>
    	<ul>
          <li><a href="News">Blog</a></li>
          <li><a href="WebshopController">Webshop</a></li>
          <li><a href="brugtevarer.jsp">Brugte Varer</a></li>
          <li><a href="registrer.jsp">Registrer</a></li>
		</ul>
    </nav> 
    <div id="log_ind" >
        <c:choose>
            <c:when test="${empty user}">         
                <ul>
                    <li id="login">
                        <a id="login-trigger" href="#">
                            Log in <span>&#x25BC;</span>
                        </a>
                        <div id="login-content">
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
                    </li>

                </ul>
            </c:when>
            <c:when test="${not empty user}">Logget ind som: <span id="id" onClick='javascript:test("${user.getUserId()}");'>${user.getFirstName()}</span> <a href="LogOffUser">Logout</a></c:when>
        </c:choose>
            <script>
            function test(userid) {
                document.location.href = "memberInfo.jsp?user=" + userid;
            }
            </script>
    </div>
<!---------MENU END----------------->
</div>
</header>

<article>
<!----------------------------------------------------------- COLUMN START --------------------------------------------------------------------->
  <div id="column_box">
  	<div id="column_content">
  	<!-----------CONTENT 1 START-------------->
    	<input type="button" class="button" value="Overskrift" onClick="#"><!-------Change value to headline from database---->
    	<div> 
        <div class="column_text">Lorem ipsum dolor sit amet, consectetur adipisicing elit enim ad minim veniam...<!---Change text to fit database, show XXX charaters--->
        <br><br>
		<b><a href="#">Læs mere</a></div></b>
        </div>
    <!-----------CONTENT 1 END---------------->
    
    <!-----------CONTENT 2 START-------------->
    	<input type="button" class="button" value="Overskrift" onClick="#"><!-------Change value to headline from database---->
    	<div> 
        <div class="column_text">Lorem ipsum dolor sit amet, consectetur adipisicing elit enim ad minim veniam...<!---Change text to fit database, show XXX charaters--->
        <br><br>
		<b><a href="#">Læs mere</a></div></b>
        </div>
    <!-----------CONTENT 2 END---------------->
    
    <!-----------CONTENT 3 START-------------->
    	<input type="button" class="button" value="Overskrift" onClick="#"><!-------Change value to headline from database---->
    	<div> 
        <div class="column_text">Lorem ipsum dolor sit amet, consectetur adipisicing elit enim ad minim veniam...<!---Change text to fit database, show XXX charaters--->
        <br><br>
		<b><a href="#">Læs mere</a></div></b>
        </div>
    <!-----------CONTENT 3 END-------------->
    
    <!-----------CONTENT 4 START------------>
    	<input type="button" class="button" value="Overskrift" onClick="#"><!-------Change value to headline from database---->
    	<div> 
        <div class="column_text">Lorem ipsum dolor sit amet, consectetur adipisicing elit enim ad minim veniam...<!---Change text to fit database, show XXX charaters--->
        <br><br>
		<b><a href="#">Læs mere</a></div></b>
        </div>
    <!-----------CONTENT 4 END-------------->
    </div>
   <div id="column_space"></div>  
   
  <div id="column_info_box">
	<div id="info_text">
		<img src="Images/phone.png" ><span style="padding-left:15px">11 22 33 44</span>
        <br><br>
		<img src="Images/mail.png"><span style="padding-left:15px">example@gmail.com</span>
	</div>
</div>
  </div>
<!----------------------------------------------------------------- COLUMN END ---------------------------------------------------------------->


<!------------------------------------------------------------ CONTENT BOXES START ------------------------------------------------------------>    
<div id="content"><br>
<!-------------- BOX 1 START --------------->
    	<div class="box">
        <div class="box_headline">Medlemskab</div>
		<div class="box_text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div><!-------Change text to fit database---->
		</div>
        	<input type="button" class="content_button" value="Bliv Medlem"> <!-------Change value to fit database---->
<!-------------- BOX 1 END --------------->

<!-------------- BOX 2 START --------------->
        <div class="box">
        <div class="box_headline">Hvad er Jiu Jitsu</div>
		<div class="box_text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore 		magna aliqua. <br><br>
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </div><!-------Change text to fit database---->
		</div>
      
        	<input type="button" class="content_button" value="Læs Mere"><!-------Change value to fit database---->
 <!-------------- BOX 2 END --------------->
 
 <!-------------- BOX 3 STRAT --------------->
    <div class="box">
 		<div class="box_headline">Denne Uge - 5% På Alle Bælter</div>
		<div class="box_text">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore 		magna aliqua. <br>
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </div><!-------Change text to fit database---->
        
    </div>
    		<input type="button" class="content_button" value="Gå til Webshop"><!-------Change value to fit database---->
		<br><br>
    </div>
<!-------------- BOX 3 END --------------->
<!------------------------------------------------------------ CONTENT BOXES END ------------------------------------------------------------>
<!-------------------------------------------------------------- INFO BOX START ------------------------------------------------------------->


</article>
<!--------------------------ARTICLE END------------------------>


<!--------------------------FOOTER START------------------------>
<footer>
<!---------MENU START--------------->
     <div class="footer_menu">
    	<ul>
          <li><a href="#">Blog</a></li>
          <li><a href="#">Webshop</a></li>
          <li><a href="#">Brugte Varer</a></li>
          <li><a href="#">Registrer</a></li>
		</ul>
         
    </div> 
<!---------MENU END----------------->

<!---------ADMIN LOGIN-------------->

<div class="admin_login">
    <ul><li><a href="AdminMenu.jsp">Administrator-Login</a></li></ul>
</div>

<!---------ADMIN LOGIN END---------->

<div id="social_meadia">
	<a href="#"><img src="Images/facebook.jpg"></a>
	<a href="#"><img src="Images/twitter.jpg"></a>
</div>

<!----------HOW DO I MOVE THIS FARTHER AWAY FROM TOP???? MARGIN / PADDING DOESN'T WORK------------------>
<div id="copyright">
Copyright quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat
</div>

</footer>

</body>
</html>