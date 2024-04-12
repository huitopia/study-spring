<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- el의 내장 객체 param: request parameter 를
key, value 쌍으로 저장한 Map--
<%-- http://localhost:8080/main15/sub9?name=hui&age=3&city=seoul&address=hong&model=what? --%>
<%-- ${param["name"]} --%>
<div>name: ${param.name}</div>
<div>age: ${param.age}</div>
<div>city: ${param.city}</div>
<div>address: ${param.address}</div>
<div>model: ${param.model}</div>
<hr>
<%-- /main15/sub9?title=title%20%EB%AD%90%20%ED%95%98%EC%A7%80&content=%EB%82%B4%EC%9A%A9%EC%9D%80%20%EB%AD%90%EA%B0%80%20%EC%A2%8B%EC%9D%84%EA%B9%8C&car=%EA%B3%A7%20%EB%B3%B4%ED%97%98%20%EB%A7%8C%EA%B8%B0%EC%9D%B8%EB%8D%B0 --%>
<div>title: ${param.title}</div>
<div>content: ${param.content}</div>
<div>car: ${param.car}</div>
<hr>
<%-- /main15/sub9?q=bts&song=ON&company=hive --%>
<div>q: ${param.q}</div>
<div>song: ${param.song}</div>
<div>company: ${param.company}</div>
</body>
</html>
