<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 공통 상단 부분-->
<header id="menu">
	<div id="menu-wrap">
		<div id="menu-logo">
			<a href="/">어디갈까?</a>
		</div>
		<div id="quick">
			<ul>
				<li><a href="/board" onclick="board">모두의 추천</a></li>
			</ul>
		</div>
		<div id="member">
			<ul>
				<li><a href="/signup">회원가입</a></li>
				<li><a href="/login">로그인</a></li>
			</ul>
		</div>
	</div>
</header>