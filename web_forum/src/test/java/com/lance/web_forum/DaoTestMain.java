package com.lance.web_forum;

import java.util.*;

import com.lance.web_forum.dao.*;
import com.lance.web_forum.bean.*;

public class DaoTestMain {

	public static void main(String[] args) {
		ArticleDao dao = new ArticleDaoImpl();
		Article article = new Article();
		article.setMemberId("0000000001");
		article.setTitle("Daosdlkjkl");
		article.setContents("Dsdflkl!");
//		article.setViews(12);
//		article.setLikes(32);
		
		
		
		// Test1
//		List<Article> result = dao.queryAll();
//		for (Article art : result) {
//			System.out.println(art.toString());
//		}
		
		//Test2
//		List<Article> result2 = dao.queryWith("MEMBER_ID", "0000000002");
//		for (Article art : result2) {
//			System.out.println(art.toString());
//		}
		 
		//Test3
//		System.out.println("successful delete: " + dao.delete(article));
		
		//Test4
		System.out.println("successful create: " + dao.create(article));
		
//		//Test5
//		article.setContents("Edited Contens");
//		System.out.println("successful update: " + dao.update(article));
		
		
		//Test6

//		System.out.println("successful update: " + dao.editContents("0293847906", "dfgsdfgsdftkmy]]][!"));
//
//		System.out.println("successful update: " + dao.refreshLikesAndVisits("0293847903", 10002, 990298));

	}

}
