package bean;

import java.util.Calendar;

public class Comment {
	private String commentId;
	private String articleId;
	private String memberId;
	private String contents;
	private int likes;
	private Calendar Dates;
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public Calendar getDates() {
		return Dates;
	}
	public void setDates(Calendar dates) {
		Dates = dates;
	}
}