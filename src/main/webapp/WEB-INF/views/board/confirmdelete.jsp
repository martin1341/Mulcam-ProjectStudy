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
<link href="<%=request.getContextPath()%>/resources/css/nopermission.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
    <div id="result"><p>삭제한 글은 복구할 수 없습니다<br>정말 삭제하시겠습니까?</p></div>
    <div id="button">
	    <form action="/board/delete" method="post">
	    	<input type="button" class="btn" id="prevbtn" value="취소" onclick="location.href='/${ returnURI }'"><input type="submit" class="btn" id="confirmbtn" value="삭제">
	    	<input type="hidden" name="id" value="${ id }">
	    </form>
    </div>
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>