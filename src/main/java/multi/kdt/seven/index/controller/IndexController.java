package multi.kdt.seven.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import multi.kdt.seven.board.service.BoardService;

@Controller
public class IndexController {

	@Autowired
	@Qualifier("BoardService")
	BoardService service;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("articles", service.recommendArticle());
		mv.setViewName("index");
		return mv;
	}

}
