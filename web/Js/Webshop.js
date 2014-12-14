function removeDuplicates()
{
    var found = [];
    $("select option").each(function() {
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

function goToProductDetails(brand)
{
    document.location.href="Search?searchBy=brand&value=" + brand;
}

function checkOut()
{
    document.location.href="CheckOut";
}