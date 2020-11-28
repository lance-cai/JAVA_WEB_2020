package com.lance.web_forum.dao;

import com.lance.web_forum.bean.*;

public interface CommentDao extends GenericBackendDao<Comment> {
	public int editContents(String commentId, String editedContents);
}
