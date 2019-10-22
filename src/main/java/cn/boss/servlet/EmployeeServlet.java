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
import cn.boss.service.impl.SybaseServerImpl;
import cn.boss.util.Page;

public class EmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		JSONObject jo = new JSONObject();
		jo.put("info","≥…π¶¡À");
		out.print(jo);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
