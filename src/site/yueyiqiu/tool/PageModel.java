package site.yueyiqiu.tool;

import java.util.List;

import site.yueyiqiu.model.Message;

public class PageModel {
	
	private int currentPage;
	private int totalRows;
	private List<?> list;
	private int pageSize;
	/**
	 * @return the currentpage
	 */
	public int getCurrentpage() {
		return currentPage;
	}
	/**
	 * @param currentpage the currentpage to set
	 */
	public void setCurrentpage(int currentpage) {
		this.currentPage = currentpage;
	}
	/**
	 * @return the totalRows
	 */
	public int getTotalRows() {
		return totalRows;
	}
	/**
	 * @param totalRows the totalRows to set
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalPage(){
		
		
		if(totalRows%pageSize==0)
			return totalRows/pageSize;
		else
			return totalRows/pageSize+1;
	}
	
	public int getFirstPage(){
		return 1;
	}
	
	public int getLastPage(){
		
		return this.getTotalPage()<=1?1:this.getTotalPage();
	}
	
	public int getPreviousPage(){
		return currentPage<=1?1:currentPage-1;
	}
	
	public int getNextPage(){
		if(currentPage==this.getTotalPage())
			return this.getTotalPage();
		else
			return currentPage+1;
	}
	
}
