package multi.kdt.seven.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public String loginresult(MemberDTO dto, Model model, HttpServletRequest request, HttpServletResponse response) {
		MemberDTO userdto = service.loginmember(dto);

		if(userdto == null) {
			model.addAttribute("msg", "일치하는 정보가 존재하지 않습니다.");
			return "login";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("session_id", userdto.getId());
			return "index";
		}
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)	
	public String logout(MemberDTO dto, Model model, HttpServletRequest request, HttpServletResponse response) {
		MemberDTO userdto = service.loginmember(dto);

		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return "logout";
		
		
	}
}
