package com.qimo.servlet.manager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import com.qimo.domain.News;
import com.qimo.exception.AddNewsException;
import com.qimo.service.NewsService;

/**
 * 后台系统
 * 用于添加商品的servlet
 */
@WebServlet("/addNews")

public class AddNewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 创建javaBean,将上传数据封装.
		req.setCharacterEncoding("utf-8");
		NewsService service = new NewsService();
		News bean = new News();
		
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String category = req.getParameter("category");
		String content = req.getParameter("content");
		
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;
		bean.setTitle(title);
		bean.setAuthor(author);
		bean.setCategory(category);
		bean.setContent(content);
		bean.setTime(time);
		
		try {
			service.addNews(bean);
		} catch (AddNewsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()
				+ "/listNews");
	}
}
