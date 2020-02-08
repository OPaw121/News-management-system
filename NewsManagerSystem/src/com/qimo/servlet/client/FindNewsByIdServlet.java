package com.qimo.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qimo.service.NewsService;
import com.qimo.domain.News;
import com.qimo.exception.FindNewsByIdException;

/**
 * 根据新闻id查找指定新闻信息的servlet
 */
@WebServlet("/findNewsById")
public class FindNewsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到新闻的id
		String id = request.getParameter("id");
		// 获取role参数值，此处的role用于区别普通用户和超级用户
		String role = request.getParameter("role");		
		NewsService service = new NewsService();		
		try {
			// 调用service层方法，通过id查找新闻
			News p = service.findNewsById(id);
			request.setAttribute("p", p);
			// 普通用户默认不传递role值，会跳转到info.jsp页面
			if (role == null) {
				request.getRequestDispatcher("/info.jsp").forward(request,response);
				return;
			}						
			request.getRequestDispatcher("/admin/news/edit.jsp").forward(request, response);
			return;
		} catch (FindNewsByIdException e) {
			e.printStackTrace();
		}
	}
}
