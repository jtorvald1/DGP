function validateOrderID(value) 
{
    if(value === "") 
        return "Input order ID.\n";
    else 
        if(!(value % 1 === 0))
            return "Input a number in order ID.\n";
    return "";
}

function validateCustomerID(value) 
{
    if(value === "") 
        return "Input customer ID.\n";
    else 
        if(!(value % 1 === 0))
            return "Input a number in customer ID.\n";
    return "";
}

function validateFirstName(value) 
{
    if(value === "") 
        return "Input first name.\n";
    return "";
}

function validateLastName(value) 
{
    if (value === "")
        return "Input last name.\n";
    return "";
}


function searchOrder()
{
    var searchBy = $("#searchFor option:selected").val();
    var value;
    var validationResult;

    switch(searchBy)
    {
        case "orderId": value = $("#orderId").val(); validationResult = validateOrderID(value); break;
        case "customerId": value = $("#customerId").val(); validationResult = validateCustomerID(value); break;
        case "firstName": value = $("#firstName").val(); validationResult = validateFirstName(value); break;
        case "lastName": value = $("#lastName").val(); validationResult = validateLastName(value); break;
        default: value = "allOrders"; validationResult = ""; break;
    }
    if(validationResult !== "")
        alertify.alert(validationResult);
    else
        document.location.href="AdminOrderSearch?searchBy=" + searchBy +"&value=" + value;
}

function deleteOrder()
{
    var orderId = $("#orderId").val();
    var confirmed = confirm("Are you sure you want to delete order number " + orderId + "?");

    if(confirmed) {
        var validationResult = validateOrderID(orderId);
        if(validationResult !== "")
            alertify.alert(validationResult);
        else
            document.location.href="AdminOrderEdit?orderId=" + orderId;
    }
}