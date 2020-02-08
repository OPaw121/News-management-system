package com.qimo.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.qimo.filter.MyRequest;

public class EncodingFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletRequest myRequest = new MyRequest(httpServletRequest);
	
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(myRequest, response);
	}
	public void destroy() {

	}
}

class MyRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	private boolean hasEncode;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getParameterMap() {
		String method = request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			try {
				request.setCharacterEncoding("utf-8");
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} 
		
		return super.getParameterMap();
	}
	@Override
	public String getParameter(String name) {
		@SuppressWarnings("unchecked")
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		if (values == null) {
			return null;
		}
		return values[0];
	}
	@Override
	public String[] getParameterValues(String name) {
		@SuppressWarnings("unchecked")
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		return values;
	}
}