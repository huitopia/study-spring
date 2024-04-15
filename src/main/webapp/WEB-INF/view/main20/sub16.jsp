<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- method : 전송 방식 결정 --%>
<%-- get  : 주소에 쿼리스트링, 정보 노출, 길이 제한 --%>
<%-- body : 요청 메세지 바디, 정보 노출 없음, 길이 제한 없음 --%>
<form action="/main20/sub17" method="post">
    <div>
        아이디
        <input type="text" name="id">
    </div>
    <div>
        비밀번호
        <input type="password" name="password">
    </div>
    <div>
        자기소개
        <textarea name="desc" id="" cols="30" rows="10"></textarea>
    </div>
    <div>
        <input type="submit">
    </div>
</form>
<hr>
<form action="/main20/sub18" method="post">
    <div>
        name
        <input type="text" name="name">
    </div>
    <div>
        city
        <input type="text" name="city">
    </div>
    <div>
        address
        <br>
        <textarea name="address" id="" cols="30" rows="10"></textarea>
    </div>
    <div>
        <input type="submit">
    </div>
</form>
</body>
</html>
