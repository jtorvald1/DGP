<%-- 
    Document   : NewBlog
    Created on : Dec 10, 2014, 8:19:55 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="Js/index_javascript.js"></script>
<meta charset="utf-8">
<title>Opret Blogindlæg</title>
<link rel="stylesheet" type="text/css" href="Css/index_css.css">
</head>

<body>

<header>
<div id="index_image">
<!---------MENU START--------------->
     <a href="index.jsp"><img src="Images/JJ_logo.png" id="logo"></a><!--------LOGO: height and width 100 px ---------->
     <nav>
    	<ul>

	</ul>
     
     </nav>
<!---------MENU END----------------->
</div>
</header>

<article>
<!----------------------------------------------------------- COLUMN START --------------------------------------------------------------------->
  <div id="column_box">
  	<div id="column_content">
  	<!-----------CONTENT 1 START-------------->
    	<input id="menu" type="button" class="button" value="Menu" onClick="redirect()"><!-------Change value to headline from database---->
    	<div> 
        <div class="column_text">
            <a href="NewArticle.jsp">New article</a>
            <br>
            <a href="NewBlog.jsp">New blog</a>
            <br>
            <a href="AdminProducts.jsp">Edit product</a>
            <br>
            <a href="AdminOrders.jsp">Edit orders</a>
            <br>
            <a href="AdminUsers.jsp">Edit Users</a>
            <br>
            <a href="LogOffUser">Logout</a>
            <br>
        </div>
        </div>
        <script>
            function redirect() {
                document.location.href = "AdminMenu.jsp";
            }
        </script>
    <!-----------CONTENT 1 END---------------->
    
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
        <div class="admin_box"></div>
        <div class="admin_headline">Create a new blog post</div>
        <br><br>
        <div class="admin_content">
            <form method="post" action="NewBlog">
            Headline for the blog: <input type="text" name="headline">
            <br>
            <br>
            Category:
            <SELECT name="category">
                <option>Self
                <option>Life
                <option>Info
            </select>
            <br>
            <br>
            <textarea name="blogContent" style="width:250px;height:150px;"></textarea>
            <br>
            <br>
            <input type="submit" value="Create" onclick="message()">
            </form>
        </div></div>
        <script>
                function message() {
                    alert("Blog created!");
                }
        </script>

<!------------------------------------------------------------ CONTENT BOXES END ------------------------------------------------------------>
<!-------------------------------------------------------------- INFO BOX START ------------------------------------------------------------->


</article>
<!--------------------------ARTICLE END------------------------>


<!--------------------------FOOTER START------------------------>
<footer>
<!---------MENU START--------------->
     <div class="footer_menu">
    	<ul>

	</ul>

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
