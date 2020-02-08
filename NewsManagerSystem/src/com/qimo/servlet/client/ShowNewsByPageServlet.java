package com.qimo.servlet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qimo.domain.PageBean;
import com.qimo.service.NewsService;
//分页显示数据
@WebServlet("/showNewsByPage")    



public class ShowNewsByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.定义当前页码，默认为1
		int currentPage = 1;
		String _currentPage = request.getParameter("currentPage");
		if (_currentPage != null) {
			currentPage = Integer.parseInt(_currentPage);
		}
		// 2.定义每页显示条数,默认为5
		int currentCount = 5;
		String _currentCount = request.getParameter("currentCount");
		if (_currentCount != null) {
			currentCount = Integer.parseInt(_currentCount);
		}
		// 3.获取查找的分类
		String category = "全部新闻";

		// 4.调用service，完成获取当前页分页Bean数据.
		NewsService service = new NewsService();
		PageBean bean = service.findNewsByPage(currentPage, currentCount,
				category);
		
		// 将数据存储到request范围，跳转到news_list.jsp页面展示
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/news_list.jsp").forward(request, response);
		return;
	}
}
