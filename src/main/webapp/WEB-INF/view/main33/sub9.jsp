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
<h3>new data</h3>
<form action="" method="post">
    <div>
        문자열
        <input type="text" name="strVal" value="기본 문자열">
    </div>
    <div>
        정수
        <input type="number" name="intVal" value="100">
    </div>
    <div>
        실수
        <input type="number" name="realVal" value="3.14" step="0.01">
    </div>
    <div>
        날짜
        <input type="date" name="dateVal" value="2024-03-03">
    </div>
    <div>
        날짜시간
        <input type="datetime-local" name="dateTimeVal" value="2024-03-03T12:12:12">
    </div>
    <div>
        <button>save</button>
    </div>
</form>
<hr>
<h3>my_table9 data</h3>
<table>
    <thead>
    <tr>
        <th>varchar</th>
        <th>int</th>
        <th>dec</th>
        <th>date</th>
        <th>dateTime</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${datas}" var="data">
        <tr>
            <td>${data.stringCol}</td>
            <td>${data.intCol}</td>
            <td>${data.decCol}</td>
            <td>${data.dateCol}</td>
            <td>${data.dateTimeCole}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
