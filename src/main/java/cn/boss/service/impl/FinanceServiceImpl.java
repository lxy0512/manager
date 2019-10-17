package cn.boss.service.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.boss.dao.impl.FinanceDaoImpl;
import cn.boss.pojo.Activity;
import cn.boss.pojo.ActivityLimit;
import cn.boss.pojo.Finance;
import cn.boss.service.IFinanceService;

public class FinanceServiceImpl implements IFinanceService{
	FinanceDaoImpl fd = new FinanceDaoImpl();
	@Override
	public String insertFinance(String nid, String nincome, String nexpend,
			String nnetincome, String direction, String ndate){
		int id = Integer.parseInt(nid);
		double income=Double.parseDouble(nincome);
		double expend=Double.parseDouble(nexpend);
		double netincome=Double.parseDouble(nnetincome);
		Date date = java.sql.Date.valueOf(ndate);
		int ifcount = fd.insertFinanceAll(id, income, expend, netincome, direction, date);
		if(ifcount>0){
			return "财务主表数据已添加";
		}else{
			return "财务主表数据添加失败";
		}
	}	
	@Override
	public List<Finance> listFinanceAll() {
		List<Finance> lfa = fd.listFinanceAll();
		if(lfa == null){
			try {
				throw new Exception("listFinanceAll返回集合为空");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return lfa;	
	}
	@Override
	public String dataTotal(String ndate,String direction) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d yyyy");
		Date date = null; 
		try {
			date = (Date)sdf.parse(ndate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		FinanceDaoImpl fdi = new FinanceDaoImpl();
		List<Activity> l = fdi.listActivityF(date);
		int income= 0;
		int expend= 0;
		for (Activity fi : l) {
			if(fi.getAc_money()>0){
				income += fi.getAc_money();
			}else{
				expend += fi.getAc_money();
			}
		}
		int netincome = income - expend;
		int count = fdi.dataTotal(0, income, expend, netincome, direction, date);
		if(count>0){
			return "数据已统计,加入总表";
		}else{
			return "数据统计错误";
		}
	}
	@Override
	public ActivityLimit listFinanceADepartment(String department,int num1 ,int num2) {
		ActivityLimit a  = new ActivityLimit();
		a.setAllNum(fd.listFinanceADepartmentNum(department));
		a.setNum(num2);
		if(a.getAllNum() == 0){
			a.setAllNum(1);
		}
		if(num1 > a.getAllPage()){
			a.setIndex(a.getAllPage());
		}else if(num1 < 1){
			a.setIndex(1);
		}else {
			a.setIndex(num1);
		}
		
		a.setList(fd.listFinanceADepartment(department,a.getIndex(),num2));
		return a;
	}
	@Override
	public List<Finance> listFinanceDate(String nstartdate, String nenddate) {
		Date startdate = java.sql.Date.valueOf(nstartdate);
		Date enddate = java.sql.Date.valueOf(nenddate);
		List<Finance> lfd = fd.listFinance(startdate, enddate);
		return lfd;
	}
	@Override
	public String insertActivity(String nid, String name, String ntime,
			String type, String nmoney, String number,String department) {
		int id = Integer.parseInt(nid);
		double money=Double.parseDouble(nmoney);
		Date time = java.sql.Date.valueOf(ntime);
		int nameid = fd.getNameId(name);
		int typeid = fd.getTypeId(type);
		int departmentid = fd.getDepartmentId(department);
		int count = fd.saveActivity(id, nameid, time, typeid, money, number,departmentid);
		if(count>0){
			return "交易记录已保存";
		}else{
			return "交易记录保存错误";
		}
	}
}
