
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Produkt</title>
<link rel="stylesheet" type="text/css" href="Css/index_css.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    function removeDublicates()
    {
        var found = [];
        $("selectSize").each(function() {
        if($.inArray(this.value, found) !== -1) $(this).remove();
        found.push(this.value);
        });
    }
    function addToCart()
    {
        document.location.href="AddToCart";
    }
    
    function updateProduct()
    {
        var size = $("#selectSize option:selected").text();
        var color = $("#selectColor option:selected").text();
        
        document.location.href="RefineSearch?size=" + size + "&color=" + color;
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
            <c:when test="${empty user}"><a href="logind.jsp">Log Ind</a></c:when>
            <c:when test="${not empty user}">Logget ind som: ${user.getFirstName()}</c:when>
        </c:choose>
    </div>
    
    <div id="title"><b>Produkt</b></div>
<!---------MENU END----------------->
</div>
</header>

<article>
<!----------------------------------------------------------- SEARCH START --------------------------------------------------------------------->
<table border="0" cellspacing="4" cellpadding="4" class="web_search">
  <tr>
    <td width="33%"></td>
    <td width="20%"></td>
    <td width="47%"><input type="search" name="search" id="search" value="search" width="227px" style="float:right; margin-right:15px;"></td>
  </tr>
  <tr>
    <td>&lt; Tilbage</td>
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
 	 Gå til kurv
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
<!-------------- BOX 1 START --------------->
  <div class="pro_box1">
    <img src="data:image/jpg;base64,${productToShow.getImage()}" width="216" height="258" class="pro_item">
    <div class="pro_item_text">
    	<div class="pro_item_headline">${productToShow.getCategory()}</div>
    	<div class="pro_item_describtion">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do 		eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation 	ullamco laboris nisi ut aliquip ex.</div> 
    </div>
<!-------------- BOX 1.5 START --------------->
<div class="pro_item_decision">
    <table width="100%" border="0" cellspacing="4" cellpadding="4" class="pro_item_decision_table">
        <tr>
            <td width="14%">Størrelse</td>
            <td width="39%">
        <select id="selectSize">
            <option selected="selected">Vælg størrelse</option>
            <c:forEach items="${searchResult.getAllProducts()}" var="product">
            <option value="${product.getSize()}">${product.getSize()}</option>
            </c:forEach>
        </select>
        </tr>
    <tr>
        <td>Farve</td>
        <td>
        <select id="selectColor">
            <option selected="selected">Vælg farve</option>
            <c:forEach items="${searchResult.getAllProducts()}" var="product">
            <option value="${product.getColor()}">${product.getColor()}</option>
            </c:forEach>
        </select>
    </tr>
    <tr>
      <td>Antal</td>
      <td>
      <input name="Antal" type="text" size="3">
      <img src="Images/plus.png">
      <img src="Images/negativ.png">
      </td>
      </tr>
      <tr>
          <td><input type="button" onclick="updateProduct()" value="Opdater produkt"></td>
          <td><input type="button" onclick="addToCart(${productToShow.getProductId()})" value="Smid i kurv"></td>
      </tr>
  </table>
	<div class="pro_item_stk">Stk. 20.00,-<br>På lager</div>
    <div class="pro_item_ialt">i alt ${productToShow.getPrice()},-</div>
</div>
<!-------------- BOX 1.5 END --------------->
  </div>
<!-------------- BOX 1 END --------------->
<!-------------- BOX 2 START --------------->
    <div class="pro_box2">
    <div class="pro_se_headline">Se også</div>
    	<!-------------- ITEM 1 START --------------->
        <div class="web_itembox_first">            
            <img src="Images/webshop_item1.png" width="93" height="111" class="web_item">
            <div class="web_itemtext">
            	<div class="web_headline">Something</div>
            	<div class="web_describtion">info info info info info info info</div>
            </div>
            <div class="web_price">49.95,-</div>
            <input type="button" class="web_more_button" value="More">
        </div>
        <!-------------- ITEM 1 END --------------->   
        <!-------------- ITEM 2 START --------------->
        <div class="web_itembox">            
            <img src="Images/webshop_item1.png" width="93" height="111" class="web_item">
            <div class="web_itemtext">
            	<div class="web_headline">Something</div>
            	<div class="web_describtion">info info info info info info info</div>
            </div>
            <div class="web_price">49.95,-</div>
            <input type="button" class="web_more_button" value="More">
        </div>
        <!-------------- ITEM 2 END ---------------> 
<!-------------- BOX 2 END --------------->
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

