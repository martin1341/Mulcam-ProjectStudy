package multi.kdt.seven.board.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import multi.kdt.seven.board.dao.BoardDAO;
import multi.kdt.seven.board.dto.ArticleDTO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("BoardDAO")
	BoardDAO dao;

	@Override
	public List<ArticleDTO> articlePage(int pageNum, int articleNum) {
		return dao.selectArticlePage(pageNum, articleNum);
	}

	@Override
	public List<ArticleDTO> articleSearchPage(String keyword, int pageNum, int articleNum) {
		return dao.selectArticleSearchPage(keyword, pageNum, articleNum);
	}

	@Override
	public int writeArticle(ArticleDTO article, MultipartFile uploadImage, String uploadPath) {
		if (!uploadImage.isEmpty()) {
			// 파일 이름 가공
			String originalFileName = uploadImage.getOriginalFilename();
			int index = originalFileName.lastIndexOf(".");
			String fileName = originalFileName.substring(0, index);
			String ext = originalFileName.substring(index);
			String savedFileName = "/resources/upload/" + fileName + "_" + UUID.randomUUID().toString().substring(0, 8) + ext;

			// 파일 저장
			File saveFile = new File(uploadPath + savedFileName);
			try {
				uploadImage.transferTo(saveFile);
				article.setArticleImage(savedFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			article.setArticleImage("/resources/img/noimage.png");
		}
		dao.insertArticle(article);
		return article.getArticleId();
	}

	@Override
	public ArticleDTO getArticle(int articleId) {
		return dao.selectArticle(articleId);
	}

	@Override
	public int updateViews(int articleId) {
		return dao.updateViews(articleId);
	}

	@Override
	public int editArticle(ArticleDTO oldArticle, ArticleDTO newArticle, MultipartFile uploadImage, String uploadPath) {
		if (!uploadImage.isEmpty()) {
			// 기존 파일 삭제
			File oldFile = new File(uploadPath + oldArticle.getArticleImage());
			oldFile.delete();

			// 파일 이름 가공
			String originalFileName = uploadImage.getOriginalFilename();
			int index = originalFileName.lastIndexOf(".");
			String fileName = originalFileName.substring(0, index);
			String ext = originalFileName.substring(index);
			String savedFileName = "/resources/upload/" + fileName + "_" + UUID.randomUUID().toString().substring(0, 8) + ext;

			// 새 파일 저장
			File saveFile = new File(uploadPath + savedFileName);
			try {
				uploadImage.transferTo(saveFile);
				newArticle.setArticleImage(savedFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			newArticle.setArticleImage(oldArticle.getArticleImage());
		}
		newArticle.setArticleId(oldArticle.getArticleId());
		dao.editArticle(newArticle);
		return newArticle.getArticleId();
	}

	@Override
	public List<ArticleDTO> recommendArticle() {
		return dao.selectRecommendArticle();
	}

	@Override
	public int deleteArticle(int articleId) {
		return dao.deleteArticle(articleId);
	}

	@Override
	public boolean recommend(int articleId, String memberId) {
		if(dao.selectRecommends(articleId, memberId) == 0) {
			dao.insertRecommends(articleId, memberId);
			dao.updateRecommends(articleId);
			return true;
		} else {
			return false;
		}
	}
}
