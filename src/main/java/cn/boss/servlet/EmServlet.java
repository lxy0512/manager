package cn.boss.servlet;

import cn.boss.service.impl.EmployeeServiceImpl;
import cn.boss.util.Page;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmServlet")
public class EmServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = request.getParameter("index");
        int index = request.getParameter("index")==null?1:Integer.parseInt(request.getParameter("index"));
        EmployeeServiceImpl esi = new EmployeeServiceImpl();
        Page esiPage = esi.getPage("正式合同", index, 3);
        Object json = JSONObject.toJSONString(esiPage);

        out.print(json);
        out.flush();
        out.close();
    }
}
