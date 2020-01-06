package com.chinasofti.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	protected String encoding = null;
	protected FilterConfig config = null;
	
	@Override
	public void destroy() {
		this.encoding = null;
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		
		if(this.encoding != null){
			request.setCharacterEncoding(this.encoding);
			response.setCharacterEncoding(this.encoding);
			chain.doFilter(request, response);
		}
	}
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		this.encoding = config.getInitParameter("encoding");
	}

}
