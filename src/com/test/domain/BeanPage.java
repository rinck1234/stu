package com.test.domain;

import java.util.List;

public class BeanPage<T> {

	private int currentpage;
	private int totalpage;
	private int totalList;
	private int listperpage;
	private List<T> list;
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getTotalList() {
		return totalList;
	}
	public void setTotalList(int totalList) {
		this.totalList = totalList;
	}
	public int getListperpage() {
		return listperpage;
	}
	public void setListperpage(int listperpage) {
		this.listperpage = listperpage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
