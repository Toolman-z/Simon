package com.zyx.Filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {	
           HttpServletRequest req=(HttpServletRequest)request;
       	   String url=req.getRequestURI().toString();     
           HttpServletResponse resp=(HttpServletResponse)response;
           HttpSession session=req.getSession();
           Object obj=session.getAttribute("login");
           if(url.endsWith("login.jsp") || obj != null
        	|| url.endsWith("register.jsp") || url.endsWith(".css")
        	|| url.endsWith(".js") || url.endsWith(".gif")
        	|| url.endsWith(".png") || url.endsWith(".jpg")
        	|| url.endsWith("/find") || url.endsWith("/home")
        	|| url.endsWith("/rep")	  ) {       	  
        	   chain.doFilter(request, response);
           }else {
        	   resp.sendRedirect("login.jsp");
           }
       	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {


	}

}
