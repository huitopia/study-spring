<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- scope=request 설정 후 navbar2 ${current} 사용 가능 --%>
<%--<c:set var="current1" value="sub3 val1" scope="page"/>--%>
<c:set var="current" value="sub3" scope="request"/>
<c:import url="navbar2.jsp"/>
<div>
    sub3 content
</div>
</body>
</html>
