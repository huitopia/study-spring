<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
 var data = new HashMap<String, List>();
 접근
 --%>
<p>${myList.key1[0]}</p>
<p>${myList.key2[0]}</p>
<p>${myList.key2[1]}</p>
<p>${myList["key 삼"][0]}</p>
<p>${myList["key 삼"][1]}</p>
</body>
</html>
