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
<link href="<%=request.getContextPath()%>/resources/css/signupresult.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
    <div id=result><p>회원가입이 완료되었습니다.</p></div>
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>