package org.lin.entity;

public class Page {
	private int page=1;
	private int pageSize=3;
	
	public int getBegin(){
		return (page-1)*pageSize;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
