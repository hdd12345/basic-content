package com.cakeshop.entity;

import java.util.List;

/**辅助类（用于分页功能）
 * @author Administrator
 *
 * @param <T>
 */
public class PageBean<T> {
private int currentPage;//当前页数
private int currentCount;//当前页面显示条数
private int totalPage;//总页数
private int totalCount;//总条数
private List<T> list;//当前页显示的数据集合
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int getCurrentCount() {
	return currentCount;
}
public void setCurrentCount(int currentCount) {
	this.currentCount = currentCount;
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
public int getTotalCount() {
	return totalCount;
}
public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}
public List<T> getList() {
	return list;
}
public void setList(List<T> list) {
	this.list = list;
}

}
