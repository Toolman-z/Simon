package com.zyx.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zyx.Model.Register;
import com.zyx.Service.PassDeltService;
@WebServlet("/passdelt")
public class PassDeltServlet extends HttpServlet {
	private static final long serialVersionUID = -884210341120233891L;
private PassDeltService passDeltService=new PassDeltService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String delt;
		String id=req.getParameter("id");		
		Register register =new Register();
		register.setEmployeeid(Integer.parseInt(id));		
		delt=passDeltService.delt(register);
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
		String change;
		String id=req.getParameter("id");		
		Register register =new Register();
		register.setEmployeeid(Integer.parseInt(id));		
		change=passDeltService.change(register);
		PrintWriter out = resp.getWriter(); //输出流
  		if(change == "true") {
  			System.out.println(change);
  			out.write("true");
  		}else {
  			out.write("false");
  		}
  		out.flush();
  		out.close();
	}

}
