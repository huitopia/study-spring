<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="/WEB-INF/fragment/navbar5.jsp">
    <c:param name="current" value="mac"/>
</c:import>
<h3>mac</h3>
<p>mac desc</p>
<form action="">
    <input type="text" name="product" value="mac" readonly/>
    <input type="number" value="1" min="1" max="10" name="quantity"/>
    <button>Cart Add</button>
</form>
</body>
</html>
