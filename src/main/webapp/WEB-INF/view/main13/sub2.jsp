<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>JSTL Url Tag</title>
</head>
<body>
<%-- url : 주소를 생성하고 저장할 수 있는 태그 --%>
<%-- https://search.naver.com/search.naver?query=bts&where=nexearch&sm=tab_hty.top --%>
<c:url value="https://search.naver.com/search.naver" var="naverUrl">
    <c:param name="query" value="bts"/>
    <c:param name="where" value="nexearch"/>
    <c:param name="sm" value="tab_hty.top"/>
</c:url>
<a href="https://www.naver.com">네이버</a>
<hr>
<a href="${naverUrl}">네이버</a>
<%-- https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&q=%EB%89%B4%EC%A7%84%EC%8A%A4 --%>
<c:url value="https://search.daum.net/search" var="daumUrl">
    <c:param name="w" value="tot"/>
    <c:param name="DA" value="YZR"/>
    <c:param name="t__nil_searchbox" value="btn"/>
    <c:param name="q" value="뉴진스"/>
</c:url>
<a href="${daumUrl}">다음</a>
</body>
</html>
