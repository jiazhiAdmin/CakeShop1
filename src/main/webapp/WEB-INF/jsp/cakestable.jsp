<%--
  Created by IntelliJ IDEA.
  User: jia'zhi
  Date: 2023/12/24
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


</head>
<body>
<!-- 弹框的静态 HTML 代码 -->
<%--<button class="btn-add" onclick="showDialog()">新增</button>
<div id="dialog" style="display:none;" >
    <form>
        <label for="username">用户名：</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">密码：</label>
        <input type="password" id="password" name="password"><br>
        <label for="email">邮箱：</label>
        <input type="text" id="email" name="email"><br>
        <!-- 其他字段的输入框 -->
        <button id="confirm" onclick="addUser()">确认</button>
    </form>
</div>--%>
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


    <!-- 在<body>标签中添加弹框的HTML代码 -->
    <%--<div id="dialog" >
        <label for="username">用户名：</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">密码：</label>
        <input type="password" id="password" name="password"><br>
        <label for="email">邮箱：</label>
        <input type="text" id="email" name="email"><br>
        <!-- 其他字段的输入框 -->
        <button id="confirm" onclick="adduser()">确认</button>
    </div>--%>

    <c:forEach items="${cakelist}" var="cake">

        <tr>
            <td>${cake.cakeName}</td>
            <td>${cake.cakeInventory}</td>
            <td>${cake.cakeDescription}</td>
            <td>${cake.cakePrice}</td>
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
    function showDialog() {
        // 显示弹框
        document.getElementById("dialog").style.display = "block";
    }

    function addUser() {
        // 获取表单数据
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var email = document.getElementById("email").value;

        // 在这里编写处理用户数据的逻辑
        console.log("用户名：" + username);
        console.log("密码：" + password);
        console.log("邮箱：" + email);

        // 关闭弹框
        document.getElementById("dialog").style.display = "none";
    }
</script>

</html>
