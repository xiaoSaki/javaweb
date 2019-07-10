package com.lingnan.examsys.business.domain;

import java.util.List;

/**
 * 
 * <p>
 * Title: PageBean
 * </p>
 * <p>
 * Description: 页面渲染数据对象
 * </p>
 * 
 * @author 一杯凉茶（https://www.cnblogs.com/whgk/p/6474396.html）
 * @date 2018年11月13日
 * @version 1.0
 */
public class PageBean<T> {
	// 已知数据
	private int pageNo; // 当前页,从请求那边传过来。
	private int pageSize; // 每页显示的数据条数。
	private int totalRecord; // 总的记录条数。查询数据库得到的数据
	private int totalPage; // 总页数，通过totalRecord和pageSize计算可以得来

	// 将每页要显示的数据放在list集合中
	private List<T> list;

	public PageBean(int pageNo, int pageSize, int totalRecord) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;

		// totalPage 总页数
		if (totalRecord % pageSize == 0) {
			// 说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
			this.totalPage = totalRecord / pageSize;
		} else {
			// 不整除，就要在加一页，来显示多余的数据。
			this.totalPage = totalRecord / pageSize + 1;
		}
	}

	// get、set方法。

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}