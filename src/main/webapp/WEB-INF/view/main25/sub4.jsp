<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>고객 정보 조회</h3>
<form action="/main25/sub4">
    <input type="text" name="name" placeholder="고객 이름 입력">
    <input type="submit" value="조회">
</form>
<ol>
    <c:forEach items="${customers}" var="customer">
        <li>
            <ul>
                <li>Name: ${customer.name}</li>
                <li>Full Address: ${customer.address} ${customer.city} ${customer.postalCode} ${customer.country}</li>
            </ul>
        </li>
    </c:forEach>
</ol>
</body>
</html>
