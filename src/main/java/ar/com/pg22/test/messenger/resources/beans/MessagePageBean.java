package ar.com.pg22.test.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessagePageBean {
	
	private @QueryParam("page") int page;
	private @QueryParam("size") int size;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
