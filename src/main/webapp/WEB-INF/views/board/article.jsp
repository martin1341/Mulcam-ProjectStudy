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
<link href="<%=request.getContextPath()%>/resources/css/board/article.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function() {
		$("#recommendbtn").on("click", function() {
			$.ajax({
				url : "/board/recommend",
				data : {
					articleId : "${ article.articleId }",
					memberId : "${ sessionScope.session_id }"
				},
				type : "POST",
				dataType : "JSON",
				success : function(ajax) {
					if (ajax.result == "true") {
						location.reload();
					} else if (ajax.result == "login") {
						alert("추천하려면 로그인해야합니다.");
					} else {
						alert("추천은 한 번만 가능합니다.");
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<article id="article">
		<div id="article-wrap">
			<h1 id="title">${ article.articleTitle }</h1>
			<div id="article-info">
				<span>작성자 ${ article.articleAuthor } 조회 ${ article.articleViews }</span><br> <span>작성일 ${ article.articleDate }</span><br>
			</div>
			<img src="<%=request.getContextPath()%>${ article.articleImage }" width=600>
			<p id="content">
				<%
				pageContext.setAttribute("enter", "\r\n");
				%>
				${ fn:replace(article.articleContent, enter, "<br>") }
			</p>
			<div id="recommend">
				<input type="button" id="recommendbtn" class="articlebarbtn" value="추천 ${ article.articleRecommends }">
			</div>
		</div>
	</article>

	<section id="articlebar">
		<input type="button" id="listbtn" class="articlebarbtn" value="최신글" onclick="location.href='/board'"> <input type="button" id="deletebtn"
			class="articlebarbtn" value="삭제" onclick="location.href='/board/delete?id=${ article.articleId }'"> <input type="button" id="editbtn"
			class="articlebarbtn" value="수정" onclick="location.href='/board/edit?id=${ article.articleId }'">
	</section>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>