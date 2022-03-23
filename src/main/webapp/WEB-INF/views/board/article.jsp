<%@page import="multi.kdt.seven.board.dto.ArticleDTO"%>
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
<link href="<%=request.getContextPath()%>/resources/css/article.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/aritcle.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<article id="article">
		<div id="article-wrap">
			<h1 id="title">${ article.articleTitle }</h1>
			<img src="<%=request.getContextPath()%>${ article.articleImage }" width=600>
			<p id="content">
				<%pageContext.setAttribute("enter", "\r\n");%>
				${ fn:replace(article.articleContent, enter, "<br>") }
			</p>
		</div>
	</article>


	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>