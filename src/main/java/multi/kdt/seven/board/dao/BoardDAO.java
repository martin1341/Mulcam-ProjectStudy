package multi.kdt.seven.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import multi.kdt.seven.board.dto.ArticleDTO;

@Repository("BoardDAO")
public class BoardDAO {

	@Autowired
	SqlSession session;
	
	public List<ArticleDTO> selectAllArticle() {
		return session.selectList("selectAllArticle");
	};

	public int insertArticle(ArticleDTO dto) {
		return session.insert("insertArticle", dto);
	};

	public ArticleDTO selectArticle(int articleId) {
		return session.selectOne("selectArticle", articleId);
	}
	
}
