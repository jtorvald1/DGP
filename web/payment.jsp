
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta charset="iso-8859-1">
<title>Payment</title>
<link rel="stylesheet" type="text/css" href="Css/index_css.css">
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
    
    <div id="title"><b>Betaling</b></div>
<!---------MENU END----------------->
</div>
</header>


<!-----"IN CARD" ITEMS BEGIN --->
<article>

<!----------------------------------------------------------- SEARCH START --------------------------------------------------------------------->
<table border="0" cellspacing="4" cellpadding="4" class="web_search">
  <tr>
    <td width="33%">&nbsp;</td>
    <td width="33%">&nbsp;</td>
    <td><input type="search" name="search" id="search" value="search" width="227px" style="float:right; margin-right:15px;"></td>
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
    <div class="web_cart_cirkel">4</div>
    <div id="cart_image"><img src="Images/web_cart.png"></div>
  </div>
<!---------CART END----------------->
<!---------CATEGORIES START----------------->
  <div id="web_categories_box">
   <div id="column_bottom">
        	<input type="button" class="column_botton" value="Rabat">
            
            <div class="cloumn_text">Information lorem <br> ipsum dolor sit <br> amet, consectetur <br> adipisicing elit,
            sed <br> do eiusmod tempor.</div>
            
            <input type="button" class="column_botton" value="Noget">
            
            <div class="cloumn_text">Information lorem <br> ipsum dolor sit <br> amet, consectetur <br> adipisicing elit,
            sed <br> do eiusmod tempor.</div>
        
        </div>
  </div>
<!---------CATEGORIES END----------------->
</div>
<!----------------------------------------------------------------- COLUMN END ---------------------------------------------------------------->


<!------------------------------------------------------------ CONTENT BOXES START ------------------------------------------------------------>    
<div id="content">
<!-------------- BOX START --------------->
    <div class="pay_box">
    	<!-------------- ITEM 1 START --------------->
        <div class="web_itembox_first">            
            <img src="Images/webshop_item1.png" width="93" height="111" class="web_item">
            <div class="web_itemtext">
            	<div class="web_headline">Something</div>
            	<div class="web_describtion">Antal <input name="" type="text" style="width:73px;"> <img src="Images/negativ.png"> <img src="images/plus.png"></div>
            </div>
            <div class="web_price">100,-</div>
        </div>
        <!-------------- ITEM 1 END --------------->   
        <!-------------- ITEM 2 START --------------->
        <div class="web_itembox">            
            <img src="Images/webshop_item1.png" width="93" height="111" class="web_item">
            <div class="web_itemtext">
            	<div class="web_headline">Something</div>
            	<div class="web_describtion">Antal <input name="" type="text" style="width:73px;"> <img src="Images/negativ.png"> <img src="images/plus.png"></div>
            </div>
            <div class="web_price">100,-</div>
        </div>
        <!-------------- ITEM 2 END ---------------> 
        <!-------------- ITEM 3 START --------------->
        <div class="web_itembox">            
            <img src="Images/webshop_item1.png" width="93" height="111" class="web_item">
            <div class="web_itemtext">
            	<div class="web_headline">Something</div>
            	<div class="web_describtion">Antal <input name="" type="text" style="width:73px;"> <img src="Images/negativ.png"> <img src="images/plus.png"></div>
            </div>
            <div class="web_price">100,-</div>
        </div>
        <!-------------- ITEM 3 END ---------------> 
        <!-------------- ITEM 4 START --------------->
        <div class="web_itembox">            
            <img src="Images/webshop_item1.png" width="93" height="111" class="web_item">
            <div class="web_itemtext">
            	<div class="web_headline">Something</div>
            	<div class="web_describtion">Antal <input name="" type="text" style="width:73px;"> <img src="Images/negativ.png"> <img src="images/plus.png"></div>
            </div>
            <div class="web_price">100,-</div>
        </div>
        <!-------------- ITEM 4 END ---------------> 
        
        <div id="pay_ialt">I alt 400,-</div>

	</div>
