window.onload = function () {

	var member = ["admin", "first"];

	$("form").on("submit", function (e) {
		var isOk = true;

		if ($("#id").val() == "") {
			e.preventDefault();
			isOk = false;
			$("#idError").text("아이디를 입력해주세요.");
		} else if (!$("#id").val().match(/^[a-zA-Z0-9]{3,}$/)) {
			e.preventDefault();
			isOk = false;
			$("#idError").text("알파벳과 숫자의 조합으로 3자 이상 입력해주세요.");
		} else {
			$("#idError").text("");
			/*if (member.includes($("#id").val())) {
				e.preventDefault();
				isOk = false;
				$("#idError").text("이미 사용중인 아이디입니다.");
			}*/
		}

		if ($("#pw").val() == "") {
			e.preventDefault();
			isOk = false;
			$("#passwordError").text("비밀번호를 입력해주세요.");
		} else if (!$("#pw").val().match(/^.{4,10}$/)) {
			e.preventDefault();
			isOk = false;
			$("#passwordError").text("4자 이상 10자 이하로 입력해주세요.");
		} else {
			$("#passwordError").text("");
			if ($("#pwchk").val() == "") {
				e.preventDefault();
				isOk = false;
				$("#passwordCheckError").text("비밀번호를 다시 입력해주세요.");
			} else if ($("#pwchk").val() != $("#pw").val()) {
				e.preventDefault();
				isOk = false;
				$("#passwordCheckError").text("비밀번호가 같지 않습니다.");
			} else {
				$("#passwordCheckError").text("");
			}
		}

		if ($("#name").val() == "") {
			e.preventDefault();
			isOk = false;
			$("#nameError").text("이름을 입력해주세요.");
		} else if (!$("#name").val().match(/^[가-힣]{2,}$/)) {
			e.preventDefault();
			isOk = false;
			$("#nameError").text("한글로 2자 이상 입력해주세요.");
		} else {
			$("#nameError").text("");
		}

		if ($("#email").val() == "") {
			e.preventDefault();
			isOk = false;
			$("#emailError").text("이메일을 입력해주세요.");
		} else if (!$("#email").val().match(/^[a-zA-Z0-9+\-_.]+@[a-zA-Z0-9+\-_]+\.[a-zA-Z0-9.]+$/)) {
			e.preventDefault();
			isOk = false;
			$("#emailError").text("이메일 형식에 맞게 입력해주세요.");
		} else {
			$("#emailError").text("");
		}

		if ($("#phone1").val() == "" || $("#phone2").val() == "" || $("#phone3").val() == "") {
			e.preventDefault();
			isOk = false;
			$("#phoneError").text("휴대전화번호를 입력해주세요.");
		} else if (!$("#phone1").val().match(/^01[0-9]$/)) {
			e.preventDefault();
			isOk = false;
			$("#phoneError").text("휴대전화번호 형식에 맞게 입력해주세요.");
		} else if (!$("#phone2").val().match(/^[0-9]{3,4}$/)) {
			e.preventDefault();
			isOk = false;
			$("#phoneError").text("휴대전화번호 형식에 맞게 입력해주세요.");
		} else if (!$("#phone3").val().match(/^[0-9]{4}$/)) {
			e.preventDefault();
			isOk = false;
			$("#phoneError").text("휴대전화번호 형식에 맞게 입력해주세요.");
		} else {
			$("#phoneError").text("");
		}

		if ($("#area").val() == null) {
			e.preventDefault();
			isOk = false;
			$("#areaError").text("지역을 선택해주세요.");
		} else {
			$("#areaError").text("");
		}

		if ($("#gender").val() == null) {
			e.preventDefault();
			isOk = false;
			$("#genderError").text("성별을 선택해주세요.");
		} else {
			$("#genderError").text("");
		}

/*		if (isOk) {
			alert("회원가입이 완료되었습니다.");
		}*/
	});

	$("#phone1").on("input", function () {
		if ($(this).val().length == 3) {
			$("#phone2").focus();
		}
	});

	$("#phone2").on("input", function () {
		if ($(this).val().length == 4) {
			$("#phone3").focus();
		}
	});
}