<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>

    </style>
</head>
<body>
<h3>New Customer Create</h3>
<form action="" method="post">
    <div>
        Name
        <input type="text" name="name">
    </div>
    <div>
        ContactName
        <input type="text" name="contactName">
    </div>
    <div>
        Address
        <input type="text" name="address">
    </div>
    <div>
        City
        <input type="text" name="city">
    </div>
    <div>
        PostalCode
        <input type="text" name="postalCode">
    </div>
    <div>
        Country
        <input type="text" name="country">
    </div>
    <%--    <input type="submit" value="Create">--%>
    <div>
        <button>Create</button>
    </div>
</form>
</body>
</html>
