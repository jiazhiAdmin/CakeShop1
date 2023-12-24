<%--
  Created by IntelliJ IDEA.
  User: jia'zhi
  Date: 2023/12/24
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Cake Detail</h1>
<p>Cake Name: ${cake.cakeName}</p>
<p>Cake Inventory: ${cake.cakeInventory}</p>
<p>Cake Description: ${cake.cakeDescription}</p>
<p>Cake Price: ${cake.cakePrice}</p>

<p>Cake Cover Image: ${cake.cakeCoverImage}</p>
<p>Cake Detailed Photo 1: ${cake.cakeDetailedPhoto1}</p>
<p>Cake Detailed Photo 2: ${cake.cakeDetailedPhoto2}</p>
<!-- 其他属性展示 -->
</body>
</html>
