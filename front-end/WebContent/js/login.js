window.onload = function (e) {

	var member = {
		"admin": "1234",
		"first": "1111"
	};

	$("form").on('submit', function (e) {
		var isIdOk = false;
		var isPassOk = false;
		if ($("#id").val() == "") {
			e.preventDefault();
			isIdOk = false;
			$("#iderror").text("아이디를 입력해주세요.");

		} else {
			isIdOk = true;
			$("#iderror").text("");
		}

		if ($("#pw").val() == "") {
			e.preventDefault();
			isPassOk = false;
			$("#passerror").text("비밀번호를 입력해주세요.");
		} else {
			isPassOk = true;
			$("#passerror").text("");
		}

		if (isIdOk == true && isPassOk == true) {
			if (typeof member[$("#id").val()] == "undefined") {
				e.preventDefault();
				alert("등록되지 않은 아이디입니다.");
			} else if ($("#pw").val() != member[$("#id").val()]) {
				e.preventDefault();
				alert("잘못된 비밀번호입니다.");
			}
		}
	});
}