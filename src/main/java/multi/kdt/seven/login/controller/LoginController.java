package multi.kdt.seven.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import multi.kdt.seven.login.dto.MemberDTO;
import multi.kdt.seven.login.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("memberservice")
	MemberService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)	
	public String loginresult(MemberDTO dto, Model model) {
		MemberDTO userdto = service.loginmember(dto);
		
		if(userdto == null) {
			model.addAttribute("msg", "������� �ʴ� ������Դϴ�.");
			return "login";
		}else {
			return "index";
		}
	}
}
