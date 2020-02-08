package com.qimo.servlet.client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimo.service.NewsService;

import com.qimo.domain.PageBean;

/**
 * 前台页面，用于菜单栏下面搜索功能的servlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1.定义当前页码，默认为1
		int currentPage = 1;
		String _currentPage = req.getParameter("currentPage");
		if (_currentPage != null) {
			currentPage = Integer.parseInt(_currentPage);
		}
		// 2.定义每页显示条数,默认为5
		int currentCount = 5;	
		//获取前台页面搜索框输入的值
		String searchfield = req.getParameter("textfield");
		//如果搜索框中没有输入值，则表单传递的为默认值，此时默认查询全部商品目录
		if("请输入新闻标题".equals(searchfield)){
			req.getRequestDispatcher("/showNewsByPage").forward(req, resp);
			return;
		}
		//调用service层的方法，通过标题模糊查询，查找相应的新闻
		NewsService service = new NewsService();
		PageBean bean = service.findNewsByName(currentPage,currentCount,searchfield);
		// 将数据存储到request范围，跳转到news_search_list.jsp页面展示
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("/news_search_list.jsp").forward(req, resp);
	}
}
