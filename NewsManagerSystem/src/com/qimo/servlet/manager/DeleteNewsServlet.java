package com.qimo.servlet.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
 * 删除商品信息的servlet
 */
@WebServlet("/deleteNews")
public class DeleteNewsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取请求参数，新闻id
		String id = request.getParameter("id");
		NewsService service = new NewsService();
		// 调用service完成添加新闻操作
		service.deleteNews(id);
		response.sendRedirect(request.getContextPath() + "/listNews");
		return;
	}

}
