<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 파일 경로가 / 로 시작하지 않으면 상대경로(현재경로 기준) --%>
<h3>상대경로</h3>
<div>
    <c:import url="navbar1.jsp"/>
    <c:import url="../../fragment/footer1.jsp"/>
</div>
<%-- 파일 경로가 / 로 시작하면 절대 경로 webapp 폴더 기준 --%>
<h3>절대경로</h3>
<div>
    <c:import url="/WEB-INF/view/main16/navbar1.jsp"/>
    <c:import url="/WEB-INF/fragment/footer1.jsp"/>
</div>
</body>
</html>
