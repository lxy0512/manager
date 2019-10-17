package cn.boss.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.boss.service.impl.RepairServiceImpl;

public class UpdateRepairServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		RepairServiceImpl rsi = new RepairServiceImpl();
		String uid = request.getParameter("uid");
		int count = rsi.updateRepair(Integer.parseInt(uid), "ÒÑÎ¬ÐÞ");
		System.out.println("³É¹¦");
		JSONObject jo = new JSONObject();
		jo.put("info", count);
		out.print(jo);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
