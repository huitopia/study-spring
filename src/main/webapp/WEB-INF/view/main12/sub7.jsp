<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .table {
            border-collapse: collapse;
            border: 1px solid black;
            width: 800px;
        }

        .table td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h3>Player</h3>
<table class="table">
    <thead>
    <tr>
        <td>No</td>
        <td>Name</td>
        <td>Team</td>
        <td>Country</td>
        <td>Event</td>
        <td>Position</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${playerList}" var="player" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${player.name}</td>
            <td>${player.team}</td>
            <td>${player.country}</td>
            <td>${player.event}</td>
            <td>
                <c:forEach items="${player.positions}" var="position" varStatus="stat">
                    ${position}
                    <c:if test="${not stat.last}">
                        ,
                    </c:if>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
