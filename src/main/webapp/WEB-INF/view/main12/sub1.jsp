<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>if</h3>
<c:if test="${age >= 20}">
    <p>투표 가능</p>
</c:if>
<c:if test="${age < 20}">
    <p>투표 불가능</p>
</c:if>
<%-- products 속성이 빈 리스트면
    상품이 없습니다. 출력
    빈 리스트가 아니면 2개의 요소 출력
--%>
<c:if test="${empty products}" var="result">
    <p>상품이 없습니다.</p>
</c:if>
<c:if test="${not result}">
    <ul>
        <li>${products[0]}</li>
        <li>${products[1]}</li>
    </ul>
</c:if>
<h3>country가 korea이고 age가 20이상이면 투표 가능</h3>

<p>${member.country == "korea" && member.age > 20 ? "투표 가능" : "투표 불가능" }</p>
</body>
</html>
