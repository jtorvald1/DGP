
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="Js/index_javascript.js"></script>
<script type="text/javascript" 
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<script type="text/javascript" 
        src="easy-comment/jquery.easy-comment.min.js"></script>
<meta charset="utf-8">
<title>News</title>
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
                         
                        <ul><li <a id="login-trigger" href="#"> Log in <span>&#x25BC;</span></a>
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
                    </li>
                </ul>
            </c:when>
            <c:when test="${not empty user}">Logget ind som: <a href="memberInfo.jsp">${user.getFirstName()}</a> <a href="LogOffUser">Logout</a></c:when>
        </c:choose>
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
        <c:forEach items="${result.getArticles()}" var="article">
        <form method="get" action="News">
    	<div class="box">
        <div class="box_headline">${article.getHeadline()}
                <font size="4">  by <u><a href="memberInfo.jsp?user=1">Admin</a></u> on ${article.getCreationDate()} </font> </div>
        <div class="box_text">${article.getText()}</div><!-------Change text to fit database---->
        <div class="box_category"> In <span id="cat" onClick='javascript:test("${article.getCategory()}");'><a href="#">${article.getCategory()}</a> </div></div>
        	<input type="button" class="content_button" value="Bliv Medlem"> <!-------Change value to fit database---->
                </c:forEach>
        <script>
            function test(category) {
                document.location.href = "News?cat=" + category;
            }
        </script>
        <!-- Comments code if we decide to use it
        <div id="comments" style="width:512px;height:400px;"></div>
        <script>
                $("#comments").EasyComment({
                path:"/easy-comment/",
                moderate:false,
                maxReply:5
                    });       
        </script>
        ---->
        
<!-------------- BOX 1 END --------------->

<!------------------------------------------------------------ CONTENT BOXES END ------------------------------------------------------------>
<!-------------------------------------------------------------- INFO BOX START ------------------------------------------------------------->


</article>
<!--------------------------ARTICLE END------------------------>


<!--------------------------FOOTER START------------------------>
<footer>
<!---------MENU START--------------->
     <div class="footer_menu">
    	<ul>
          <li><a href="News">Blog</a></li>
          <li><a href="WebshopController">Webshop</a></li>
          <li><a href="brugtevarer.jsp">Brugte Varer</a></li>
          <li><a href="registrer.jsp">Medlemskab</a></li>
		</ul>
    </div> 
<!---------MENU END----------------->

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