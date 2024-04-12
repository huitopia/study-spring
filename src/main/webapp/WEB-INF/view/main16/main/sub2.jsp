<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>sub2 body 영역</div>
<h3>절대경로</h3>
<c:import url="/WEB-INF/fragment/navbar2.jsp"></c:import>
<c:import url="/WEB-INF/fragment/footer2.jsp"></c:import>
<h3>상대경로</h3>
<c:import url="../../../fragment/navbar2.jsp"></c:import>
<c:import url="../../../fragment/footer2.jsp"></c:import>
</body>
</html>
