<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${param.type eq 'fail'}">
    로그인 실패
</c:if>
<form action="/main22/sub7" method="post">
    <div>
        ID
        <input type="text" name="id">
    </div>
    <div>
        PW
        <input type="password" name="password">
    </div>
    <input type="submit" value="LOGIN">
</form>
</body>
</html>
