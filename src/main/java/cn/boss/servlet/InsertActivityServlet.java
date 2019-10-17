package cn.boss.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.boss.service.impl.FinanceServiceImpl;
/*
 * ÍõÌÎ
 */
public class InsertActivityServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		request.setCharacterEncoding("UTF-8");
		String nid = "0";
		String ntime = new String(request.getParameter("sj").getBytes("ISO-8859-1"),"UTF-8");
		String type = new String(request.getParameter("lx").getBytes("ISO-8859-1"),"UTF-8");
		String nname = new String(request.getParameter("dp").getBytes("ISO-8859-1"),"UTF-8");
		String jg = request.getParameter("jg");
		Integer v1 = Integer.valueOf(jg);
		Integer v2 = Integer.valueOf(request.getParameter("sl"));
		String nmoney = String.valueOf(v1+v2);
		String number = "15649856";
		String department = new String(request.getParameter("bm").getBytes("ISO-8859-1"),"UTF-8");
		FinanceServiceImpl fsi = new FinanceServiceImpl();
		String ia = fsi.insertActivity(nid, nname, ntime, type, nmoney, number,department);
		request.setAttribute("rs", ia);
		request.getRequestDispatcher("accountmanager.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
