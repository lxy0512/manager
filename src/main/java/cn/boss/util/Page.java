package cn.boss.util;

import java.util.ArrayList;
import java.util.List;

import cn.boss.pojo.Employee_Info;
import cn.boss.pojo.Repair;

public class Page {
	private Integer totalCount; //总记录数
	private Integer pageCount;//总页数
	private Integer pageSize;//每页显示的条数
	private Integer index;//当前页码
	private List<Employee_Info> list = new ArrayList<Employee_Info>();//每页要显示的数据
	private List<Repair> rlist = new ArrayList<Repair>();
	public List<Repair> getRlist() {
		return rlist;
	}
	public void setRlist(List<Repair> rlist) {
		this.rlist = rlist;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageCount() {
		return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public List<Employee_Info> getList() {
		return list;
	}
	public void setList(List<Employee_Info> list) {
		this.list = list;
	}	
}
