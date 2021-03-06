package multi.kdt.seven.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import multi.kdt.seven.signup.dto.SignupDTO;
import multi.kdt.seven.signup.service.SignupService;

@Controller
public class SignupController {
	
	@Autowired
	@Qualifier("signupservice")
	SignupService service;

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
  
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView insertresult(SignupDTO dto) {
//		System.out.println("폰넘버 확인"+dto.getPhone1());
		int result = service.insertmember(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("signupresult");
		return mv;
	}
}
