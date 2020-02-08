package com.qimo.domain;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int currentPage;// 当前页码
	private int totalCount;// 总条数
	private int totalPage;// 总页数
	private int currentCount;// 每页条数
	private List<News> pn;// 每页显示的数据
	private String category;//类别
	private String searchfield;//模糊搜索的新闻名
	private String myCategory; // 自行添加上的类别，用来储存 SectionManager 中的 url


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<News> getPn() {
		return pn;
	}

	public void setPn(List<News> pn) {
		this.pn = pn;
	}

	public String getSearchfield() {
		return searchfield;
	}

	public void setSearchfield(String searchfield) {
		this.searchfield = searchfield;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public String getMyCategory() {
		return myCategory;
	}

	public void setMyCategory(String myCategory) {
		this.myCategory = myCategory;
	}

}
