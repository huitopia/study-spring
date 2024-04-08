<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Attribute</title>
</head>
<body>
<h1>Map Example</h1>
<%-- attributeName["key"] --%>
<p>map : ${myMap["name"]}, ${myMap["age"]}, ${myMap["address"]}</p>
<%-- attributeName.key --%>
<ol>
    <li>name : ${myMap.name}</li>
    <li>age : ${myMap.age}</li>
    <li>address : ${myMap.address}</li>
</ol>
</body>
</html>
