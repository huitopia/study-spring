<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>직원 조회 및 수정</h3>
<form action="">
    no
    <input type="number" name="id">
    <button>search</button>
</form>
<hr>
<c:if test="${empty employee}">
    조회된 직원이 없습니다.
</c:if>
<c:if test="${not empty employee}">
    <c:if test="${not empty message}">
        <div>
                ${message}
        </div>
    </c:if>
    <div>
            ${employee.id}번 직원
    </div>
    <form action="/main32/sub6/update" method="post">
        <div>
            lastName
            <input type="text" value="${employee.lastName}" name="lastName">
        </div>
        <div>
            firstName
            <input type="text" value="${employee.firstName}" name="firstName">
        </div>
        <div>
            birthDate
            <input type="text" value="${employee.birthDate}" name="birthDate">
        </div>
        <div>
            photo
            <input type="text" value="${employee.photo}" name="photo">
        </div>
        <div>
            notes
            <textarea name="notes" id="" cols="30" rows="10">${employee.notes}</textarea>
        </div>
        <input type="hidden" name="id" value="${employee.id}">
        <div>
            <button>update</button>
        </div>
    </form>
</c:if>
</body>
</html>
