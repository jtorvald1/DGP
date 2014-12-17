
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product administration</title>
        <style type="text/css">
            body{font-family:Arial, sans-serif; font-size:14px;}
            .tg  {border-collapse:collapse;border-spacing:0;border-color:#aabcfe;background-color:#e8edff}
            .tg td{padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
            .tg th{font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;color:#039;background-color:#b9c9fe}
            .content {float: left; margin-left: 20px; margin-right: 20px;}
            #description {height: 150px;}
            .fields {width: 300px;}
            #container {margin-left: auto; margin-right: auto; width: 1200px;}
            body{color:#669;}
        </style>
        <script src="Js/alertify.min.js"></script>
        <link rel="stylesheet" href="Css/alertify.min.css" />
        <link rel="stylesheet" href="Css/default.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="Js/AdminProducts.js"></script>
    </head>
    <body>
        <center><h1>Product Administration</h1></center>
        <div id="container">
            <div class="content">
                <table class="tg">
                    <tr>
                        <th colspan="7">Products</th>
                    </tr>
                    <tr>
                        <td>Product ID</td>
                        <td>Product category</td>
                        <td>Brand</td>
                        <td>Color</td>
                        <td>Size</td>
                        <td>Price</td>
                        <td>Weight</td>
                    </tr>
                    <c:forEach items="${products.getAllProducts()}" var="product" >
                        <tr>
                            <td>${product.getProductId()}</td>
                            <td>${product.getCategory()}</td>
                            <td>${product.getBrand()}</td>
                            <td>${product.getColor()}</td>
                            <td>${product.getSize()}</td>
                            <td>${product.getPrice()}</td>
                            <td>${product.getWeight()}</td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <br>
                <table class="tg">
                    <tr>
                        <th colspan="4">Items</th>
                    </tr>
                    <tr>
                        <td>Item ID</td>
                        <td>Product ID</td>
                        <td>Stock</td>
                        <td>Order ID</td>
                    </tr>
                    <c:forEach items="${items.getItems()}" var="item" >
                        <tr>
                            <td>${item.getItemId()}</td>
                            <td>${item.getProductId()}</td>
                            <td>${item.getStockId()}</td>
                            <td><c:choose>
                                    <c:when test="${empty item.getOrderId()}">(Not sold yet)</c:when>
                                    <c:otherwise>${item.getOrderId()}</c:otherwise>
                                </c:choose>    
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="content">
                <form method="post" action="AdminProductEdit" enctype="multipart/form-data" onsubmit="return confirmForm(this)">
                    <table>
                        <tr>
                            <td>Product ID: </td>
                            <td><input type="text" class="fields" id="productId" name="productId" value="${lastSearchedProduct.getProductId()}"></td>
                            <td>
                                <select id="searchFor">
                                    <option value="productId">Product ID</option>
                                    <option value="category">Category</option>
                                    <option value="brand">Brand</option>
                                    <option value="color">Color</option>
                                    <option value="size">Size</option>
                                    <option value="price">Price</option>
                                    <option value="weight">Weight</option>
                                    <option value="all">All products</option>
                                </select>
                            <td>
                        </tr>
                        <tr>
                            <td>Category: </td>
                            <td><input type="text" class="fields" id="category" name="category" value="${lastSearchedProduct.getCategory()}"></td>
                        </tr>
                        <tr>
                            <td>Brand: </td>
                            <td><input type="text" class="fields" id="brand" name="brand" value="${lastSearchedProduct.getBrand()}"></td>
                        </tr>
                        <tr>
                            <td>Color: </td>
                            <td><input type="text" class="fields" id="color" name="color" value="${lastSearchedProduct.getColor()}"></td>
                        </tr>
                        <tr>
                            <td>Size: </td>
                            <td><input type="text" class="fields" id="size" name="size" value="${lastSearchedProduct.getSize()}"></td>
                        </tr>
                        <tr>
                            <td>Price: </td>
                            <td><input type="text" class="fields" id="price" name="price" value="${lastSearchedProduct.getPrice()}"></td>
                        </tr>
                        <tr>
                            <td>Weight: </td>
                            <td><input type="text" class="fields" id="weight" name="weight" value="${lastSearchedProduct.getWeight()}"></td>
                        </tr>
                        <tr>
                            <td>Number of items to create:</td>
                            <td><input type="text" class="fields" id="items" name="items"></td>
                        </tr>
                        <tr>
                            <td>Description: </td>
                            <td><textarea class="fields" id="description" name="description">${lastSearchedProduct.getDescription()}</textarea></td>
                        </tr>
                        <tr>
                            <td>Image: </td>
                            <td><img alt="" class="fields" src="data:image/jpg;base64, ${lastSearchedProduct.getImage()}"></td>
                        </tr>
                        <tr>
                            <td>New image: </td>
                             <td><input type="file" name="image"></td>
                        </tr>
                        <tr>
                            <td><input type="button" onclick="search()" value="Search"></td>
                            <td><input type="button" onclick="deleteProduct()" value="Delete product"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="operation" value="Edit product"></td>
                            <td><input type="submit" name="operation" value="Create new product"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="column_text">
            <a href="NewArticle.jsp">New article</a>
            <br>
            <a href="NewBlog.jsp">New blog</a>
            <br>
            <a href="AdminProducts.jsp">Edit product</a>
            <br>
            <a href="AdminOrders.jsp">Edit orders</a>
            <br>
            <a href="AdminUsers.jsp">Edit Users</a>
            <br>
            <a href="LogOffUser">Logout</a>
            <br>
        </div>
    </body>
</html>