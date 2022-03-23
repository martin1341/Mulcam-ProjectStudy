package multi.kdt.seven.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import multi.kdt.seven.board.dto.ArticleDTO;
import multi.kdt.seven.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("BoardService")
	BoardService service;

	@GetMapping("/board")
	public String board() {
		return "board/articlelist";
	}

	@GetMapping("/board/write")
	public String articleWrite() {
		return "board/articlewrite";
	}

	@PostMapping("/board/write")
	public ModelAndView articleWriteResult(ArticleDTO dto, @RequestParam("uploadImage") MultipartFile uploadImage, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", service.writeArticle(dto, uploadImage, request));
		mv.setViewName("redirect:/board/article");
		return mv;
	}
	
	@GetMapping("/board/article")
	public ModelAndView articleRead(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("article", service.getArticle(id));
		mv.setViewName("board/article");
		return mv;
	}

}
