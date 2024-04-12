<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    .active {
        background-color: darkgrey;
    }

    .nav {
        border: 1px solid blue;
        width: 100%;
        height: 70px;
        font-size: 2rem;
        text-indent: 20px;
        line-height: 70px;
    }
</style>
<div class="nav">
    <a href="/main15/sub5">
        <span class="${current eq 'sub5' ? 'active' : ''} ">sub5</span>
    </a>
    <a href="/main15/sub6">
        <span class="${current eq 'sub6' ? 'active' : ''}">sub6</span>
    </a>
</div>
