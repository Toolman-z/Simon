package com.zyx.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.zyx.Model.Meeting;
import com.zyx.Service.QueryService;
@WebServlet("/myd")
public class MyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = -3605654948151459185L;
    private QueryService queryService=new QueryService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reserveuserid=req.getParameter("reserveuserid");//取到当前登录账号的id
		System.out.println(reserveuserid);
		List<Meeting> querylist=this.queryService.querydelete(reserveuserid);
		PrintWriter out = resp.getWriter();
		String json = JSON.toJSONString(querylist);
		System.out.println(json);
		out.write(json);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reserveuserid=req.getParameter("reserveuserid");//取到当前登录账号的id
		System.out.println(reserveuserid);
		List<Meeting> querylist=this.queryService.queryme(reserveuserid);
		PrintWriter out = resp.getWriter();
		String json = JSON.toJSONString(querylist);
		System.out.println(json);
		out.write(json);
		out.flush();
		out.close();
	}

}
