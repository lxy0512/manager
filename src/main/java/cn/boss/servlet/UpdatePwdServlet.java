package cn.boss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boss.service.impl.ChangeServiceImpl;
import com.alibaba.fastjson.JSONObject;

public class UpdatePwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String loginUsername = request.getParameter("loginUsername");
		String loginPassword = request.getParameter("loginPassword");
		String loginPassword1 = request.getParameter("loginPassword1");
		if(loginPassword.equals(loginPassword1)){
			ChangeServiceImpl csi = new ChangeServiceImpl();
			int unamepws = csi.changePwd(loginPassword,loginUsername);
			System.out.println(unamepws);
			if(unamepws==1){
				response.sendRedirect("login.jsp");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
