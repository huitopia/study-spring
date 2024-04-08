<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JavaBean</title>
</head>
<body>
<h1>java Bean Example</h1>
<%-- attributeName.propertyName--%>
<p>${person.name}</p>
<%-- attributeName.["propertyName"]--%>
<p>${person["age"]}</p>
</body>
</html>
