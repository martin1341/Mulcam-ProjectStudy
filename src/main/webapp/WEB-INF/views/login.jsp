<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>어디갈까?</title>
<%@ include file="include/head.jsp"%>
<!-- CSS, JavaScript -->
<link href="<%=request.getContextPath()%>/resources/css/login.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/login.js"></script>
</head>
<body>
	<%@ include file="include/header.jsp"%>

	<div id="login">
		<p id=title>로그인</p>
		<form action="index.html" method="post">
			<input type=text id=id class=textform name=id placeholder='아이디'><br>
			<div id="iderror" class="errormessage"></div>
			<input type=password id=pw class=textform name=pw placeholder='비밀번호'><br>
			<div id="passerror" class="errormessage"></div>
			<input type="submit" id=loginbtn name=submit value="로그인">
		</form>
	</div>

	<%@ include file="include/footer.jsp"%>
</body>
</html>