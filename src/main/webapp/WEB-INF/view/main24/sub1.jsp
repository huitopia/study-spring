<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>firstName</th>
        <th>lastName</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employees" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${employees.firstName}</td>
            <td>${employees.lastName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
