<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>직원 조회</h3>
<div>
    <form action="/main25/sub1">
        이름 :
        <input type="text" name="name" placeholder="조회 이름 입력">
        <input type="submit" value="조회">
    </form>
</div>
<hr>
<c:forEach items="${employees}" var="employee">
    <div>${employee.id}</div>
    <div>${employee.lastName}</div>
    <div>${employee.firstName}</div>
    <div>
        <input type="date" value="${employee.birthDate}">
    </div>
    <div>${employee.photo}</div>
    <div>
        <textarea readonly>${employee.notes}</textarea>
    </div>
</c:forEach>
<hr>
</body>
</html>
