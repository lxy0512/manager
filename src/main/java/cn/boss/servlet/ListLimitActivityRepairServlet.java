package cn.boss.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boss.pojo.ActivityLimit;
import cn.boss.service.impl.FinanceServiceImpl;

public class ListLimitActivityRepairServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		request.setCharacterEncoding("UTF-8");
		String pindex = request.getParameter("index");
		int index = 1;
		if(pindex != null && pindex != ""){
			index = Integer.parseInt(pindex);
		}
		String sindex = request.getParameter("sindex");
		int index2 = 1;
		if(sindex != null && sindex != ""){
			index2= Integer.parseInt(sindex);
		}
		FinanceServiceImpl fsi = new FinanceServiceImpl();
		ActivityLimit lf = fsi.listFinanceADepartment("Î¬ÐÞ²¿",index,3);
		request.setAttribute("wx", lf);
		
		ActivityLimit lf2 = fsi.listFinanceADepartment("²É¹º²¿",index2,3);
		request.setAttribute("cg", lf2);
		request.getRequestDispatcher("accountingrecords.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
