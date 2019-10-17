package cn.boss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boss.service.impl.RepairServiceImpl;
import cn.boss.util.Page;

public class InsertRepairServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RepairServiceImpl rsi = new RepairServiceImpl();
		String pindex = request.getParameter("index");
		System.out.println(pindex + "----");
		int index = 1;
		if(pindex != null && pindex != ""){
			index = Integer.parseInt(pindex);
		}
		Page repairPage = rsi.getPage(index, 3);
		request.setAttribute("repairPage", repairPage);
		System.out.println(request.getAttribute("repairPage"));
		request.getRequestDispatcher("repairrecord.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
