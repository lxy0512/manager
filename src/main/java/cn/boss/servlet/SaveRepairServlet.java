package cn.boss.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.boss.pojo.Employee_Info;
import cn.boss.pojo.Repair;
import cn.boss.service.impl.EmployeeServiceImpl;
import cn.boss.service.impl.RepairServiceImpl;

public class SaveRepairServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		response.setContentType("text/html;charset=UTF=8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Repair r = new Repair();
		r.setRi_id(0);
		r.setRi_name(request.getParameter("name"));
		r.setRepair_floor(request.getParameter("floor"));
		r.setRepair_state(request.getParameter("state"));
		r.setRepair_type(request.getParameter("type"));
		r.setRi_describe(request.getParameter("describe"));
		r.setSi_name(request.getParameter("store"));
		r.setRi_time(new Date(System.currentTimeMillis()));
		RepairServiceImpl esi = new RepairServiceImpl();
		int count = esi.saveRepair(r);
		System.out.println(count);
		JSONObject jo = new JSONObject();
		jo.put("info", count);
		out.print(jo);
		request.getRequestDispatcher("repairrecord.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
