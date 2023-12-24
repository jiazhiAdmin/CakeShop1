<%--
  Created by IntelliJ IDEA.
  User: jia'zhi
  Date: 2023/12/15
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
<%--    <link rel="stylesheet" type="text/css" href="../../css/index.css">--%>
    <style>
        #wrapper{
            .headTop{
                background-color: brown;
                height: 50px;
                margin: 0 auto;
                line-height: 20px;
                .headTopMain{
                    overflow: hidden;
                    .left{
                        float:left;
                        h5{
                            float: left;
                            margin-left: 80px;
                            margin-bottom: 800px;
                            margin-right: 80px;
                            margin-top: 18px;
                        }
                        p{
                            float: left;

                            &:first-child{
                                border-right:solid 1px blue;
                                margin-right: 2px;
                                padding-right: 5px;
                            }
                        }
                    }
                    .right{
                        float:right;
                        margin-top: 18px;
                        margin-left: 70px;
                        margin-right: 70px;
                        border: blue;
                    }
                }
            }
            .headBottom{
                .headBottomMain{
                    width: 1200px;
                    margin: 0 auto;
                    overflow: hidden;
                    .logo{
                        float: left;
                        background: blue;
                        a{
                            img{
                                width: 50px;
                                height: 50px;
                                margin: 25px 45px;
                            }
                        }
                    }
                    .search{
                        float: right;
                        background: red;
                        margin-top: 35px;
                        input{
                            &:first-child{
                                box-sizing: border-box;
                                width: 490px;
                                height: 32px;
                                padding: 0 4px;
                                border: 2px solid red;
                                float: left;
                            }
                            &:last-child{
                                background: red;
                                width: 68px;
                                height: 32px;
                                color: blue;
                                border: none;
                            }
                        }
                    }
                }
            }
            .typeNav{
                .typeMain{
                    width: 1200px;
                    margin: 0 auto;
                    background: darkgreen;
                    a {
                        margin: 0 22px;
                        float: left;
                        text-align: center;
                        line-height: 50px;
                        &:first-child {
                            float: left;
                            width: 210px;
                            height: 50px;
                            background: red;
                            color: aliceblue;
                            text-align: center;
                            line-height: 50px;
                        }
                    }
                }
            }
            .list{
                width: 1200px;

                display: flex;
                flex-wrap:wrap;

                background: blueviolet;
                justify-content: flex-start; /* 将 justify-content 修改为 flex-start */
                margin: 80px auto;

                .cake{
                    float: left;
                    width: 270px;
                    height: 130px;
                    background: aqua;
                    margin-bottom: 25px;
                    margin-right: 20px; /* 添加右侧间距 */
                }
            }
            .fenye{
                display: flex;
                align-items: center;
                justify-content: space-between; /* 让子元素之间均匀分布 */
                .fenyeleft{
                    width: 80px;
                    height: 40px;
                    margin-left: 80px;
                }
                .fenyeright{
                    width: 80px;
                    height: 40px;
                    margin-right: 100px;

                }
            }
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>

        function addOrderDetail(cakeId,cakePrice,userId) {
            var orderDetail = {
                cakeId: cakeId,
                cakeQuantity: 1,
                cakePrice: cakePrice,
                userId:userId,
            };

            $.ajax({
                url: "http://localhost:8080/CakeShop1/orderDetail/add",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(orderDetail),
                success: function(response) {
                    console.log(response);
                },
                error: function(xhr, status, error) {
                    console.error(error);
                    if (xhr.status === 401) {
                        window.location.href = "http://localhost:8080/CakeShop1/login"; // 跳转到登录页面
                    } else {
                        console.error(error);
                    }
                }
            });
        }







    </script>
</head>
<body>
<div id="wrapper">
    <%@ include file="header.jsp" %>
        <dic class="typeNav">
            <div class="typeMain">
                <a href="http://localhost:8080/CakeShop1/all">蛋糕分类</a>
                <c:forEach items="${types}" var="type">
                    <a href="http://localhost:8080/CakeShop1/typecake?typeName=${type.typeName}">${type.typeName}</a>
                </c:forEach>
            </div>
        </dic>

    <%@ include file="cakes.jsp" %>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
