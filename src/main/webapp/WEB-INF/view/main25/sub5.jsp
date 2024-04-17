<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        table {
            width: 80%;
            text-align: center;
        }

        thead {
            background-color: darkgray;

        }
    </style>
</head>
<body>
<h3>상품 조회</h3>
<form action="">
    <input type="text" name="search" placeholder="상품명 입력" value="${param.search}">
    <%-- form 내의 button 요소는 submit 역할 --%>
    <button>search</button>
</form>
<c:if test="${empty products}" var="emptyProducts">
    조회된 상품이 없습니다.
</c:if>
<c:if test="${not emptyProducts}">
    <table>
        <thead>
        <tr>
            <th>No</th>
            <th>ProductID</th>
            <th>Name</th>
            <th>SupplierID</th>
            <th>CategoryID</th>
            <th>Unit</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.supplierId}</td>
                <td>${product.categoryId}</td>
                <td>${product.unit}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
