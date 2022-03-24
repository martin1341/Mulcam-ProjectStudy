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
<link href="<%=request.getContextPath()%>/resources/css/articleedit.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/articleedit.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<section id="articleedit">
		<div id="articleedit-wrap">
			<form action="edit" method="post" enctype="multipart/form-data">
				<input type="text" id="articleTitleForm" name="articleTitle" placeholder="제목을 입력해주세요." value="${ article.articleTitle }">
				<div id="articleImageUpload">대표 이미지 변경: <input type="file" id="articleImageForm" name="uploadImage"></div>
				<textarea id="articleContentForm" name="articleContent" placeholder="내용을 입력해주세요.">${ article.articleContent }</textarea>
				<input type="submit" id="editbtn" class="articleeditbtn" value="등록">
				<input type="button" id="cancelbtn" class="articleeditbtn" value="취소" onclick="location.href='/board'">
				<input type="hidden" name="id" value="${ param.id }">
			</form>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>