
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<!doctype html>
<html>
<head>
<meta charset="iso-8859-1">
<title>Medlemsside</title>
<link rel="stylesheet" type="text/css" href="Css/index_css.css">
</head>

<body>

<header>
<div id="top_image">
<!---------MENU START--------------->
     <a href="index.jsp"><img src="Images/JJ_logo.png" id="logo"></a><!--------LOGO: height and width 100 px ---------->
     <nav>
    	<ul>
          <li><a href="News">Blog</a></li>
          <li><a href="WebshopController">Webshop</a></li>
          <li><a href="brugtevarer.jsp">Brugte Varer</a></li>
          <li><a href="registrer.jsp">Medlemskab</a></li>
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
            <c:when test="${not empty user}">Logget ind som: ${user.getFirstName()}</c:when>
        </c:choose>
    </div>
    
    <div id="title"><b>Registrér</b></div>
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
      <input type="radio" name="checkbox" id="radio1" checked="true">
        <label for="radio1" class="cb_label"> Betalt medlem</label> <!--- when the box is checked highligt the box---->
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
        <input type="radio" name="checkbox" id="radio2"> <!--- when the box is checked highligt the box---->
        <label for="radio2" class="cb_label"> Gratis medlem</label>
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
          
        <!-------------- VALIDATION START --------------->
            <script> 
                function validate(form) {
                    fail  = validateForNavn(form.forNavn.value)
                    fail += validateEfterNavn(form.efterNavn.value)
                    fail += validateEmail(form.email.value)
                    fail += validateTelefon(form.email.value)
                    fail += validateAdresse(form.adresse.value)
                    fail += validatePostnummer(form.postnummer.value)
                    fail += validateBrugernavn(form.brugerNavn.value)
                    fail += validatePassword(form.password.value)
                    fail += validateGentagPassword(form.gentagPassword.value)
                    if (fail == "") return true
                    else { alert(fail); return false }
                }
            </script>
            <script>
            function validateForNavn(field) {
            if (field == "") return "Ugyldigt fornavn.\n"
                else if (!(field.indexOf (/[^0-9.@_-]/.test(field))))
                    return "Navnet er ugyldigt.\n"
            return ""
            }

            function validateEfterNavn(field) {
            if (field == "") return "Ugyldigt efternavn.\n"
                else if (!(field.indexOf (/[^0-9.@_-]/.test(field))))
                    return "Navnet er ugyldigt.\n"
            return ""
            }
            
            function validateEmail(field) {
            if (field == "") return "Ingen Email indtastet.\n"
		else if (!((field.indexOf(".") > 0) &&
			       (field.indexOf("@") > 0)) ||
			       /[^a-åA-Å0-9.@_-]/.test(field))
		return "Email adressen er ugyldig.\n"
            return ""
            }
            
            function validateTelefon(field) {
            if (field == "") return "Intet telefonnummer indtastet.\n"
		else if (!((field.indexOf(/[^a-åA-Å.@_-]/.test(field))
		return "Telefonnummeret er ugyldigt.\n"
            return ""
            }
            
            function validateAdresse(field) {
            if (field == "") return "Ingen adresse indtastet.\n"
            return ""
            }
            
            function validatePostnummer(field) {
            if (field == "") return "Intet Postnummer indtastet.\n"
		else if (!((field.indexOf(field.length > 4 && /[^a-åA-Å.@_-]/.test(field))
		return "Postnummeret er ugyldigt.\n"
            return ""
            }
            
            function validateBrugernavn(field) {
            if (field == "") return "Intet brugernavn indtastet.\n"
            else if (field.length < 5)
		return "Brugernavn skal være mindst 5 karakterer langt.\n"
            else if (/[^a-zA-Z0-9_-]/.test(field))
		return "Kun karaktererne a-å, A-Å, 0-9, - og _ er tilladte i brugernavne.\n"
            return ""
            }
            function validatePassword(field) {
            if (field == "") return "Intet password indtastet.\n"
            else if (field.length < 6)
		return "Passwords skal være mindst 6 karakterer langt.\n"
            else if (! /[a-å]/.test(field) ||
			 ! /[A-Å]/.test(field) ||
		     ! /[0-9]/.test(field))
		return "Passwords kræver mindst én af hver følgende karakter a-å, A-Å og mindst ét tal mellem 0-9.\n"
            return ""
            }
            function validateGentagPassword(field) {
            if (field == "") return "Intet gentaget password indtastet.\n"
		else if (field != validatePassword)  //Don't know if this is correct 
		return "Gentaget password matcher ikke.\n"
            return ""
            }
    </script>      
    <!-------------- VALIDATION END --------------->
            <script type="text/javascript">
                function select()
                {
                 var1=document.getElementById("radio1");
                 var2=document.getElementById("radio2");
                 if(var1.checked==true)
                 {
                    document.register.action="CreatePayingMember";
                 }
                 else
                 {
                    document.register.action="CreateRegisteredCustomer";
                 }
               }
            </script>
        	<form onsubmit="return validate(this)" method="post" action="" name="register">
                    <div><label for="name">Navn: </label><br><input name="firstName" type="text" id="name" class="reg_field"/></div><br>        
                    <div><label for="surname">Efternavn: </label><br><input name="lastName" type="text" id="surname" class="reg_field"/></div><br>
                    <div><label for="email">Email: </label><br><input name="email" type="email" id="email" class="reg_field"/></div><br>
                    <div><label for="phone">Tlf: </label><br><input name="phone" type="text" id="phone" class="reg_field"/></div><br>
                    <div><label for="address">Adresse: </label><br><input name="address" type="text" id="address" class="reg_field"/></div><br>
                    <div><label for="pnr">Postnummer: </label><br><input type="text" id="pnr" class="reg_field"/></div><br>
                    <br>
                    <div><label for="username">Brugernavn: </label><br><input name="username" type="text" id="username" class="reg_field"/></div><br>
                    <div><label for="pw">Kode: </label><br><input name="password" type="password" id="pw" class="reg_field"/></div><br>
                    <div><label for="pw">Gentag kode: </label><br><input type="password" id="pw" class="reg_field"/></div><br>
                    <br>
                
				<input type="checkbox" name="accept_checkbox"><label for="accept_checkbox" id="accept_label"> Jeg har læst og accepter <a href="#">betalings vilkår</a></label>
                <div><input type="submit" value="Registrér" id="reg_button" onSubmit="return validate(this)"/></div> <!---- have to be moved down 'on top of' the backgorund, don't know if possible as it is in a form-->
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
          <li><a href="blog.jsp">Blog</a></li>
          <li><a href="webshop.jsp">Webshop</a></li>
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

