package cc.openhome.controller;

import java.lang.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Comment;
@WebServlet(
	name="reply",
	urlPatterns="/reply"
)
public class Reply extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
			// 取得表單內容 getParameter << contents
			// 儲存到 String 裡
			String contents = req.getParameter("replybar");
			// 取得文章 id
			System.out.println(contents);

			// 建立並初始化 Comment 物件
			Comment comment = new Comment();
			
			// auto increment in DB
			comment.setCommentId("This is a sample comment id.");
			comment.setArticleId("This is a sample article id.");
			comment.setMemberId("This is a sample member id");
			comment.setContents(contents);
			// default 0 in DB
			comment.setLikes(0);
			// default current datetime in DB
			comment.setDates(Calendar.getInstance());
			


			// 傳給負責操作後台 DAO << TABLE 名稱, Comment comment
			Path outfile = Paths.get("../test/db_comment.csv").toAbsolutePath();
			Charset cs = Charset.defaultCharset();
			List<String> data = new ArrayList<String>();
			data.add(comment.getCommentId());
			data.add(comment.getArticleId());
			data.add(comment.getMemberId());
			data.add(comment.getContents());
			data.add(String.valueOf(comment.getLikes()));
			// 轉換日期到標準格式的方式
			data.add(comment.getDates().toString());

			for (String line: data) {
				System.out.println(line);
			}


			BufferedWriter out = Files.newBufferedWriter(outfile, cs, 
				StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			
			// data.stream().forEach(s -> {
			// 	try {
			// 		out.write(s+",", 0, s.length());
			// 	} catch (IOException e) {
			// 		e.printStackTrace();
			// 	}
			// });

			for (String line: data) {
				try {
					out.write(line+",", 0, line.length());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
	}
}