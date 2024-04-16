<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="background-color: cornflowerblue">
            ${message}
    </div>
</c:if>
<%-- h1>lorem3^p>lorem --%>
<h1>Lorem ipsum dolor.</h1>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus, accusantium adipisci alias debitis deserunt
    dicta, dolorum eligendi facere hic illum laboriosam officiis placeat porro praesentium quis saepe sequi, unde
    voluptatibus.
</p>
</body>
</html>
