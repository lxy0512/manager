package cn.boss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.boss.pojo.Employee_Info;
import cn.boss.service.impl.EmployeeServiceImpl;

public class UpdateEmployeeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		EmployeeServiceImpl esi = new EmployeeServiceImpl();
		String uid = request.getParameter("uid");
		String did = request.getParameter("did");
		String position = request.getParameter("did");
		JSONObject jo = new JSONObject();
		if(uid != null && uid!=""){
			Employee_Info ei = esi.listSomeEmployee(Integer.parseInt(uid));
			if(position != null){
				int count = esi.updateEmployee(Integer.parseInt(uid), position);
				jo.put("info", count);
				out.print(jo);
				request.getRequestDispatcher("memberexchange.jsp").forward(request, response);
			}
			
			request.setAttribute("info", ei);
			request.setAttribute("wz", ei.getC_compile());
			request.getRequestDispatcher("memberexchange.jsp").forward(request, response);
		}else if(did != null){
			int count = esi.removeEmployee(Integer.parseInt(did));
			if(count > 0){
				System.out.println("É¾³ý³É¹¦");
			}
			jo.put("info", count);
			out.print(jo);
			request.getRequestDispatcher("EmployeeServlet?index=1&pg=1").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		doGet(request, response);
	}

}
