<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>어디갈까?</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<!-- CSS, JavaScript -->
<link href="<%=request.getContextPath()%>/resources/css/articlelist.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<article id="articlelist">
		<div id="articlelist-wrap">
			<span id="articlelist-title">모두의 추천 여행</span>
			<ul>
				<c:forEach var="article" items="${ articles }">
					<li><a href="/board/article?id=${ article.articleId }">
							<div class="article-image">
								<img src="<%=request.getContextPath()%>${ article.articleImage }">
							</div>
							<div class="article-content">
								<span class="article-title">${ article.articleTitle }</span><br>
								<span class="article-author">${ article.articleAuthor }</span><br>
								<span class="article-info">조회 ${ article.articleViews } 추천 ${ article.articleRecommends }</span><span class="article-date">${ fn:substring(article.articleDate, 0, 10) }</span>
							</div>
					</a></li>
				</c:forEach>
			</ul>
		</div>
	</article>

	<section id="boardbar">
		<input type="button" id="listbtn" class="boardbarbtn" value="최신글" onclick="location.href='/board'">
		<input type="button" id="writebtn" class="boardbarbtn" value="글쓰기" onclick="location.href='/board/write'">
		<div id="paginator"></div>
		<form action="/board">
			<input type="text" id="searchform" name="q" value="${ param.search }" placeholder="제목으로 검색"><input type="submit" id="searchbtn" class="boardbarbtn" value="검색">
		</form>
	</section>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>