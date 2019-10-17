package cn.boss.pojo;

import java.sql.Date;

public class Finance {
	private Integer fa_id;
	private double fa_income;
	private double fa_expend;
	private double fa_netincome;
	private String fa_direction;
	private Date fa_time;
	public Integer getFa_id() {
		return fa_id;
	}
	public void setFa_id(Integer fa_id) {
		this.fa_id = fa_id;
	}
	public double getFa_income() {
		return fa_income;
	}
	public void setFa_income(double fa_income) {
		this.fa_income = fa_income;
	}
	public double getFa_expend() {
		return fa_expend;
	}
	public void setFa_expend(double fa_expend) {
		this.fa_expend = fa_expend;
	}
	public double getFa_netincome() {
		return fa_netincome;
	}
	public void setFa_netincome(double fa_netincome) {
		this.fa_netincome = fa_netincome;
	}
	public String getFa_direction() {
		return fa_direction;
	}
	public void setFa_direction(String fa_direction) {
		this.fa_direction = fa_direction;
	}
	public Date getFa_time() {
		return fa_time;
	}
	public void setFa_time(Date fa_time) {
		this.fa_time = fa_time;
	}	
}
