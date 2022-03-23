package multi.kdt.seven.board.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticleDTO {

	int articleId;
	String articleTitle;
	String articleAuthor;
	String articleContent;
	String articleImage;
	String articleDate;
	int articleViews;
	int articleRecommends;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleAuthor() {
		return articleAuthor;
	}

	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleImage() {
		return articleImage;
	}

	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}

	public String getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(Timestamp articleDate) {
		this.articleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(articleDate.getTime()));
	}

	public int getArticleViews() {
		return articleViews;
	}

	public void setArticleViews(int articleViews) {
		this.articleViews = articleViews;
	}

	public int getArticleRecommends() {
		return articleRecommends;
	}

	public void setArticleRecommends(int articleRecommends) {
		this.articleRecommends = articleRecommends;
	}

}
