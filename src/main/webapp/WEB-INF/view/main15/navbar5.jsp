<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="attr1" value="page value2" scope="page"/>
<div>
    <%-- page value2 --%>
    <div>${pageScope.attr1}</div>
    <%-- request value1 --%>
    <div>${requestScope.attr1}</div>
</div>
