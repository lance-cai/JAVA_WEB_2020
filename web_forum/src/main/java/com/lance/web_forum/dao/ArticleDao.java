package com.lance.web_forum.dao;

import java.util.List;

import com.lance.web_forum.bean.*;

public interface ArticleDao extends GenericBackendDao<Article> {
	public int editContents(String articelId, String editedContents);
	public int refreshLikesAndVisits(String articleId, int likes, int views);
	public List<Comment> getAllCommentsOn(String articleId);
	public Member getAuthorOf(String articleId);
	
}
