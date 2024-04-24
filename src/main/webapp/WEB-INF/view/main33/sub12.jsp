<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, tr, th, td {
            border-collapse: collapse;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h3>new create</h3>
<form action="" method="post">
    <div>
        title
        <input type="text" name="title">
    </div>
    <div>
        name
        <input type="text" name="name">
    </div>
    <div>
        age
        <input type="number" name="age">
    </div>
    <div>
        price
        <input type="number" name="price" step="0.01">
    </div>
    <div>
        published
        <input type="date" name="published">
    </div>
    <div>
        inserted
        <input type="datetime-local" name="inserted">
    </div>
    <button>create</button>
</form>
<hr>
<table>
    <thead>
    <tr>
        <th>title</th>
        <th>name</th>
        <th>age</th>
        <th>price</th>
        <th>published</th>
        <th>inserted</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${datas}" var="data">
        <tr>
            <td>${data.title}</td>
            <td>${data.name}</td>
            <td>${data.age}</td>
            <td>${data.price}</td>
            <td>${data.published}</td>
            <td>${data.inserted}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
