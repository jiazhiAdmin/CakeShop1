<%--
  Created by IntelliJ IDEA.
  User: jia'zhi
  Date: 2023/12/20
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>footer</title>
</head>
<body>
    <footer>
        <div class="fenye">
            <div class="fenyeleft">
                <c:if test="${pageNum > 1}">
                    <a href="?pageNum=${pageNum - 1}&pageSize=${pageSize}">上一页</a>
                </c:if>

                <c:forEach var="i" begin="1" end="${total+1}">
                    <c:choose>
                        <c:when test="${i == pageNum}">
                            <span class="current">${i}</span>
                        </c:when>
                        <c:otherwise>
                            <a href="?pageNum=${i}&pageSize=${pageSize}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${pageNum < total+1}">
                    <a href="?pageNum=${pageNum + 1}&pageSize=${pageSize}">下一页</a>
                </c:if>
            </div>
            <div class="fenyeright">
                <form class="fenyeform" action="http://localhost:8080/CakeShop1/all" method="get">
                    <div class="fenyeformInput">
                        <span>到</span>
                        <input id="pageNumInput" type="text" name="pageNum">
                        <span>页</span>
                        <input type="submit" value="确定">
                    </div>
                </form>
            </div>
        </div>
    </footer>
</body>
</html>
