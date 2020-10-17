<%-- 
    Document   : shoppinglist
    Created on : Oct 17, 2020, 1:41:52 PM
    Author     : Birdd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${name}</p>

        <form action="" method="POST">
            <input type="text" name="item"><input type="submit" value="Add Item">
            <input type="hidden" name="action" value='add'>
        </form>
        
        <form action="" method="post">
        <c:forEach items="${items}" var="items">
     
            <input type="radio" name='anItem' values="${items}">${items} <br>
                   

        </c:forEach>       
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
        <p><a href="ShoppingList?action=logout"</a>Logout</p>
    </body>
</html>
