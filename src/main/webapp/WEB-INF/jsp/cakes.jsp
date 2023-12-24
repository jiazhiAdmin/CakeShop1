<%--
  Created by IntelliJ IDEA.
  User: jia'zhi
  Date: 2023/12/24
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="list">
    <c:forEach items="${cakes}" var="cake">
        <div class="cake">
            <img src="../img/bg.jpg">
            <p>${cake.cakeName}</p>
            <span>${cake.cakePrice}</span>
            <a href="http://localhost:8080/CakeShop1/orderDetail/cake/${cake.cakeId}">查看蛋糕</a>
            <button class="addOrderDetailBtn"  onclick="addOrderDetail(${cake.cakeId},${cake.cakePrice},${user.id})">Add Order Detail</button>
        </div>
    </c:forEach>
</div>
</body>
</html>
