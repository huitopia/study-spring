<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/main20/sub12">
    <input type="text" name="type">
    <br>
    <textarea name="content"></textarea>
    <br>
    <select name="city" id="">
        <option value="london"></option>
        <option value="seoul"></option>
        <option value="osaka"></option>
    </select>
    <br>
    <input type="submit">
</form>
<hr>
<form action="/main20/sub13">
    <%--    div>div*3>input:r[name=city]--%>
    <div>
        <div>
            <input type="radio" name="city" value="seoul" id="">
            seoul
        </div>
        <div>
            <input type="radio" name="city" value="london" id="">
            london
        </div>
        <div>
            <input type="radio" name="city" value="osaka" id="">
            osaka
        </div>
    </div>
    <input type="submit">
</form>
<hr>
<form action="/main20/sub14">
    <%--    div*3>input:c[name=foods]--%>
    <div>
        <input type="checkbox" name="foods" id="" value="pizza">
    </div>
    <div>
        <input type="checkbox" name="foods" id="" value="noodle">
    </div>
    <div>
        <input type="checkbox" name="foods" id="" value="pasta">
    </div>
    <input type="submit">
</form>
<hr>
<form action="/main20/sub15">
    <div>
        <select name="type" id="">
            <option value="football">football</option>
            <option value="baseball">baseball</option>
            <option value="basketball">basketball</option>
        </select>
    </div>
    <div>
        <div>
            <input type="radio" name="phone" id="" value="iphone">
            iphone
        </div>
        <div>
            <input type="radio" name="phone" id="" value="galaxy">
            galaxy
        </div>
    </div>
    <div>
        <div>
            <input type="checkbox" name="book" id="" value="java">
            java
        </div>
        <div>
            <input type="checkbox" name="book" id="" value="spring">
            spring
        </div>
        <div>
            <input type="checkbox" name="book" id="" value="react">
            react
        </div>
    </div>
    <input type="submit">
</form>
</body>
</html>
