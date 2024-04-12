<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<style>
    .active {
        background-color: gold;
    }
</style>
<a class="${param.cur eq 'sub12' ? 'active' : ''}" href="/main15/sub12">
    <span>sub12</span>
</a>
<a class="${param.cur eq 'sub13' ? 'active' : ''}" href="/main15/sub13">
    <span>sub13</span>
</a>