<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${param.type eq 'fail'}">
    <div style="padding: 20px; background-color: pink">
        아이디와 패스워드를 확인하세요
    </div>
</c:if>
<form action="/main22/sub4" method="post">
    <div>
        id
        <input type="text" name="id">
    </div>
    <div>
        password
        <input type="password" name="password">
    </div>
    <div>
        <input type="submit" value="login">
    </div>
</form>
</body>
</html>
