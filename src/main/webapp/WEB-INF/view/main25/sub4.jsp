<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        table {
            width: 80%;
            text-align: center;
        }

        thead {
            background-color: darkgray;

        }
    </style>
</head>
<body>
<h3>고객 정보 조회</h3>
<form>
    <input value="${prevSearch}" type="text" placeholder="조회할 고객 이름을 입력하세요." name="search">
    <input type="submit" value="조회">
</form>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>ContactName</th>
        <th>Address</th>
        <th>City</th>
        <th>PostalCode</th>
        <th>Country</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${customer.name}</td>
            <td>${customer.contactName}</td>
            <td>${customer.address}</td>
            <td>${customer.city}</td>
            <td>${customer.postalCode}</td>
            <td>${customer.country}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
