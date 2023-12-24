<%--
  Created by IntelliJ IDEA.
  User: jia'zhi
  Date: 2023/12/20
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<p id="userId">用户id：${user.id}</p>
<header>
        <div class="headTop">
            <div class="headTopMain">
                <div class="left">
                    <h5>欢迎来到蛋糕店</h5>
                    <c:choose>
                        <c:when test="${user==null}">
                            <p>
                                <a href="http://localhost:8080/CakeShop1//login">登录</a>
                                <a href="http://localhost:8080/CakeShop1/register">注册</a>
                            </p>
                        </c:when>
                        <c:otherwise>
                            <p> 用户：${user.username}</p>
                            <a href="http://localhost:8080/CakeShop1//logout">Logout</a>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="right">
                    <nav>

                        <a href="javascript:;">首页</a>
                        <a href="javascript:;">热销</a>
                        <a href="javascript:;">新品</a>
                        <a href="javascript:;">商品分类</a>
                        <a href="javascript:;">搜索</a>
<a href="http://localhost:8080/CakeShop1/cartlist?userId=${user.id}">查看购物车</a>
                        <a href="http://localhost:8080/CakeShop1/houtai">后台管理</a>
                    </nav>
                </div>
            </div>
        </div>
        <div class="headBottom">
            <div class="headBottomMain">
                <div class="logo">
                    <h1>
                        <a>
                            <img src="../img/bg.jpg"    alt="wo shi tupian ">
                        </a>
                    </h1>
                </div>
                <div class="search">
                    <input type="text" id="searchKey" placeholder="请输入想要的蛋糕">
                    <input type="submit" value="搜索"  onclick="searchView();fenyeView()">
                </div>
            </div>
        </div>
    </header>
</body>

<script>




   function searchView() {
        var searchKeyword = document.getElementById("searchKey").value;

        // 在这里执行搜索操作，可以发送Ajax请求或其他操作
        $.ajax({
            url: "http://localhost:8080/CakeShop1/searchCakes",
            type: "GET",
            data: {
                keyword: searchKeyword,
            },
            success: function(response) {
                $('.list').html(response);
                console.log("搜索成功")
            },
            error: function(xhr, status, error) {
                console.log("搜索失败");
            },
        });
   }
   function fenyeView() {
       var searchKeyword = document.getElementById("searchKey").value;

       // 在这里执行搜索操作，可以发送Ajax请求或其他操作
       $.ajax({
           url: "http://localhost:8080/CakeShop1/fenye",
           type: "GET",
           data: {
               keyword: searchKeyword,
           },
           success: function(response) {
               $('.fenye').html(response);
               console.log("搜索分页成功")},
           error: function(xhr, status, error) {
               console.log("分页分页失败");
           },
       });
   }
</script>



</html>
