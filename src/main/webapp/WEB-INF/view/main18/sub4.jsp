<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="/WEB-INF/fragment/navbar5.jsp">
    <c:param name="current" value="cart"/>
</c:import>
<h3>cart</h3>
<c:if test="${empty sessionScope.cart}" var="emptyCart">
    empty cart
</c:if>
<c:if test="${not emptyCart}">
    <table>
        <thead>
        <tr>
            <td>product</td>
            <td>quantity</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.cart}" var="item">
            <tr>
                <td>${item.key}</td>
                <td>${item.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
