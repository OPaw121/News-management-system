package com.qimo.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qimo.domain.News;
import com.qimo.utils.DataSourceUtils;

public class NewsDao {
	// 添加新闻
	public void addNews(News p) throws SQLException {

		String sql = "insert into news(title,content,author,category,time) values(?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, p.getTitle(), p.getContent(),
				p.getAuthor(), p.getCategory(), p.getTime());
	}
	// 查找所有新闻
	public List<News> listAll() throws SQLException {
		String sql = "select * from news";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<News>(News.class));
	}
	// 获取数据总条数
	public int findAllCount(String category) throws SQLException {
		String sql = "select count(*) from news";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		if (!"全部新闻".equals(category)) {
			sql += " where category=?";

			Long count = (Long) runner
					.query(sql, new ScalarHandler(), category);
			return count.intValue();
		} else {
			Long count = (Long) runner.query(sql, new ScalarHandler());

			return count.intValue();
		}
	}
	// 获取当前页数据
	public List<News> findByPage(int currentPage, int currentCount,
			String category) throws SQLException {
		// 要执行的sql语句
		String sql = null;
		// 参数
		Object[] obj = null;
		// 如果category不为null,代表是按分类查找
		if (!"全部新闻".equals(category)) {
			sql = "select * from news  where category=? limit ?,?";
			obj = new Object[] { category, (currentPage - 1) * currentCount,
					currentCount, };
		} else {
			sql = "select * from news limit ?,?";
			obj = new Object[] { (currentPage - 1) * currentCount,
					currentCount, };
		}
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<News>(News.class),
				obj);
	}

	// 根据id查找商品
	public News findNewsById(String id) throws SQLException {
		String sql = "select * from news where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<News>(News.class), id);
	}

	
	// 多条件查询
	public List<News> findNewsByManyCondition(String id, String title,
			String category)
			throws SQLException {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from news where 1=1 ";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		if (id != null && id.trim().length() > 0) {
			sql += " and id=?";
			list.add(id);
		}

		if (title != null && title.trim().length() > 0) {
			sql += " and title=?";
			list.add(title);
		}
		if (category != null && category.trim().length() > 0) {
			sql += " and category=?";
			list.add(category);
		}
	
		Object[] params = list.toArray();

		return runner.query(sql, new BeanListHandler<News>(News.class),
				params);
	}
	// 修改新闻信息
	public void editNews(News p) throws SQLException {
		String sql  = "update news set title=?,content=?,author=?,category=? where id=?";
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		//使用QueryRunner对象的update()方法更新数据
		runner.update(sql, p.getTitle(),p.getContent(),p.getAuthor(),p.getCategory(),p.getId());
	}

	
	//前台，用于搜索框根据书名来模糊查询相应的新闻
	public List<News> findNewsByName(int currentPage, int currentCount,
			String searchfield) throws SQLException {
		//根据名字模糊查询新闻
		String sql = "SELECT * FROM news WHERE title LIKE '%"+searchfield+"%' LIMIT ?,?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//		//用于分页查询的数据
//		Object obj = new Object[] { (currentPage - 1) * currentCount, currentCount };
		return runner.query(sql, 
				new BeanListHandler<News>(News.class),currentPage-1,currentCount);
	}

	//前台搜索框，根据书名模糊查询出的图书总数量
	public int findNewsByNameAllCount(String searchfield) throws SQLException {
		String sql = "SELECT COUNT(*) FROM news WHERE title LIKE '%"+searchfield+"%'";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		//查询出满足条件的总数量，为long类型
		Long count = (Long)runner.query(sql, new ScalarHandler());
		return count.intValue();
	}

	//后台系统，根据id删除商品信息
	public void deleteNews(String id) throws SQLException {
		String sql = "DELETE FROM news WHERE id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);
	}
}
