package multi.kdt.seven.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import multi.kdt.seven.board.dto.ArticleDTO;

public interface BoardService {
	
	public List<ArticleDTO> articleList();
	
	public int writeArticle(ArticleDTO dto, MultipartFile uploadImage, HttpServletRequest request);
	
	public ArticleDTO getArticle(int articleId);
	
}
