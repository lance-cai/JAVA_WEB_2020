package com.lance.web_forum.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.lance.web_forum.bean.Article;
import com.lance.web_forum.dao.ArticleDao;
import com.lance.web_forum.dao.ArticleDaoImpl;

@WebServlet(name = "new-post", urlPatterns="/new-post")
public class NewPost extends HttpServlet {
	public ArticleDao dao = new ArticleDaoImpl();
	public Article article = new Article();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
			ServletException, IOException {
		String memberId = request.getParameter("user");
		article.setMemberId(memberId);
		doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
			ServletException, IOException {
		String title = request.getParameter("add-title-bar");
		String contents = request.getParameter("add-contents-bar");
		String tags = request.getParameter("add-tags-bar");
		
		
		article.setTitle(title);
		article.setContents(contents);
		dao.create(article);
		dao.queryWith("TITLE", title);
		
		request.getRequestDispatcher("/home.jsp").forward(request, response);
		
	}

}
