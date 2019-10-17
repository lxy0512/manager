package cn.boss.dao;

import java.util.List;

import cn.boss.pojo.Employee_Info;
/**
 * 
 * @author lxy
 *
 */
public interface IEmployeeDao {
	int getTotalCount(String state);
	List<Employee_Info> listSomeEmployee(String state,int index, int pageSize);
	Employee_Info listSomeEmployee(int id);
	int saveEmployee(Employee_Info ei);
	int updateEmployee(int id,String state);
	int removeEmployee(int id);
}
