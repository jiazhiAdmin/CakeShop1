<%--
  Created by IntelliJ IDEA.
  User: jia'zhi
  Date: 2023/12/24
  Time: 13:41
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

    <div id="dialog" style="display: none;">
        <label for="username">用户名：</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">密码：</label>
        <input type="password" id="password" name="password"><br>
        <label for="email">邮箱：</label>
        <input type="text" id="email" name="email"><br>
        <label for="status">状态：</label>
        <input type="text" id="status" name="status"><br>
        <label for="role">角色：</label>
        <input type="text" id="role" name="role"><br>
        <label for="receiver">接收人：</label>
        <input type="text" id="receiver" name="receiver"><br>
        <label for="receiverPhone">接收人电话：</label>
        <input type="text" id="receiverPhone" name="receiverPhone"><br>
        <label for="receiverAddress">接收人地址：</label>
        <input type="text" id="receiverAddress" name="receiverAddress"><br>
        <!-- 其他字段的输入框 -->
        <button id="confirm">确认</button>
    </div>

    <c:forEach items="${userList}" var="user">
        <tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.status}</td>
            <td>${user.role}</td>
            <td>${user.receiver}</td>
            <td>${user.receiverPhone}</td>
            <td>${user.receiverAddress}</td>
            <td>
                <button class="btn-edit">修改</button>
                <button class="btn-delete">删除</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script>
    $(document).ready(function() {
        // 点击新增按钮时显示弹框
        $(".btn-add").click(function() {
            $("#dialog").show();
        });

        // 点击确认按钮时发送POST请求
        $("#confirm").click(function() {
            var user = {
                username: $("#username").val(),
                password: $("#password").val(),
                email: $("#email").val(),
                status: $("#status").val(),
                role: $("#role").val(),
                receiver: $("#receiver").val(),
                receiverPhone: $("#receiverPhone").val(),
                receiverAddress: $("#receiverAddress").val()
                // 其他字段的取值
            };

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/CakeShop1/adduser",
                data: JSON.stringify(user),
                contentType: "application/json",
                success: function(response) {
                    // 处理请求成功的逻辑
                    console.log(response);
                },
                error: function(xhr, status, error) {
                    // 处理请求失败的逻辑
                    console.log(error);
                }
            });

            // 隐藏弹框
            $("#dialog").hide();
        });
    });
</script>
</html>
