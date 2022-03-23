package multi.kdt.seven.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
	public List<ArticleDTO> articleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int writeArticle(ArticleDTO dto, MultipartFile uploadImage, HttpServletRequest request) {
		// 테스트용. 추후 로그인 연동시 실제 사용자 아이디 사용
		dto.setArticleAuthor("test");

		if (!uploadImage.isEmpty()) {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/");

			// 파일 저장 후 경로 저장
			String originFileName = uploadImage.getOriginalFilename();
			int index = originFileName.lastIndexOf(".");
			String fileName = originFileName.substring(0, index);
			String ext = originFileName.substring(index);
			String savedFileName = fileName + "_" + UUID.randomUUID().toString().substring(0, 8) + ext;

			File saveFile = new File(path + savedFileName);
			try {
				uploadImage.transferTo(saveFile);
				dto.setArticleImage("/resources/upload/" + savedFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dao.insertArticle(dto);
		return dto.getArticleId();
	}

	@Override
	public ArticleDTO getArticle(int articleId) {
		return dao.selectArticle(articleId);
	}
	
	

}
