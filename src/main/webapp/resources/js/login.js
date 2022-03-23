window.onload = function () {
	
	var member = {
		"admin": "1234",
		"first": "1111"
	};

	$("form").on('submit', function (e) {
		var isOk = true;

		if ($("#id").val() == "") {
			e.preventDefault();
			isOk = false;
			$("#iderror").text("아이디를 입력해주세요.");

		} else {
			$("#iderror").text("");
		}

		if ($("#pw").val() == "") {
			e.preventDefault();
			isOk = false;
			$("#passerror").text("비밀번호를 입력해주세요.");
		} else {
			$("#passerror").text("");
		}

/*		alert($("#pw").val() + "," + member[$("#id").val()]);
		if (isOk) {
			if (typeof member[$("#id").val()] == "undefined") {
				e.preventDefault();
				alert("등록되지 않은 아이디입니다.");
			} else if ($("#pw").val() != member[$("#id").val()]) {
				e.preventDefault();
				alert("잘못된 비밀번호입니다.");
			}
		}*/
	});
}