package cn.boss.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.boss.dao.BaseDao;
import cn.boss.dao.IFinanceDao;
import cn.boss.pojo.Activity;
import cn.boss.pojo.Finance;

import javax.naming.NamingException;

public class FinanceDaoImpl implements IFinanceDao{

	public int insertFinanceAll(int id ,double income , double expend , double netincome , String direction , Date date) {
		int count = -1;
		PreparedStatement psta = null;
		try {
			String sql = "insert into finance value(?,?,?,?,?,?)";
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setInt(1, 0);
			psta.setDouble(2, income);
			psta.setDouble(3, expend);
			psta.setDouble(4, netincome);
			psta.setString(5, direction);
			psta.setDate(6, date);
			count = psta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeAll(null, psta);
		}

		return count;
	}

	public List<Finance> listFinanceAll() {
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<Finance> list = new ArrayList<Finance>();
		try {
			String sql = "select * from finance";
			psta = BaseDao.getConn().prepareStatement(sql);
			rs = psta.executeQuery();
			if(rs.next()){
				Finance f = new Finance();
				f.setFa_id(rs.getInt("fa_id"));
				f.setFa_income(rs.getDouble("fa_income"));
				f.setFa_expend(rs.getDouble("fa_expend"));
				f.setFa_direction(rs.getString("fa_direction"));
				f.setFa_time(rs.getDate("fa_time"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally{
			BaseDao.closeAll(rs, psta);
		}	
		return list;
	}

	public List<Activity> listActivityF(Date date) {
		PreparedStatement psta = null;
		ResultSet rs = null;
		Activity f = null;
		List<Activity> l = new ArrayList<Activity>();
		String sql = "select ac_money from activity where ac_time = ?";
		try {
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setDate(1, date);
			rs = psta.executeQuery();
			while(rs.next()){
				f= new Activity();
				f.setAc_money(rs.getDouble("ac_money"));
				f.setAc_time(date);
				l.add(f);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeAll(rs, psta);
		}
		return l;
	}
	public int dataTotal(int id,int income,int expend,int netincome,String direction,Date date){
		PreparedStatement psta = null;
		int count = -1;
		try {
			String sql = "insert into finance value(?,?,?,?,?,?)";
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setInt(1, 0);
			psta.setInt(2, income);
			psta.setInt(3, expend);
			psta.setInt(4, netincome);
			psta.setString(5, direction);
			psta.setDate(6, date);
			count = psta.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(null, psta);
		}
		return count;
	}

	public List<Activity> listFinanceADepartment(String department,int num1,int num2) {
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<Activity> list = new ArrayList<Activity>();
		try {
			String sql = "select ac_id,ac_money,ac_time,ac_number,sd_department,si_name,sp_name from activity left join store on si_id=ac_name left join storage_department on sd_id=ac_department left join store_shop on sp_id=ac_type where sd_department=? order by ac_time desc limit ?,?";
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setString(1, department);
			psta.setInt(2, (num1 - 1) * num2);
			psta.setInt(3, num2);
			rs = psta.executeQuery();
			while(rs.next()){
				Activity f = new Activity();
				f.setAc_id(rs.getInt("ac_id"));
				f.setSi_name(rs.getString("si_name"));
				f.setAc_time(rs.getDate("ac_time"));
				f.setSp_name(rs.getString("sp_name"));
				f.setAc_money(rs.getDouble("ac_money"));
				f.setAc_number(rs.getString("ac_number"));		
				f.setAc_department(rs.getString("sd_department"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally{
			BaseDao.closeAll(rs, psta);
		}
		return list;
	}

	public int listFinanceADepartmentNum(String department){
		PreparedStatement psta = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "select count(1) from activity left join storage_department on sd_id=ac_department where sd_department=?";
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setString(1, department);
			rs = psta.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeAll(rs, psta);
		}
		return count;
	}

	public List<Finance> listFinance(Date startdate,Date enddate) {
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<Finance> list = new ArrayList<Finance>();
		try {
			String sql = "select * from finance where fa_time between ? and ? order by fa_time desc";
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setDate(1, startdate);
			psta.setDate(2, enddate);
			rs = psta.executeQuery();
			while(rs.next()){
				Finance f = new Finance();
				f.setFa_id(rs.getInt("fa_id"));
				f.setFa_income(rs.getDouble("fa_income"));
				f.setFa_expend(rs.getDouble("fa_expend"));	
				f.setFa_netincome(rs.getDouble("fa_netincome"));
				f.setFa_direction(rs.getString("fa_direction"));
				f.setFa_time(rs.getDate("fa_time"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally{
			BaseDao.closeAll(rs, psta);
		}
		return list;
	}

	public List<Finance> listFinance2(Date startdate,Date enddate) {
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<Finance> list = new ArrayList<Finance>();
		try {
			String sql = "select * from finance where fa_time between ? and ? order by fa_time desc";
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setDate(1, startdate);
			psta.setDate(2, enddate);
			rs = psta.executeQuery();
			while(rs.next()){
				Finance f = new Finance();
				f.setFa_id(rs.getInt("fa_id"));
				f.setFa_income(rs.getDouble("fa_income"));
				f.setFa_expend(rs.getDouble("fa_expend"));	
				f.setFa_netincome(rs.getDouble("fa_netincome"));
				f.setFa_direction(rs.getString("fa_direction"));
				f.setFa_time(rs.getDate("fa_time"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeAll(rs, psta);
		}
		return list;
	}

	public List<Finance> listFinance3(Date startdate,Date enddate) {
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<Finance> list = new ArrayList<Finance>();
		try {
			String sql = "select * from finance where fa_time between ? and ? order by fa_time desc";
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setDate(1, startdate);
			psta.setDate(2, enddate);
			rs = psta.executeQuery();
			while(rs.next()){
				Finance f = new Finance();
				f.setFa_id(rs.getInt("fa_id"));
				f.setFa_income(rs.getDouble("fa_income"));
				f.setFa_expend(rs.getDouble("fa_expend"));	
				f.setFa_netincome(rs.getDouble("fa_netincome"));
				f.setFa_direction(rs.getString("fa_direction"));
				f.setFa_time(rs.getDate("fa_time"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeAll(rs, psta);
		}
		return list;
	}

	public int saveActivity(int id,int name, Date time,int type,double money,String number,int department){
		PreparedStatement psta = null;
		ResultSet rs = null;
		int count = -1;
		String sql = "insert into activity value(?,?,?,?,?,?,?)";
		try {
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setInt(1, 0);
			psta.setInt(2, name);
			psta.setDate(3, time);
			psta.setInt(4, type);
			psta.setDouble(5, money);
			psta.setString(6, number);
			psta.setInt(7, department);
			count = psta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally{
			BaseDao.closeAll(rs, psta);
		}
		return count;
	}

	public int getNameId(String name) {
		PreparedStatement psta = null;
		ResultSet rs = null;
		String sql = "select si_id from store where si_name =?";
		int id = -1;
		try {
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setString(1, name);
			System.out.println(psta);
			rs = psta.executeQuery();
			rs.next();
			id = rs.getInt("si_id");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeAll(rs, psta);
		}
		return id;
	}

	public int getTypeId(String type) {
		PreparedStatement psta = null;
		ResultSet rs = null;
		String sql = "select sp_id from store_shop where sp_name =?";
		int id = -1;
		try {
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setString(1, type);
			rs = psta.executeQuery();
			System.out.println(psta);
			rs.next();
			id = rs.getInt("sp_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally{
			BaseDao.closeAll(rs, psta);
		}
		return id;
	}
	public int getDepartmentId(String department){
		PreparedStatement psta = null;
		ResultSet rs = null;
		String sql = "select sd_id from storage_department where sd_department =?";
		int id = -1;
		try {
			psta = BaseDao.getConn().prepareStatement(sql);
			psta.setString(1, department);
			rs = psta.executeQuery();
			rs.next();
			id = rs.getInt("sd_id");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeAll(rs, psta);
		}
		return id;
	}
}
