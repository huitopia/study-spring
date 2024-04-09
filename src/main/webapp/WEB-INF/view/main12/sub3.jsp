<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>반복문</title>
</head>
<body>
<c:forEach begin="1" end="3">
    <p>반복 출력 할 코드</p>
</c:forEach>
<hr>
<c:forEach begin="0" end="7" var="num">
    <p>${num}</p>
</c:forEach>
<hr>
<h3>구구단 ${dan}단</h3>
<c:forEach begin="1" end="9" var="num">
    <p>${dan} * ${10-num} = ${dan * (10-num)}</p>
</c:forEach>
</body>
</html>
