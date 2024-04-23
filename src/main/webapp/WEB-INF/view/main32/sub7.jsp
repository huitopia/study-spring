<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>고객 조회 후 수정</h3>
<c:if test="${not empty message}">
    <div>${message}</div>
</c:if>
<form action="/main32/sub7">
    <div>
        no
        <input type="text" name="id">
    </div>
    <button>search</button>
</form>
<hr>
<c:if test="${empty customer}">
    조회된 고객이 없습니다.
</c:if>
<c:if test="${not empty customer}">
    <form action="/main32/sub7/update" method="post">
        <div>
            name
            <input type="text" name="name" value="${customer.name}">
        </div>
        <div>
            contactName
            <input type="text" name="contactName" value="${customer.contactName}">
        </div>
        <div>
            address
            <input type="text" name="address" value="${customer.address}">
        </div>
        <div>
            city
            <input type="text" name="city" value="${customer.city}">
        </div>
        <div>
            postalCode
            <input type="text" name="postalCode" value="${customer.postalCode}">
        </div>
        <div>
            country
            <input type="text" name="country" value="${customer.country}">
        </div>
        <div>
            <input type="hidden" name="id" value="${customer.id}">
        </div>
        <button>update</button>
    </form>
</c:if>
</body>
</html>
