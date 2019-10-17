package cn.boss.pojo;

import java.sql.Date;
/*
 * Со±щ
 */
public class Activity {
	private int ac_id;
	private String si_name;
	private Date ac_time;
	private String sp_name;
	private Double ac_money;
	private String ac_number;
	private String ac_department;
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	public String getAc_department() {
		return ac_department;
	}
	public void setAc_department(String ac_department) {
		this.ac_department = ac_department;
	}
	public String getSi_name() {
		return si_name;
	}
	public void setSi_name(String si_name) {
		this.si_name = si_name;
	}
	public Date getAc_time() {
		return ac_time;
	}
	public void setAc_time(Date ac_time) {
		this.ac_time = ac_time;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
	public Double getAc_money() {
		return ac_money;
	}
	public void setAc_money(Double ac_money) {
		this.ac_money = ac_money;
	}
	public String getAc_number() {
		return ac_number;
	}
	public void setAc_number(String ac_number) {
		this.ac_number = ac_number;
	}
}
