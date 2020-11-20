package com.lance.web_forum;

import java.io.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Hello world!
 *
 */
@WebServlet(name = "hello", urlPatterns="/hello")
public class Hello extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	out.println("Hello World!");
        
    }
}
