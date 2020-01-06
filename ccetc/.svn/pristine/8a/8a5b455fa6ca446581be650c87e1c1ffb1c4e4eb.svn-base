package com.chinasofti.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.chinasofti.model.user.User;
import com.chinasofti.util.MessageUtil;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		Object object = request.getSession().getAttribute("user");
//		if(object == null) {
//			response.sendRedirect(request.getContextPath()+"/login.action");
//			return false;
//		}else {
//			User user =  (User)request.getSession().getAttribute("user");
//			if(user.getUserid().equals("admin")) return true;
//		}
//		String url = request.getRequestURI().replace(request.getContextPath(), "");
//		Object obj = request.getSession().getAttribute("auths");
//		if(obj == null) {
//			response.sendRedirect(request.getContextPath()+"/login.action");
//			return false;
//		}else {
//			@SuppressWarnings("unchecked")
//			List<String> urlList = (List<String>)obj;
//			boolean boo = false;
//			for(String uri : urlList) {
//				if(uri.startsWith(url)) {
//					boo = true;
//					break;
//				}
//			}
//			if(!boo) {
//				String requestType = request.getHeader("X-Requested-With");
//				if("XMLHttpRequest".equals(requestType)){
//					MessageUtil msg = new MessageUtil();
//					msg.setSuccess(false);
//					msg.setMessage("您没有权限!");
//					PrintWriter out = response.getWriter();
//					out.write(JSON.toJSONString(msg));
//					out.close();
//				}else {
//					response.sendRedirect(request.getContextPath()+ "/noAuth.action");
//				}
//				return false;
//			}
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}

}
