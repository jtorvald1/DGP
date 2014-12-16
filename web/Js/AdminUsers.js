function validateProductID(value) 
{
    if(value === "") 
        return "Input product ID.\n";
    else 
        if(!(value % 1 === 0))
            return "Input a number in Product ID.\n";
    return "";
}

function validateCategory(value) 
{
    if(value === "") 
        return "Input category.\n";
    return "";
}

function validateBrand(value) 
{
    if (value === "")
        return "Input brand.\n";
    return "";
}

function validateSize(field) {
    if (field === "") 
        return "Input size.\n";
    return "";
}

function validateColor(field) {
    if (field === "") 
        return "Input color.\n";
    return "";
}

function validateDescription(field) {
    if (field === "") 
        return "Input description.\n";
    return "";
}

function validatePrice(value) 
{
    if(value === "") 
        return "Input price.\n";
    else 
        if(isNaN(value))
            return "Input a number in Price.\n";
    return "";
}

function validateWeight(value) 
{
    if(value === "") 
        return "Input weight.\n";
    else 
        if(isNaN(value))
            return "Input a number in Weight.\n";
    return "";
}

function search()
{
    var searchBy = $("#searchFor option:selected").val();
    var value;
    var validationResult;
    
    switch(searchBy)
    {
        case "userId": value = $("#userId").val(); validationResult = validateProductID(value); break;
        case "username": value = $("#username").val(); validationResult = validateCategory(value); break;
        case "password": value = $("#password").val(); validationResult = validateBrand(value); break;
        case "firstName": value = $("#firstName").val(); validationResult = validateColor(value); break;
        case "lastName": value = $("#lastName").val(); validationResult = validateSize(value); break;
        case "address": value = $("#address").val(); validationResult = validatePrice(value); break;
        case "email": value = $("#email").val(); validationResult = validateWeight(value); break;
        case "isPayingMember": value = $("#isPayingMember").val(); alert(value); validationResult = validateWeight(value); break;
        default: value = "all"; validationResult = "";  break;
    }
    //if(validationResult !== "")
        //alertify.alert(validationResult);
    //else
        document.location.href="AdminUserSearch?searchBy=" + searchBy +"&value=" + value;
}

function deleteProduct()
{
    var productId = $("#productId").val();
    var confirmed = confirm("Are you sure you want to delete product number " + productId + "?");
    
    if(confirmed) {
        var validationResult = validateProductID(productId);
        if(validationResult !== "")
            alertify.alert(validationResult);
        else
            document.location.href="AdminProductEdit?operation=delete&productId=" + productId;
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
    
    fail = validateProductID(form.productId.value);
    fail += validateCategory(form.category.value);
    fail += validateBrand(form.brand.value);
    fail += validateColor(form.color.value);
    fail += validateSize(form.size.value);
    fail += validatePrice(form.price.value);
    fail += validateWeight(form.weight.value);
    fail += validateDescription(form.description.value);
    
    if(fail !== "")
    {
        alertify.alert(fail);
        return false;
    }
    else
        return true;
}