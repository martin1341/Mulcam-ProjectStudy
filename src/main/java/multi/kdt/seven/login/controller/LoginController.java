package multi.kdt.seven.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import multi.kdt.seven.login.dto.MemberDTO;
import multi.kdt.seven.login.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("memberservice")
	MemberService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String returnURI = request.getParameter("returnURI");
		mv.addObject("returnURI", returnURI);
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginresult(MemberDTO dto, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		MemberDTO userdto = service.loginmember(dto);
		String returnURI = (String) request.getParameter("returnURI");
		if (userdto == null) {
			mv.addObject("msg", "일치하는 정보가 존재하지 않습니다.");
			if (!returnURI.equals("")) {
				mv.addObject("returnURI", returnURI);
			}
			mv.setViewName("login");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("session_id", userdto.getId());
			if (returnURI.equals("")) {
				mv.setViewName("redirect:/");
			} else {
				mv.setViewName("redirect:" + returnURI);
			}
		}

		return mv;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(MemberDTO dto, Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "logout";

	}
}
