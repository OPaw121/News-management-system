package com.qimo.servlet.manager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;

import com.qimo.domain.News;
import com.qimo.service.NewsService;


/**
 * 后台系统
 * 用于编辑新闻信息的servlet
 */
@WebServlet("/editNews")

public class EditNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		NewsService service = new NewsService();
		News bean = new News();
		//获取表单参数
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String category = req.getParameter("category");
		String content = req.getParameter("content");
		//将当前时间设为添加公告的时间
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		bean.setId(id);
		bean.setTitle(title);
		bean.setAuthor(author);
		bean.setCategory(category);
		bean.setContent(content);
		bean.setTime(time);
		//调用dao层方法
		service.editNews(bean);
		resp.sendRedirect(req.getContextPath()
				+ "/listNews");
	}

}
