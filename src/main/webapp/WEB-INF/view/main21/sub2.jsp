<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main21/sub1" method="get">
    <input type="submit" value="">
</form>
<form action="/main21/sub1" method="post">
    <input type="submit" value="">
</form>

<hr>

<form action="/main21/sub3" method="get">
    <input type="submit" value="sub3 get">
</form>
<form action="/main21/sub3" method="post">
    <input type="submit" value="sub3 post">
</form>

<hr>

<form action="/main21/sub4" method="get">
    <input type="submit" value="sub4 get">
</form>
<form action="/main21/sub4" method="post">
    <input type="submit" value="sub4 post">
</form>

<hr>

<form action="/main21/sub5" method="get">
    <input type="submit" value="get 방식으로 sub5">
</form>
<form action="/main21/sub5" method="post">
    <input type="submit" value="post 방식으로 sub5">
</form>
</body>
</html>
