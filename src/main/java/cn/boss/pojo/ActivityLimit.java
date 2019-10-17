package cn.boss.pojo;

import java.util.List;

/*
 * ÍõÌÎ
 */
public class ActivityLimit {
	private int index;
	private int allNum;
	private int num;
	private int allPage;
	private List<Activity> list; 
	public int getIndex() {
		return index;
	}
	public List<Activity> getList() {
		return list;
	}
	public void setList(List<Activity> list) {
		this.list = list;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getAllNum() {
		return allNum;
	}
	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAllPage() {
		return allNum%num==0?allNum/num:allNum/num+1;
	}
}
