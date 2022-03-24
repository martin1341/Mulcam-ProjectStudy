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
	public ModelAndView board(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int page = 1;
		int show = 9;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (request.getParameter("show") != null) {
			show = Integer.parseInt(request.getParameter("show"));
		}

		if (request.getParameter("search") != null) {
			String keyword = (String) request.getParameter("search");
			mv.addObject("articles", service.articleSearchPage(keyword, show * (page - 1), show));
		} else {
			mv.addObject("articles", service.articlePage(show * (page - 1), show));
		}
		mv.setViewName("board/articlelist");
		return mv;
	}

	@GetMapping("/board/write")
	public ModelAndView articleWrite(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String session_id = (String) request.getSession().getAttribute("session_id");
		if(session_id != null) {
			mv.setViewName("board/articlewrite");
		} else {
			mv.addObject("returnURL", "board/write");
			mv.setViewName("redirect:/login");
		}
		
		return mv;
	}

	@PostMapping("/board/write")
	public ModelAndView articleWriteResult(HttpServletRequest request, ArticleDTO article, @RequestParam("uploadImage") MultipartFile uploadImage) {
		ModelAndView mv = new ModelAndView();
		String uploadPath = request.getSession().getServletContext().getRealPath("/resources/upload/");
		mv.addObject("id", service.writeArticle(article, uploadImage, uploadPath));
		mv.setViewName("redirect:/board/article");
		return mv;
	}

	@GetMapping("/board/article")
	public ModelAndView articleRead(HttpServletRequest request) {
		int articleId = 1;
		if (request.getParameter("id") != null) {
			articleId = Integer.parseInt(request.getParameter("id"));
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("article", service.getArticle(articleId));
		mv.setViewName("board/article");
		return mv;
	}

}
