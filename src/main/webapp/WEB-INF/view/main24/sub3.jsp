<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Customer Country List</h2>
<ol>
    <c:forEach items="${countries}" var="country" varStatus="status">
        <li>${country}</li>
    </c:forEach>
</ol>
</body>
</html>
