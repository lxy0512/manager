package cn.boss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.boss.pojo.Employee_Info;
import cn.boss.service.impl.EmployeeServiceImpl;
import cn.boss.service.impl.SybaseServerImpl;
import cn.boss.util.Page;

public class EmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		EmployeeServiceImpl esi = new EmployeeServiceImpl();
		String pindex = request.getParameter("index");
		int index = 1;
		if(pindex != null && pindex != ""){
			index = Integer.parseInt(pindex);
		}
		Page formalPage = esi.getPage("正式合同",index, 3);
		String ppg = request.getParameter("pg");
		int pg = 1;
		if(ppg != null && ppg != ""){
			pg = Integer.parseInt(ppg);
		}
		Page probationPage = esi.getPage("临时合同",pg, 3);
		request.setAttribute("formalPage", formalPage);
		request.setAttribute("probationPage", probationPage);
		request.getRequestDispatcher("personalinfo.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
