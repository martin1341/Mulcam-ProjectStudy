package multi.kdt.seven.board.dao;

import java.util.HashMap;
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

	public List<ArticleDTO> selectArticlePage(int pageNum, int articleNum) {
		Map<String, Object> page = new HashMap<String, Object>();
		page.put("pageNum", pageNum);
		page.put("articleNum", articleNum);
		return session.selectList("selectArticlePage", page);
	}

	public List<ArticleDTO> selectArticleSearchPage(String keyword, int pageNum, int articleNum) {
		Map<String, Object> search = new HashMap<String, Object>();
		search.put("keyword", keyword);
		search.put("pageNum", pageNum);
		search.put("articleNum", articleNum);
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

	public int deleteArticle(int articleId) {
		return session.delete("deleteArticle", articleId);
	}

	public List<ArticleDTO> selectRecommendArticle() {
		return session.selectList("selectRecommendArticle");
	}

	public int updateRecommends(int articleId) {
		return session.update("updateRecommends", articleId);
	}

	public int selectRecommends(int articleId, String memberId) {
		Map<String, Object> recommends = new HashMap<String, Object>();
		recommends.put("articleId", articleId);
		recommends.put("memberId", memberId);
		return session.selectOne("selectRecommends", recommends);
	}

	public int insertRecommends(int articleId, String memberId) {
		Map<String, Object> recommends = new HashMap<String, Object>();
		recommends.put("articleId", articleId);
		recommends.put("memberId", memberId);
		return session.insert("insertRecommends", recommends);
	}

}
