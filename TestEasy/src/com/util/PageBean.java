package com.util;

public class PageBean {
	
	private int currPageNo; // 第几页  
    private int pageSize; // 每页的记录数  
    private int start; // 起始记录的偏移量
    
	public PageBean() {
		super();
	}
	public PageBean(int currPageNo, int pageSize) {
		super();
		this.currPageNo = currPageNo;
		this.pageSize = pageSize;
	}
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return (currPageNo-1)*pageSize;
	}
	public void setStart(int start) {
		this.start = start;
	}
    
}
