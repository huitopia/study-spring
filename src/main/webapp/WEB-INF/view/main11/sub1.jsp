<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expression Language</title>
</head>
<body>
<p>Expression Language</p>
<p>간단한 연산 사용 가능</p>
<p>산술 연산, 논리 연산, 비교 연산, 삼항연산</p>
<h3>산술연산 +, -, *, /</h3>
<%-- 8, 4, 24, 3.0 --%>
<p>5 + 3 = ${5 + 3}</p>
<p>7 - 3 = ${7 - 3}</p>
<p>8 * 3 = ${8 * 3}</p>
<p>6 / 2 = ${6 / 2}</p>
<%-- 3.5, 1, 3 --%>
<p>7 div 2 = ${7 div 2}</p>
<p>7 % 2} = ${7 % 2}</p>
<p>15 mod 4 = ${15 mod 4}</p>
<%-- 문자열 사용 가능 / 7--%>
<p>${"3" + "4"}</p>
<%-- model Example --%>
<p>${num1} + ${num2} = ${num1 + num2}</p>
<h3>비교 연산 >, <, >=, <=, =</h3>
<%-- true, false, true, false, false --%>
<p>5 > 3 = ${5 > 3}</p>
<p>5 < 3 = ${5 < 3}</p>
<p>5 >= 3 = ${5 >= 3}</p>
<p>5 <= 3 = ${5 <= 3}</p>
<p>5 == 3 = ${5 == 3}</p>
<hr>
<p>5 gt 3 = ${5 gt 3}</p>
<p>5 lt 3 = ${5 lt 3}</p>
<p>5 ge 3 = ${5 ge 3}</p>
<p>5 le 3 = ${5 le 3}</p>
<p>5 eq 3 = ${5 eq 3}</p>
<hr>
<%-- true, false --%>
<p>"hello" < "spring" = ${"hello" < "spring"}</p>
<p>"hello" < "Spring" = ${"hello" < "Spring"}</p>
<p>"11" < "2" = ${"11" < "2"}</p>
<%-- 비교 연산 시 연산 대상 중 하나가 숫자이면 숫자로 변경 후 연산한다. --%>
<p>11 < 2 = ${11 < 2}</p>
<p>"11" < 2 = ${"11" < 2}</p>
<p>11 < "2" = ${11 < "2"}</p>
<h3>논리 연산 &&, ||</h3>
<h4>&& and</h4>
<p>true && true = ${true && true}</p>
<p>true && false = ${true && false}</p>
<p>false and true = ${false and true}</p>
<p>false and false = ${false and false}</p>
<h4>|| or</h4>
<p>true || true = ${true || true}</p>
<p>true || false = ${true || false}</p>
<p>false || true = ${false || true}</p>
<p>false || false = ${false || false}</p>
<h3>삼항연산</h3>
<p>true ? "hello" : "world" = ${true ? "hello" : "world"}</p>
<p>false ? "hello" : "wolrd" = ${false ? "hello" : "wolrd"}</p>
<p>age ge 20 ? "투표가능" : "투표불가" = ${age ge 20 ? "투표가능" : "투표불가"}</p>
<%-- 문자와 숫자 비교시 숫자로 변경됨 --%>
<p>age2 ge 20 ? "투표가능" : "투표불가" = ${age2 ge 20 ? "투표가능" : "투표불가"}</p>
<hr>
<h3>수량 * 가격</h3>
<p>${quantity * price}</p>
</body>
</html>
