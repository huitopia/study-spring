<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="/WEB-INF/fragment/navbar3.jsp">
    <c:param name="current" value="sub3"/>
</c:import>
<div>
    <form action="">
        <div>
            <input type="text" placeholder="Id" name="id">
        </div>
        <div>
            <button>Login</button>
        </div>
    </form>
</div>
</body>
</html>
