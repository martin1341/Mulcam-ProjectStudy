$(function() {
	$("#articleTitleForm").on("input", function() {
		if ($(this).val().length > 50) {
			alert("제목은 50자까지 입력 가능합니다.");
			$(this).val($(this).val().substring(0, 50));
		}
	});

	$("#articleContentForm").on("input", function() {
		if ($(this).val().length > 65535) {
			alert("내용은 65535자까지 입력 가능합니다.");
			$(this).val($(this).val().substring(0, 65535));
		}
	});
});