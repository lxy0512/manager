package test;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.boss.dao.BaseDao;
import cn.boss.dao.impl.EmployeeDaoImpl;
import cn.boss.dao.impl.RepairDaoImpl;
import cn.boss.dao.impl.StoreDaoImpl;
import cn.boss.pojo.Employee_Info;
import cn.boss.pojo.Repair;
import cn.boss.pojo.Store;
import cn.boss.service.impl.EmployeeServiceImpl;
import cn.boss.service.impl.StoreServiceImpl;

import javax.naming.NamingException;

public class Test {
	public static void main(String[] args) throws SQLException, NamingException {
		BaseDao.getConn();
		System.out.println(1);
		EmployeeServiceImpl esi = new EmployeeServiceImpl();
		Employee_Info ei = esi.listSomeEmployee(1);
		System.out.println(ei.getEy_name());
	}
}
