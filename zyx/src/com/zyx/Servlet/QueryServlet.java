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
import com.zyx.Model.Register;
import com.zyx.Service.QueryService;
@WebServlet("/query")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 5633990835363111642L;
	private QueryService queryService = new QueryService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String delt;
		String id = req.getParameter("id");
		Register register =new Register();
		register.setEmployeeid(Integer.parseInt(id));
		delt=queryService.delet(register);
		 PrintWriter out = resp.getWriter(); //输出流
	  		if(delt == "true") {
	  			System.out.println(delt);
	  			out.write("true");
	  		}else {
	  			out.write("false");
	  		}
	  		out.flush();
	  		out.close();
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
	int totalCount=0;//总条数
	int totalpage=0;//总页数
	int page=Integer.parseInt(req.getParameter("page"));//当前页
	int row=10;//每页显示条数	
	String realname=req.getParameter("realname");	
	String username=req.getParameter("username");	
	String status=req.getParameter("status");
	System.out.println(username);
	List<Register> querylist=this.queryService.query(realname,row,page,username,status);
	totalCount = this.queryService.countquery(realname,username,status);//查询总条数
	totalpage = totalCount % row ==0 ? totalCount / row :totalCount / row+1;//分成几页
	System.out.println(totalCount);
	System.out.println(totalpage);
	System.out.println(page);
	Register register =new Register();
	register =new Register();
	register.setPage(page);
	register.setTotalCount(totalCount);
	register.setTotalpage(totalpage);
	querylist.add(register);
	PrintWriter out = resp.getWriter();
	String json = JSON.toJSONString(querylist);
	out.write(json);
	out.flush();
	out.close();
	}

}
