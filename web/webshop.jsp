
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Webshop</title>
<link rel="stylesheet" type="text/css" href="Css/index_css.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script>
    function goToProductDetails(brand)
    {
        document.location.href="Search?searchBy=brand&value=" + brand;
    }
</script>
</head>

<body>

<header>
<div id="top_image">
<!---------MENU START--------------->
     <a href="index.jsp"><img src="Images/JJ_logo.png" id="logo"></a><!--------LOGO: height and width 100 px ---------->
     <nav>
    	<ul>
          <li><a href="blog.jsp">Blog</a></li>
          <li><a href="webshop.jsp">Webshop</a></li>
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
            <c:when test="${not empty user}">Logget ind som: ${user.getFirstName()}</c:when>
        </c:choose>
    </div>
    
    <div id="title"><b>Webshop</b></div>
<!---------MENU END----------------->
</div>
</header>

<article>
<!----------------------------------------------------------- SEARCH START --------------------------------------------------------------------->
<table border="0" cellspacing="4" cellpadding="4" class="web_search">
  <tr>
    <td width="33%">Show per page <input name="" type="text" style="width:73px;"></td>
    <td width="33%">Sort after <input name="" type="text" style="width:137px;"></td>
    <td><input type="search" name="search" id="search" value="search" width="227px" style="float:right; margin-right:15px;"></td>
  </tr>
  <tr>
    <td>First &lt;0...${lastSearchedProducts.getAllProducts().size()}&gt; Last</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

<!----------------------------------------------------------- SEARCH END --------------------------------------------------------------------->
<!----------------------------------------------------------- COLUMN START --------------------------------------------------------------------->
<div class="web_column">
<!---------CART START----------------->
  <div id="web_cart_box">
  	<div id="cart_text">
            <a href="ShoppingCart.jsp">Gå til kurv</a>
            <br>
            Ønskeliste
  	</div>
    <div class="web_cart_cirkel">${cart.getNumberOfItems()}</div>
    <div id="cart_image"><img src="Images/web_cart.png"></div>
  </div>
<!---------CART END----------------->
<!---------CATEGORIES START----------------->
  <div id="web_categories_box">
  	<div class="web_colmn_headline">Categories</div>
  </div>
<!---------CATEGORIES END----------------->
</div>
<!----------------------------------------------------------------- COLUMN END ---------------------------------------------------------------->


<!------------------------------------------------------------ CONTENT BOXES START ------------------------------------------------------------>    
<div id="content">
<!-------------- BOX START --------------->
    <div class="web_box">
    	<!-------------- ITEM START --------------->
        <c:forEach items="${lastSearchedProducts.getAllProducts()}" var="product" varStatus="loop">
            <div class="web_itembox">            
                <img src="data:image/jpg;base64, ${product.getImage()}" width="93" height="111" class="web_item">
                <div class="web_itemtext">
                    <div class="web_headline"></div>
                    <div class="web_describtion">${product.getDescription()}</div>
                </div>
                <div class="web_price">${product.getPrice()},-</div>
                <input onclick="goToProductDetails('Bulls')" type="button" class="web_more_button" value="More">
            </div>
        </c:forEach>
        <!-------------- ITEM END --------------->   
	</div>
<!-------------- BOX END --------------->
<!------------------------------------------------------------ CONTENT BOXES END ------------------------------------------------------------>

</article>
<!--------------------------ARTICLE END------------------------>
<!--------------------------FOOTER START------------------------>
<footer>
<!---------MENU START--------------->
     <div class="footer_menu">
    	<ul>
          <li><a href="blog.jsp">Blog</a></li>
          <li><a href="webshop.jsp">Webshop</a></li>
          <li><a href="brugtevarer.jsp">Brugte Varer</a></li>
          <li><a href="registrer.jsp">Registrer</a></li>
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

