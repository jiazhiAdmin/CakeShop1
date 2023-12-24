<%--
  Created by IntelliJ IDEA.
  User: jia'zhi
  Date: 2023/12/24
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="data-table">
    <%-- <thead>
     <tr>
         <c:forEach items="${headerList}" var="header">
             <th>${header}</th>
         </c:forEach>
         <th>操作</th>
     </tr>
     </thead>--%>
    <tbody>
    <button class="btn-add">新增</button>
    <c:forEach items="${orderlist}" var="order">
        <tr>
            <td>${order.orderId}</td>
            <td>${order.userId}</td>
            <td>${order.orderName}</td>
            <td>${order.orderDate}</td>
            <td>${order.orderQuantity}</td>
            <td>${order.orderTotalAmount}</td>
            <td>${order.paymentStatus}</td>
            <td>${order.paymentMethod}</td>
            <td>${order.receiver}</td>
            <td>${order.receiverPhone}</td>
            <td>${order.deliveryAddress}</td>
            <td>

                <button class="btn-edit">修改</button>
                <button class="btn-delete">删除</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
