<%--
  Created by IntelliJ IDEA.
  User: jia'zhi
  Date: 2023/12/20
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>

        function increaseQuantity(orderDetailId) {
            // 发送ajax请求，调用后端接口增加数量
            // 示例代码：
            $.ajax({
                url: "http://localhost:8080/CakeShop1/increaseQuantity",
                type: "POST",
                data: { orderDetailId: orderDetailId },
                success: function(response) {
                    if (response.status === 200) {
                        // 处理成功响应
                        console.log("数量+1成功");
                        // 刷新页面
                        location.reload();
                    } else {
                        // 处理错误响应
                        console.error("数量+1失败：" + response.message);
                    }
                },
                error: function(error) {
                    // 处理错误响应
                    console.error("数量+1失败：" + error.responseText);
                }
            });
        }

        function decreaseQuantity(orderDetailId) {
            // 发送ajax请求，调用后端接口减少数量
            // 示例代码：
            $.ajax({
                url: "http://localhost:8080/CakeShop1/decreaseQuantity",
                type: "POST",
                data: { orderDetailId: orderDetailId
                },
                success: function(response) {
                    if (response.status === 200) {
                        // 处理成功响应
                        console.log("数量-1成功");
                        // 刷新页面
                        location.reload();
                    } else {
                        // 处理错误响应
                        console.error("数量-1失败：" + response.message);
                    }
                },
                error: function(error) {
                    // 处理错误响应
                    console.error("数量-1失败：" + error.responseText);
                }
            });
        }

        function deleteOrderDetail(orderDetailId) {
            // 发送ajax请求，调用后端接口删除订单详情
            // 示例代码：
            $.ajax({
                url: "http://localhost:8080/CakeShop1/deleteOrderDetail",
                type: "POST",
                data: { orderDetailId: orderDetailId },
                success: function(response) {
                    if (response.status === 200) {
                        // 处理成功响应
                        console.log("蛋糕删除成功");
                        // 刷新页面
                        location.reload();
                    } else {
                        // 处理错误响应
                        console.error("蛋糕删除失败：" + response.message);
                    }
                },
                error: function(error) {
                    // 处理错误响应
                    console.error("蛋糕删除失败：" + error.responseText);
                }
            });
        }

        function calculateSelectedItems() {
                var checkboxes = document.getElementsByName("selectedItems");
                var selectedQuantity = 0;
                var selectedPrice = 0;
                for (var i = 0; i < checkboxes.length; i++) {
                    var row = checkboxes[i].parentNode.parentNode;
                    var quantity = parseInt(row.cells[4].innerText);
                    var price = parseFloat(row.cells[9].innerText.replace("元", ""));

                    if (checkboxes[i].checked) {
                        selectedQuantity += quantity;
                        selectedPrice+= price;
                    } else {
                        selectedQuantity-=quantity;
                        selectedPrice -= price;
                    }
                }
                document.getElementById("selectedQuantitySum").innerText = selectedQuantity;
                document.getElementById("selectedPriceSum").innerText = selectedPrice + "元";

                console.log("已选数量累加和：" + selectedQuantity);
                console.log("已选价格累加和：" + selectedPrice);
        }


        function sendSelectedItems() {
            var selectedQuantity = parseInt(document.getElementById("selectedQuantitySum").innerText);
            var selectedPrice = parseFloat(document.getElementById("selectedPriceSum").innerText.replace("元", ""));
            var  userId= document.getElementById("userId").value;
            var  receiver= document.getElementById("receiver").value;
            var  receiverPhone= document.getElementById("receiverPhone").value;
            var  receiverAddress= document.getElementById("receiverAddress").value;

            var order={
                userId:userId,
                orderName:"aaa",
                orderDate:new Date(),
                orderQuantity:selectedQuantity,
                orderTotalAmount:selectedPrice,
                paymentMethod:"微信支付",
                paymentStatus:"未支付",
                receiver:receiver,
                //jia ""?
                receiverPhone:receiverPhone,
                deliveryAddress:receiverAddress
            }
            // 使用Ajax发送选中的值到后端接口
            $.ajax({
                url: "http://localhost:8080/CakeShop1/order/add",
                type: "POST",
                data: JSON.stringify(order),
                contentType: "application/json",
                success: function(response) {
                    if (response) {
                        // 处理成功响应
                        console.log("支付成功");
                        // 刷新页面或跳转到其他页面
                        location.reload();
                    } else {
                        // 处理错误响应
                        console.error("支付失败");
                    }
                },
                error: function(error) {
                    // 处理错误响应
                    console.error("支付失败：" + error.responseText);
                }
            });
        }


        function selectAllItems() {
            var checkboxes = document.getElementsByName("selectedItems");
            var selectAllCheckbox = document.getElementById("selectAll");

            for (var i = 0; i < checkboxes.length; i++) {
                checkboxes[i].checked = selectAllCheckbox.checked;
            }
            calculateSelectedItems();
        }
    </script>
</head>
<body>
    <h1>Cart List</h1>
    ${user}
    ${userId}
    ${receiver}
    ${receiverPhone}
    ${receiverAddress}
    <input type="hidden" id="user" value="${user}">
    <input type="hidden" id="userId" value="${userId}">
    <input type="hidden" id="receiver" value="${receiver}">
    <input type="hidden" id="receiverPhone" value="${receiverPhone}">
    <input type="hidden" id="receiverAddress" value="${receiverAddress}">
    <table>
        <tr>
            <th>蛋糕名</th>
            <th>Order Detail ID</th>
            <th>Cake ID</th>
            <th>Cake Quantity</th>
            <th>Cake Price</th>
            <th>Order ID</th>
            <th>User ID</th>
            <th>操作</th>
            <th>数量乘价格价</th>
        </tr>

        <c:set var="totalPrice" value="0" />
        <c:forEach items="${orderDetails}" var="orderDetail" varStatus="loop">
            <c:set var="Price" value="${orderDetail.cakeQuantity * orderDetail.cakePrice}" />
            <c:set var="totalPrice" value="${totalPrice + Price}" />
            <tr>
                <td><input type="checkbox" name="selectedItems" value="${orderDetail.orderDetailId}"  onclick="calculateSelectedItems()" /></td>
                <td>${cakes[loop.count-1].cakeName}</td>
                <td>${orderDetail.orderDetailId}</td>
                <td>${orderDetail.cakeId}</td>
                <td>${orderDetail.cakeQuantity}</td>
                <td>${orderDetail.cakePrice}</td>
                <td>${orderDetail.orderId}</td>
                <td>${orderDetail.userId}</td>
                <td>
                    <button onclick="increaseQuantity(${orderDetail.orderDetailId})">加一</button>
                    <button onclick="decreaseQuantity(${orderDetail.orderDetailId})">减一</button>
                    <button onclick="deleteOrderDetail(${orderDetail.orderDetailId})">删除</button>
                </td>
                <td>${Price}元</td>
            </tr>
        </c:forEach>

    </table>
    全选：<input type="checkbox" id="selectAll"  onclick="selectAllItems()" /><br>
    总价：${totalPrice}元
    <button onclick="sendSelectedItems()">支付</button>

    <p>已选数量累加和： <span id="selectedQuantitySum"></span></p>
    <p>已选价格累加和： <span id="selectedPriceSum"></span></p>

</body>
</html>