<!-------------- BOX END --------------->
<!------------------------------------------------------------ CONTENT BOXES END ------------------------------------------------------------>
  
  <!-----PAYMENT HEADLINE START --->
  
    <div id="payment_headline">Betaling</div>
  <!-----PAYMENT HEADLINE END --->
  

<!-----PAYMENTFORMULARS START --->
 
 
 <!-----PAYMENTFORMULAR 1 START --->

  <div id="payment_wrap">

    	<div id="formel1">
    	  <form id="form1" name="form1" method="post">
    	    <div>
    	      <label for="textfield" style="color:#fff; padding-right:20px;">Fornavn</label>
    	      <input type="text" name="textfield" class="textfield">
    	    </div><br>
    	        
    	    
    	     <div> <label for="textfield2" style="color:#fff; padding-right:10px;">Efternavn</label>
              <input type="text" name="textfield2" class="textfield"></div><br>
    	    
    	  
    	      <div><label for="textfield3" style="color:#fff; padding-right:45px;">Mail</label>
              <input type="text" name="textfield3" class="textfield"></div><br>
    	    
    	    
    	      <div><label for="textfield4" style="color:#fff; padding-right:53px;">Tlf:</label>
              <input type="text" name="textfield4" calss="textfield"></div>
    	    
    	  </form>
        
        
    	</div>
 <!-----PAYMENTFORMULAR 1 END --->
 
  <!-----PAYMENTFORMULAR 2 START --->

   	<div id="formel2">
    	  <form id="form1" name="form1" method="post">
    	    <div>
    	      <label for="textfield" style="color:#fff; padding-right:49px;">Adresse</label>
    	      <input type="text" name="textfield" class="textfield">
    	    </div><br>
    	        
    	    
    	     <div> <label for="textfield2" style="color:#fff; padding-right:85px;">By</label>
              <input type="text" name="textfield2" class="textfield"></div><br>
    	    
    	  
    	      <div><label for="textfield3" style="color:#fff; padding-right:15px;">Postnummer</label>
              <input type="text" name="textfield3" class="textfield"></div><br>    	    
   	  </form>
        
        
    	</div>
 <!-----PAYMENTFORMULAR 2 END --->
        <br>
 <!-----PAYMENTFORMULAR 3 START --->
        <div id="formel3">
       	  <div><input type="checkbox" name="checkbox" id="checkbox">
            <label for="checkbox" style="color:#fff;">V&aelig;lg anden leveringsadresse* </label></div><br>
            
    	  <form id="form1" name="form1" method="post">
    	    <div>
    	      <label for="textfield" style="color:#fff; padding-right:49px;">Adresse</label>
    	      <input type="text" name="textfield" class="textfield">
    	    </div><br>
    	        
    	    
    	     <div> <label for="textfield2" style="color:#fff; padding-right:85px;">By</label>
              <input type="text" name="textfield2" class="textfield"></div><br>
    	    
    	  
    	      <div><label for="textfield3" style="color:#fff; padding-right:15px;">Postnummer</label>
              <input type="text" name="textfield3" class="textfield"></div><br>    	    
   	  		</form>
            
            <div style="color:#fff;">*Valfri</div>
            
        </div>
 <!-----PAYMENTFORMULAR 3 END --->
  </div>
  
  <!-----PAYMENTFORMULARS END --->

 <!-----EMTY BOX START --->

  <div id="payment_wrap2">
  	<div style="font-size:40px;">BETALINGSSYSTEM/METODE</div>
  </div>
 <!-----EMTY BOX END --->
 
  <!-----"BETAL" BOTTON ECT. START --->

  <div id="payment_wrap3">
       	  <div id="checkbox2"><input type="checkbox" name="checkbox" id="checkbox">
           <label for="checkbox" style="color:#fff;">Jeg accepterer betalingsvilk&aring;r </label></div>
           
           <input type="button" id="payment_botton" value="betal">

  </div>
  <!-----"BETAL" BOTTON ECT. END --->
</article>
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
