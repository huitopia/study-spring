<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- spring security tag --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>path4 jsp</h3>

<div>all</div>

<sec:authorize access="isAuthenticated()">
    <div>login</div>
</sec:authorize>

<sec:authorize access="not isAuthenticated()">
    <div>guest</div>
</sec:authorize>

<sec:authorize access="hasAnyAuthority('admin')">
    <div>admin</div>
</sec:authorize>
</body>
</html>
