<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>고객목록</h1>
<table style="width: 60%">
    <thead style="background-color: darkgray; font-size: 1.2rem">
    <tr>
        <th>#</th>
        <th>CustomerName</th>
        <th>City</th>
        <th>Country</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer" varStatus="status">
        <tr style="height: 30px; text-align: center">
            <td>${status.count}</td>
            <td>${customer.customerName}</td>
            <td>${customer.city}</td>
            <td>${customer.country}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
