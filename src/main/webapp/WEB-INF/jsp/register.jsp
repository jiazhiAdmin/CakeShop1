<!-- register.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="http://localhost:8080/CakeShop1/doRegister" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br><br>
    <label for="status">Status:</label>
    <input type="text" id="status" name="status"><br><br>
    <label for="role">Role:</label>
    <input type="text" id="role" name="role"><br><br>
    <label for="receiver">Receiver:</label>
    <input type="text" id="receiver" name="receiver"><br><br>
    <label for="receiver_phone">Receiver Phone:</label>
    <input type="text" id="receiver_phone" name="receiverPhone"><br><br>
    <label for="receiver_address">Receiver Address:</label>
    <input type="text" id="receiver_address" name="receiverAddress"><br><br>
    <input type="submit" value="Register">
</form>
<p>${error}</p>
</body>
</html>
