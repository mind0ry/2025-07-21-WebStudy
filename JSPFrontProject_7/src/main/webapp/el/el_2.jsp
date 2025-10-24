<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	EL => 내장 객체
	
	EL => VO출력
 --%>
<%
	String name="홍길동";
	request.setAttribute("name","홍길동");
	session.setAttribute("name","심청이");
	// id 비교
	application.setAttribute("name","박문수");
	// 전체에서 공유
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  이름:${requestScope.name}<br>
  이름:${sessionScope.name}<br>
  이름:${applicationScope.name}<br> 
  
</body>
</html>