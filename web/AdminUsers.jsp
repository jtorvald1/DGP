
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User administration</title>
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
        <script src="Js/AdminUsers.js"></script>
    </head>
    <body>
        <center><h1>User Administration</h1></center>
        <div id="container">
            <div class="content">
                <table class="tg">
                    <tr>
                        <th colspan="7">Users</th>
                    </tr>
                    <tr>
                        <td>User ID</td>
                        <td>Username</td>
                        <td>Password</td>
                        <td>First name</td>
                        <td>Last name</td>
                        <td>Address</td>
                        <td>Email</td>
                        <td>Is paying-member</td>
                        <td>Membership fee</td>
                        <td>Membership period</td>
                    </tr>
                    <c:forEach items="${users.getUsers()}" var="user" >
                        <tr>
                            <td>${user.getUserId()}</td>
                            <td>${user.getUserName()}</td>
                            <td>${user.getPassword()}</td>
                            <td>${user.getFirstName()}</td>
                            <td>${user.getLastName()}</td>
                            <td>${user.getAddress()}</td>
                            <td>${user.getEmail()}</td>
                            <td>${user.getIsPayingMember()}</td>
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
                            <td>User ID: </td>
                            <td><input type="text" class="fields" id="userId" name="userId" value="${lastSearchedUser.getUserId()}"></td>
                            <td>
                                <select id="searchFor">
                                    <option value="userId">User ID</option>
                                    <option value="username">Username</option>
                                    <option value="password">Password</option>
                                    <option value="firstName">First Name</option>
                                    <option value="lastName">Last Name</option>
                                    <option value="address">Address</option>
                                    <option value="email">Email</option>
                                    <option value="all">All Users</option>
                                </select>
                            <td>
                        </tr>
                        <tr>
                            <td>Username: </td>
                            <td><input type="text" class="fields" id="username" name="username" value="${lastSearchedUser.getUserName()}"></td>
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td><input type="text" class="fields" id="password" name="password" value="${lastSearchedUser.getPassword()}"></td>
                        </tr>
                        <tr>
                            <td>First Name: </td>
                            <td><input type="text" class="fields" id="firstName" name="firstName" value="${lastSearchedUser.getFirstName()}"></td>
                        </tr>
                        <tr>
                            <td>Last Name: </td>
                            <td><input type="text" class="fields" id="lastName" name="lastName" value="${lastSearchedUser.getLastName()}"></td>
                        </tr>
                        <tr>
                            <td>Address: </td>
                            <td><input type="text" class="fields" id="address" name="address" value="${lastSearchedUser.getAddress()}"></td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td><input type="text" class="fields" id="email" name="email" value="${lastSearchedUser.getEmail()}"></td>
                        </tr>
                        <tr>
                            <td>Is paying-member: </td>
                            <td><input type="checkbox" class="fields" id="payingMember" name="isPayingMember" value="${lastSearchedUser.getIsPayingMember()}"></td>
                        </tr>
                        <tr>
                            <td><input type="button" onclick="search()" value="Search"></td>
                            <td><input type="button" onclick="$lastSearchedUser.getIsPayingMember()}" value="isPaying?"></td>
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
    </body>
</html>