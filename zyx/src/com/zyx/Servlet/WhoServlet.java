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
import com.zyx.Model.Employee;
import com.zyx.Service.QueryService;
@WebServlet("/who")
public class WhoServlet extends HttpServlet {
	private static final long serialVersionUID = 90395738398856426L;
	private QueryService queryService=new QueryService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rs;
		String employeeid=req.getParameter("id");
        String pwd=req.getParameter("pwd");
        rs=queryService.changepwd(employeeid,pwd);
		System.out.println(pwd);
		System.out.println(employeeid);
		PrintWriter out = resp.getWriter(); //输出流
		if(rs == "true") {			
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
	    out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String employeeid=req.getParameter("you");//取到当前登录账号的id
		System.out.println(employeeid);
		List<Employee> querylist=this.queryService.querywho(employeeid);
		PrintWriter out = resp.getWriter();
		String json = JSON.toJSONString(querylist);
		System.out.println(json);
		out.write(json);
		out.flush();
		out.close();
	}

}
