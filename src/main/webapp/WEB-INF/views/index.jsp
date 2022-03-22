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
				<li><a href="subpage3.html"> <img src="resources/img/800_450/busan3_800.jpg">
				</a></li>
				<li><a href="subpage5.html"> <img src="resources/img/800_450/gyeongju_800.jpg">
				</a></li>
			</ul>
		</div>
	</section>

	<hr class="hr-article">

	<article id="today">
		<div id="today-wrap">
			<span>오늘의 추천 여행</span>
			<ul>
				<li><a href="subpage1.html">
						<div class="today-image">
							<img src="resources/img/260_200/busan1_260.jpg">
						</div>
						<div class="today-content">
							<p>부산 해운대</p>
							<p>부산의 상징, 해운대 해수욕장!</p>
						</div>
				</a></li>
				<li><a href="subpage2.html">
						<div class="today-image">
							<img src="resources/img/260_200/busan2_260.jpg">
						</div>
						<div class="today-content">
							<p>부산 감천 문화마을</p>
							<p>부산 원도심의 대표적인 랜드마크</p>
						</div>
				</a></li>
				<li><a href="subpage7.html">
						<div class="today-image">
							<img src="resources/img/260_200/jeju_260.jpg">
						</div>
						<div class="today-content">
							<p>제주도 함덕해수욕장</p>
							<p>예쁜 바다 산책로도 함께 즐기는 작고 아담한 해수욕장</p>
						</div>
				</a></li>
				<li><a href="subpage4.html">
						<div class="today-image">
							<img src="resources/img/260_200/geoje_260.jpg">
						</div>
						<div class="today-content">
							<p>거제도</p>
							<p>대한민국에서 2번째로 큰 섬</p>
						</div>
				</a></li>
				<li><a href="subpage5.html">
						<div class="today-image">
							<img src="resources/img/260_200/gyeongju_260.jpg">
						</div>
						<div class="today-content">
							<p>경주 동궁과 월지</p>
							<p>안압지로 불려지던 동궁과 월지</p>
						</div>
				</a></li>
				<li><a href="subpage6.html">
						<div class="today-image">
							<img src="resources/img/260_200/yeosu_260.jpg">
						</div>
						<div class="today-content">
							<p>여수</p>
							<p>여수 밤바다의 그곳</p>
						</div>
				</a></li>
			</ul>
		</div>
	</article>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>