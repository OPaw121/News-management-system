package com.qimo.service;
import java.sql.SQLException;
import java.util.List;
import com.qimo.dao.NewsDao;
import com.qimo.domain.PageBean;
import com.qimo.domain.News;
import com.qimo.exception.AddNewsException;
import com.qimo.exception.FindNewsByIdException;
import com.qimo.exception.ListNewsException;

public class NewsService {
	private NewsDao dao = new NewsDao();
	// 添加商品
	public void addNews(News bean) throws AddNewsException {
		try {
			dao.addNews(bean);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddNewsException("添加商品失败");
		}
	}
	// 查找所有新闻信息
	public List<News> listAll() throws ListNewsException {
		try {
			return dao.listAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ListNewsException("查询商品失败");
		}
	}
	// 分页操作
	public PageBean findNewsByPage(int currentPage, int currentCount,
			String category) {
		PageBean bean = new PageBean();
		// 封装每页显示数据条数
		bean.setCurrentCount(currentCount);
		// 封装当前页码
		bean.setCurrentPage(currentPage);
		// 封装当前查找类别
		bean.setCategory(category);
		try {
			// 获取总条数
			int totalCount = dao.findAllCount(category);
			bean.setTotalCount(totalCount);
			// 获取总页数
			int totalPage = (int) Math.ceil(totalCount * 1.0 / currentCount);
			bean.setTotalPage(totalPage);
			// 获取当前页数据
			List<News> pn = dao.findByPage(currentPage, currentCount,
					category);
			bean.setPn(pn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	// 根据id查找商品
	public News findNewsById(String id) throws FindNewsByIdException {
		try {
			return dao.findNewsById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindNewsByIdException("根据ID查找新闻失败");
		}
	}
	
	// 多条件查询
	public List<News> findNewsByManyCondition(String id,String title,
			String category) {
		List<News> pn = null;
		try {
			pn = dao.findNewsByManyCondition(id, title, category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pn;
	}
	// 修改商品信息
	public void editNews(News bean) {
		try {
			dao.editNews(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//前台，用于搜索框根据新闻标题来模糊查询相应的新闻
	public PageBean findNewsByName(int currentPage, int currentCount,
			String searchfield) {
		PageBean bean = new PageBean();
		// 封装每页显示数据条数
		bean.setCurrentCount(currentCount);
		// 封装当前页码
		bean.setCurrentPage(currentPage);
		// 封装模糊查询的新闻标题
		bean.setSearchfield(searchfield);
		try {
			// 获取总条数
			int totalCount = dao.findNewsByNameAllCount(searchfield);
			bean.setTotalCount(totalCount);

			// 获取总页数
			int totalPage = (int) Math.ceil(totalCount * 1.0 / currentCount);
			bean.setTotalPage(totalPage);

			//满足条件的新闻
			List<News> pn = dao.findNewsByName(currentPage,currentCount,searchfield);
			bean.setPn(pn);
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("前台搜索框根据新闻标题查询新闻失败！");
		}
	}
	//后台系统，根据id删除商品信息
	public void deleteNews(String id) {
		try {
			dao.deleteNews(id);
		} catch (SQLException e) {
			throw new RuntimeException("后台系统根据id删除新闻信息失败！");
		}
	}
}
