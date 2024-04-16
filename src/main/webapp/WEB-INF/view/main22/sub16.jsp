<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="background-color: pink; font-size: 1.5rem">
            ${message}
    </div>
</c:if>
<form action="/main22/sub17" method="post">
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
