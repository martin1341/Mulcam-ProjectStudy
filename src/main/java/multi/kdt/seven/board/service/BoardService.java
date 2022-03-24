package multi.kdt.seven.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import multi.kdt.seven.board.dto.ArticleDTO;

public interface BoardService {
	
	public List<ArticleDTO> articlePage(int pageNum, int articleNum);
	
	public List<ArticleDTO> articleSearchPage(String keyword, int pageNum, int articleNum);
	
	public int writeArticle(ArticleDTO article, MultipartFile uploadImage, String uploadPath);
	
	public ArticleDTO getArticle(int articleId);
	
	public int updateViews(int articleId);
	
	public int editArticle(ArticleDTO oldArticle, ArticleDTO newArticle, MultipartFile uploadImage, String uploadPath);
	
}
