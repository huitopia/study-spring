<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        h3 {
            color: dodgerblue;
        }

        table {
            width: 700px;
            text-align: center;
        }

        table, tr, th, td {
            border: 1px solid gray;
            border-collapse: collapse;
        }

        th {
            background-color: lightsteelblue;
        }
    </style>
</head>
<body>
<h2>Create Employee</h2>
<form action="" method="post">
    <div>
        LastName
        <input type="text" name="lastName">
    </div>
    <div>
        FirstName
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
    <div>
        Notes
        <input type="text" name="notes">
    </div>
    <div>
        <button>Create</button>
    </div>
</form>

<c:if test="${not empty message}">
    <div>${message}</div>
    <h3>${message}</h3>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>LastName</th>
            <th>FirstName</th>
            <th>BirthDate</th>
            <th>Photo</th>
            <th>Notes</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.lastName}</td>
                <td>${employee.firstName}</td>
                <td>${employee.birthDate}</td>
                <td>${employee.photo}</td>
                <td>${employee.notes}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
