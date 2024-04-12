<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    .nav {
        width: 100%;
        height: 50px;
        border: 1px solid black;
    }

    .nav a {
        line-height: 50px;
        font-size: 1.5rem;
    }

    .nav .active {
        background-color: gray;
    }
</style>
<div class="nav" style="display: flex; justify-content: space-around">
    <div class="${param.current eq 'iphone' ? 'active' : ''}">
        <a href="/main18/sub1">iphone</a>
    </div>
    <div class="${param.current eq 'mac' ? 'active' : ''}">
        <a href="/main18/sub2">mac</a>
    </div>
    <div class="${param.current eq 'macbook' ? 'active' : ''}">
        <a href="/main18/sub3">macbook</a>
    </div>
    <div>
        <a href="/main18/sub4">cart</a>
    </div>
</div>
