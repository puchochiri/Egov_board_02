<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 자바의표현식 -->
	<%= request.getAttribute("userNo")%>
	
	<br />
	testtest
	<!-- 스크립트  -->
	<div>${userid}</div>
	<div>main5</div>
	<div>${USER_ID}</div>

<div>
<%-- 	<%= request.getSession().getAttribute("USER_ID_YSW").toString() %> 닙이 로그인했습니다. --%>
	</div>

</body>
</html>