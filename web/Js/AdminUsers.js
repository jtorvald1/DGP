function validateUserID(value) 
{
    if(value === "") 
        return "Input User ID.\n";
    else 
        if(!(value % 1 === 0))
            return "Input a number in User ID.\n";
    return "";
}

function validateUsername(value) 
{
    if(value === "") 
        return "Input username.\n";
    return "";
}

function validatePassword(value) 
{
    if (value === "")
        return "Input password.\n";
    return "";
}

function validateFirstName(field) {
    if (field === "") 
        return "Input first name.\n";
    return "";
}

function validateLastName(field) {
    if (field === "") 
        return "Input last name.\n";
    return "";
}

function validateAddress(field) {
    if (field === "") 
        return "Input address.\n";
    return "";
}

function validateEmail(field) 
{
    if(field === "") 
        return "Input email.\n";
    return "";
}

function validateIsPayingMember() 
{
    var ele = document.getElementById("isPayingMember");
    if(ele.checked){
        var confirmed = confirm("Are you sure you this member to be a paying member?");

                if(confirmed) {
                    return "";
                }
                return "Make desired changes and try again.\n";
            }
    else{
        var confirmed = confirm("Are you sure you this member to be a free member?");

                if(confirmed) {
                    return "";
                }
                return "Make desired changes and try again.\n";
            }
}

function search()
{
    var searchBy = $("#searchFor option:selected").val();
    var value;
    var validationResult;
    
    switch(searchBy)
    {
        case "userId": value = $("#userId").val(); validationResult = validateUserID(value); break;
        case "username": value = $("#username").val(); validationResult = validateUsername(value); break;
        case "password": value = $("#password").val(); validationResult = validatePassword(value); break;
        case "firstName": value = $("#firstName").val(); validationResult = validateFirstName(value); break;
        case "lastName": value = $("#lastName").val(); validationResult = validateLastName(value); break;
        case "address": value = $("#address").val(); validationResult = validateAddress(value); break;
        case "email": value = $("#email").val(); validationResult = validateEmail(value); break;
        default: value = "all"; validationResult = "";  break;
    }
    if(validationResult !== "")
        alertify.alert(validationResult);
    else
        document.location.href="AdminUserSearch?searchBy=" + searchBy +"&value=" + value;
}

function deleteUser()
{
    var userId = $("#userId").val();
    var confirmed = confirm("Are you sure you want to delete user number " + userId + "?");
    
    if(confirmed) {
        var validationResult = validateUserID(userId);
        if(validationResult !== "")
            alertify.alert(validationResult);
        else
            document.location.href="AdminCustomerEdit?operation=delete&userId=" + userId;
    }
}

function confirmForm(form)
{
    var confirmed = confirm("Are you sure you want to proceed?");
    
    if(confirmed) {
        var validationResult = validateForm(form);
        if(validationResult)
        return true;
    }
    return false;
}

function validateForm(form)
{
    var fail = "";
    
    fail = validateUserID(form.userId.value);
    fail += validateUsername(form.username.value);
    fail += validatePassword(form.password.value);
    fail += validateFirstName(form.firstName.value);
    fail += validateLastName(form.lastName.value);
    fail += validateAddress(form.address.value);
    fail += validateEmail(form.email.value);
    fail += validateIsPayingMember(form.isPayingMember.value);
    
    if(fail !== "")
    {
        alertify.alert(fail);
        return false;
    }
    else
        return true;
}