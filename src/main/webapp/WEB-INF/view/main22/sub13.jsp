<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="background-color: lawngreen">
            ${message}
    </div>
</c:if>
<form action="/main22/sub14" method="post">
    <div>
        ID
        <input type="text" name="id">
    </div>
    <div>
        PW
        <input type="password" name="password">
    </div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>
</body>
</html>
