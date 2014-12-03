
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Produkt</title>
<link rel="stylesheet" type="text/css" href="Css/index_css.css">
<script>
    function addToCart(productNumber)
    {
        document.location.href="AddToCart?productNumber=" + productNumber;
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
	<div id="log_ind"><a href="#">Log Ind</a></div>
    
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
 	 <a href="">Go to cart</a>
 	 <br>
 	 <a href="">My wish-list</a>
  	</div>
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
    <img src="data:image/jpg;base64,${detailedProduct.getImage()}" width="216" height="258" class="pro_item">
    <div class="pro_item_text">
    	<div class="pro_item_headline">Navn</div>
    	<div class="pro_item_describtion">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do 		eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation 	ullamco laboris nisi ut aliquip ex.</div> 
    </div>
<!-------------- BOX 1.5 START --------------->
<div class="pro_item_decision">
  <table width="100%" border="0" cellspacing="4" cellpadding="4" class="pro_item_decision_table">
    <tr>
      <td width="14%">Størrelse</td>
      <td width="39%">
        <select>
          <option selected="selected">Vælg størrelse</option>
          <option value="">38</option>
          <option value="">39</option>
          <option value="">40</option>
          <option value="">41</option>
          </select>
      </td>
      </tr>
    <tr>
      <td>Farve</td>
      <td>
        <select>
          <option selected="selected">Vælg farve</option>
          <option value="">rød</option> 
          <option value="">sort</option>
          </select>
      </td>
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
          <td><input type="button" onclick="addToCart()" value="Put in cart"></td>
      </tr>
  </table>
	<div class="pro_item_stk">Stk. 20.00,-<br>På lager</div>
    <div class="pro_item_ialt">i alt ${detailedProduct.getPrice()},-</div>
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

