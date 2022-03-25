package multi.kdt.seven.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import multi.kdt.seven.board.dto.ArticleDTO;

@Repository("BoardDAO")
public class BoardDAO {

	@Autowired
	SqlSession session;

	public List<ArticleDTO> selectArticlePage(Map<String, Object> page) {
		return session.selectList("selectArticlePage", page);
	}

	public List<ArticleDTO> selectArticleSearchPage(Map<String, Object> search) {
		return session.selectList("selectArticleSearchPage", search);
	}

	public int insertArticle(ArticleDTO dto) {
		return session.insert("insertArticle", dto);
	};

	public ArticleDTO selectArticle(int articleId) {
		return session.selectOne("selectArticle", articleId);
	}

	public int updateViews(int articleId) {
		return session.update("updateViews", articleId);
	}
	
	public int editArticle(ArticleDTO dto) {
		return session.update("updateArticle", dto);
	}
	
	public List<ArticleDTO> selectRecommendArticle() {
		return session.selectList("selectRecommendArticle");
	}

}
