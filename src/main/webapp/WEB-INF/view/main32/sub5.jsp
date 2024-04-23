<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>직원 등록</h3>
<div>${message}</div>
<form action="" method="post">
    <div>
        lastName
        <input type="text" name="lastName">
    </div>
    <div>
        firstName
        <input type="text" name="firstName">
    </div>
    <div>
        BirthDate
        <input type="text" name="birthDate">
    </div>
    <div>
        Photo
        <input type="text" name="photo">
    </div>
    <div>Notes
        <textarea name="notes" id="" cols="30" rows="10"></textarea>
    </div>
    <div>
        <button>Create</button>
    </div>
</form>
</body>
</html>
