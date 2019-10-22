package cn.boss.service.impl;

import java.util.List;

import cn.boss.dao.impl.EmployeeDaoImpl;
import cn.boss.pojo.Employee_Info;
import cn.boss.service.IEmployeeService;
import cn.boss.util.Page;

import javax.sound.midi.Soundbank;

public class EmployeeServiceImpl implements IEmployeeService {

	public int saveEmployee(Employee_Info ei) {
		if(ei.getEa_sex().equals("男")){
			ei.setEy_sex(1);
		}else {
			ei.setEy_sex(2);
		}
		if (ei.getC_compile().equals("正式合同")) {
			ei.setEy_compile(1);
		}else {
			ei.setEy_compile(2);
		}
		if (ei.getSd_department().equals("人事部")) {
			ei.setEy_department(1);
		}else if (ei.getSd_department().equals("财务部")) {
			ei.setEy_department(2);
		}else {
			ei.setEy_department(3);
		}
		EmployeeDaoImpl rdi = new EmployeeDaoImpl();
		int count = rdi.saveEmployee(ei);
		if (count > 0) {
			return 1;
		}
		return 0;
	}

	public int updateEmployee(int id, String state) {
		EmployeeDaoImpl rdi = new EmployeeDaoImpl();
		int count = rdi.updateEmployee(id, state);
		if (count > 0) {
			return 1;
		}
		return 0;
	}

	public int removeEmployee(int id) {
		EmployeeDaoImpl rdi = new EmployeeDaoImpl();
		int count = rdi.removeEmployee(id);
		if (count > 0) {
			return 1;
		}
		return 0;
	}

	public Page getPage(String state, int index, int pageSize) {
		Page p = new Page();
		p.setPageSize(pageSize);
		EmployeeDaoImpl rdi = new EmployeeDaoImpl();
		p.setTotalCount(rdi.getTotalCount(state));
		if (p.getPageCount() == 0) {
			p.setIndex(1);
		}else if (index > p.getPageCount()) {
			p.setIndex(p.getPageCount());
		}else if (index < 1) {
			p.setIndex(1);
		}else {
			p.setIndex(index);
		}
		p.setList(rdi.listSomeEmployee(state,p.getIndex(),p.getPageSize()));
		return p;
	}

	public Employee_Info listSomeEmployee(int id) {
		EmployeeDaoImpl rdi = new EmployeeDaoImpl();
		Employee_Info ei = rdi.listSomeEmployee(id);
		return ei;
	}

}
