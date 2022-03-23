<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>어디갈까?</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<!-- CSS, JavaScript -->
<link href="<%=request.getContextPath()%>/resources/css/index.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/index.js"></script>
</head>
<body style="text-align: center">
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<br>
	<h1>공사 중</h1>
	<br>
	<input type="button" value="글쓰기" onclick="location.href='board/write'"><br>
	<br>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>