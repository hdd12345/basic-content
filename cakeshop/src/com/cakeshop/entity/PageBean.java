package com.cakeshop.entity;

import java.util.List;

/**�����ࣨ���ڷ�ҳ���ܣ�
 * @author Administrator
 *
 * @param <T>
 */
public class PageBean<T> {
private int currentPage;//��ǰҳ��
private int currentCount;//��ǰҳ����ʾ����
private int totalPage;//��ҳ��
private int totalCount;//������
private List<T> list;//��ǰҳ��ʾ�����ݼ���
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
