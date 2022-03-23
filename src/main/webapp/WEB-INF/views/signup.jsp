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
<link href="<%=request.getContextPath()%>/resources/css/signup.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/signup.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

    <section class="wrap">
        <div class='title'>회원가입</div>
        <form action="signup" method="post">
            <div class="id">
                <label>아이디<br>
                    <input type="text" name="id" id="id" class="textform">
                </label>
                <div id="idError" class="error"></div>
            </div>
            <div class="password">
                <label>비밀번호<br>
                    <input type="password" name='pw' id="pw" class="textform">
                </label>
                <div id="passwordError" class="error"></div>
            </div>
            <div class="passwordCheck">
                <label>비밀번호 재확인<br>
                    <input type="password" name='pwchk' id="pwchk" class="textform">
                </label>
                <div id="passwordCheckError" class="error"></div>
            </div>
            <div class="name">
                <label>이름<br>
                    <input type="text" name="membername" id="name" class="textform">
                </label>
                <div id="nameError" class="error"></div>
            </div>
            <div class="email">
                <label>이메일<br>
                    <input type="text" name="email" id="email" class="textform">
                </label>
                <div id="emailError" class="error"></div>
            </div>
            <div class="phone">
                <label>휴대전화<br></label>
                <input id="phone1" type="text" class="phoneform" maxlength="3"><span class="phonedelimiter">-</span><input id="phone2"
                    type="text" class="phoneform" maxlength="4"><span class="phonedelimiter">-</span><input id="phone3" type="text"
                    class="phoneform" maxlength="4">
                <div id="phoneError" class="error"></div>
            </div>
            <div class="area">
                <label>지역<br>
                    <select id="area">
                        <option selected disabled>지역을 선택하세요</option>
                        <option value="서울">서울</option>
                        <option value="경기">경기</option>
                        <option value="경남">경남</option>
                        <option value="경북">경북</option>
                        <option value="강원">강원</option>
                        <option value="충남">충남</option>
                        <option value="충북">충북</option>
                        <option value="전북">전북</option>
                        <option value="전남">전남</option>
                        <option value="제주">제주</option>
                    </select>
                </label>
                <div id="areaError" class="error"></div>
            </div>
            <div class="gender">
                <label>성별<br>
                    <select id="gender">
                        <option selected disabled>성별을 선택하세요</option>
                        <option value="남성">남성</option>
                        <option value="여성">여성</option>
                        <option value="미응답">미응답</option>
                    </select>
                </label>
                <div id="genderError" class="error"></div>
            </div>
            <div class="signUp">
                <input type="submit" id="signUpButton" value="가입하기">
            </div>
        </form>
    </section>
    
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>