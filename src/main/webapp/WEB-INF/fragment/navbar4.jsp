<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    .active {
        background-color: gray;
    }
</style>
<div>
    <div>
        <a class="${param.current eq 'sub6' ? 'active' : ''}" href="/main17/sub6">sub6</a>
        <a class="${param.current eq 'sub7' ? 'active' : ''}" href="/main17/sub7">sub7</a>
        <a class="${param.current eq 'sub8' ? 'active' : ''}" href="/main17/sub8">sub8</a>
    </div>
    <div>
        <c:if test="${not empty sessionScope.testId}" var="loggedIn">
            ${sessionScope.testId}
            <a href="/main17/sub9">logout</a>
        </c:if>
        <c:if test="${not loggedIn}">
            guest
        </c:if>
        님 안녕하세요
    </div>
</div>
