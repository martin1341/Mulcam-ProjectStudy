window.onload = function(e){ 

	var loginbtn = document.getElementById('loginbtn');
	var id = document.getElementById('id');
	var pw = document.getElementById('pw');

	$("form").on('submit',function(e){
		if(id.value == "" || id.value == "아이디"){
			e.preventDefault();
			alert("아이디를 입력해주세요");
			
		}
		if(pw.value == "" || pw.value == "비밀번호"){
			e.preventDefault();
			alert("비밀번호를 입력해주세요");
		}
		if(id.value == "manager" || pw.value == "manager"){
			alert("로그인 되었습니다")
		}
		
	});
	

}