
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<!doctype html>
<html>
<head>
<meta charset="iso-8859-1">
<title>registrer</title>
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
    
    <div id="title"><b>Registrer</b></div>
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
<!-------------- BOX TYPE START--------------->
<div id="box_type">
        
  <div class="type_content">
        <input type="checkbox" name="checkbox" id="checkbox">
        <label for="checkbox" class="cb_label"> Betalt medlem</label> <!--- when the box is checked highligt the box---->
    <br>
        <div class="type_text">
        - Lorem ipsum dolor sit amet. <br>
        - Consectetur adipisicing elit.<br>
        - Sed do eiusmod tempor.<br>
        - Incididunt ut labore.
        </div>
<!---------- If there's too much text, put in a Read more link. When clicked, exspand so that the text simply appears under the already shown text, and not on a new page ------------------>
    
  </div>
  
 <div class="type_content" style="padding-bottom:30px;">
        <input type="checkbox" name="checkbox" id="checkbox"> <!--- when the box is checked highligt the box---->
        <label for="checkbox" class="cb_label"> Gratis medlem</label>
    <br>
        <div class="type_text">
        - Lorem ipsum dolor sit amet. <br>
        - Consectetur adipisicing elit.<br>
        </div>
<!---------- If there's need of it, put in a Read more link as written about in the box above. ------------------>
        
  </div>
  
</div>
<!-------------- BOX TYPE END --------------->

<!-------------- BOX INFO START --------------->
    <div id="box_info">
        <div id="reg_info">
        	<form method="post" action="CreatePayingMember">
                    <div><label for="name">Navn: </label><br><input name="firstName" type="text" id="name" class="reg_field"/></div><br>        
                    <div><label for="surname">Efternavn: </label><br><input name="lastName" type="text" id="surname" class="reg_field"/></div><br>
                    <div><label for="email">Email: </label><br><input name="email" type="email" id="email" class="reg_field"/></div><br>
                    <div><label for="phone">Tlf: </label><br><input name="phone" type="text" id="phone" class="reg_field"/></div><br>
                    <div><label for="address">Adresse: </label><br><input name="address" type="text" id="address" class="reg_field"/></div><br>
                    <div><label for="pnr">Postnummer: </label><br><input type="text" id="pnr" class="reg_field"/></div><br>
                    <br>
                    <div><label for="username">Brugernavn: </label><br><input type="text" id="username" class="reg_field"/></div><br>
                    <div><label for="pw">Kode: </label><br><input name="password" type="password" id="pw" class="reg_field"/></div><br>
                    <div><label for="pw">Gentag kode: </label><br><input type="password" id="pw" class="reg_field"/></div><br>
                    <br>
                
				<input type="checkbox" name="accept_checkbox"><label for="accept_checkbox" id="accept_label"> Jeg har læst og accepter <a href="#">betalings vilkår</a></label>
                <div><input type="submit" value="Registrer" id="reg_button"/></div> <!---- have to be moved down 'on top of' the backgorund, don't know if possible as it is in a form-->
        	 </form>
        </div>
    </div>

 <!-------------- BOX INFO END --------------->
 

<!------------------------------------------------------------ CONTENT BOXES END ------------------------------------------------------------>
<!-------------------------------------------------------------- INFO BOX START -------------------------------------------------------------
<div id="column_info_box_2">
	<div id="info_text">
		<img src="Images/phone.png" ><span style="padding-left:15px">11 22 33 44</span>
        <br><br>
		<img src="Images/mail.png"><span style="padding-left:15px">example@gmail.com</span>
	</div>
</div>
----------->
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

