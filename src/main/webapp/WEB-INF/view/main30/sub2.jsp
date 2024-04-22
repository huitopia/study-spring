<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div>${message}</div>
</c:if>
<form action="">
    No
    <input type="text" name="id">
    <button>Search</button>
</form>
<hr>
<h3>${employee.id}번 직원</h3>
<form action="/main30/sub2/update" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    <div>
        FirstName
        <input type="text" name="firstName" value="${employee.firstName}">
    </div>
    <div>
        LastName
        <input type="text" name="lastName" value="${employee.lastName}">
    </div>
    <div>
        BirthDate
        <input type="text" name="birthDate" value="${employee.birthDate}">
    </div>
    <div>
        Photo
        <input type="text" name="photo" value="${employee.photo}">
    </div>
    <div>
        Notes
        <textarea name="notes" id="" cols="30" rows="10"
        >${employee.notes}</textarea>
    </div>
    <div>
        <button>Update</button>
    </div>
</form>
</body>
</html>
