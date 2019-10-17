package cn.boss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boss.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String loginUsername = request.getParameter("loginUsername");
		String loginPassword = request.getParameter("loginPassword");
		String[] ch = request.getParameterValues("ch");
		LoginServiceImpl lsi = new LoginServiceImpl();
		String loginUname = lsi.login(loginUsername, loginPassword);
		if (loginUname != null) {
			Cookie c1 = new Cookie("loginUsername",loginUsername);
   			c1.setMaxAge(60*60*24*7);
   			response.addCookie(c1);
   			if(ch != null){
   				for(String c : ch){
	   				if(c.equals("pwd")){
	   					Cookie c2 = new Cookie("loginPassword",loginPassword);
	   					Cookie c3 = new Cookie("choose","checked");
	   					c2.setMaxAge(60*60*24*7);
	   					response.addCookie(c2);
	   				}
   				}
   			}
			request.getSession().setAttribute("loginUname", loginUname);
			request.getSession().setAttribute("loginPwd", loginPassword);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
