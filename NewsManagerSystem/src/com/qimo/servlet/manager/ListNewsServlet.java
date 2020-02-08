package com.qimo.servlet.manager;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qimo.domain.News;
import com.qimo.exception.ListNewsException;
import com.qimo.service.NewsService;
/**
 * 后台系统
 * 查询所有新闻信息的servlet
 */
@WebServlet("/listNews")
public class ListNewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.创建service层的对象
		NewsService service = new NewsService();
		try {
			// 2.调用service层用于查询所有商品的方法
			List<News> pn = service.listAll();
			// 3.将查询出的所有商品放进request域中
			request.setAttribute("pn", pn);
			// 4.重定向到list.jsp页面
			request.getRequestDispatcher("/admin/news/list.jsp").forward(
					request, response);
			return;
		} catch (ListNewsException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			return;
		}
	}
}
