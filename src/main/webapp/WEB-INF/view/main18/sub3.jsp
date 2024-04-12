<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="/WEB-INF/fragment/navbar5.jsp">
    <c:param name="current" value="macbook"/>
</c:import>
<h3>macbook</h3>
<p>macbook desc</p>
<form action="">
    <input type="text" name="product" value="macbook" readonly/>
    <input type="number" value="1" min="1" max="10" name="quantity"/>
    <button>Cart Add</button>
</form>
</body>
</html>
