<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>choose, when, otherwise</h3>
<%--  when 연산 결과가 false면 다음 when으로
그 안에서 true면 내부 출력물 반환
when 연산 전부 false면 otherwise 반환--%>
<c:choose>
    <c:when test="${age < 4}">
        <p>유아용 콘텐츠</p>
    </c:when>
    <c:when test="${age < 14}">
        <p>어린이용 콘텐츠</p>
    </c:when>
    <c:when test="${age < 20}">
        <p>청소년용 콘텐츠</p>
    </c:when>
    <c:otherwise>
        <p>성인용 콘텐츠</p>
    </c:otherwise>
</c:choose>
</body>
</html>
