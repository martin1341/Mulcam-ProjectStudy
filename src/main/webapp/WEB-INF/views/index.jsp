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
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<section id="banner">
		<div id="banner-wrap">
			<ul>
				<li><a href="/board/article?id=1"> <img src="resources/img/banner/busan3_800.jpg">
				</a></li>
				<li><a href="/board/article?id=5"> <img src="resources/img/banner/gyeongju_800.jpg">
				</a></li>
			</ul>
		</div>
	</section>

	<hr class="hr-article">

	<article id="today">
		<div id="today-wrap">
			<span id="today-title">오늘의 추천 여행</span>
			<ul>
				<c:forEach var="article" items="${ articles }">
					<li><a href="/board/article?id=${ article.articleId }">
							<div class="today-image">
								<img src="<%=request.getContextPath()%>${ article.articleImage }">
							</div>
							<div class="today-content">
								<span class="article-title">${ article.articleTitle }</span>
							</div>
					</a></li>
				</c:forEach>
			</ul>
		</div>
	</article>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>