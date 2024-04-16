<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CustomerName</h1>
<table>
    <c:forEach items="${nameList}" var="name" varStatus="status">
        <tr>
            <td>
                    ${status.count}
            </td>
            <td>
                    ${name}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
