package cn.boss.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.boss.dao.BaseDao;
import cn.boss.dao.IRepairDao;
import cn.boss.pojo.Repair;

public class RepairDaoImpl implements IRepairDao{

	@Override
	public List<Repair> listRepair(int index, int pageSize) {
		String sql = "select ri_id,ri_name,l_floor,rs_state,si_name,ri_time,rt_type,ri_describe from repair,location,repair_state,repair_type,store WHERE ri_floor=l_id AND ri_state=rs_id AND ri_type=rt_id AND ri_store=si_id limit ?,?;";
		PreparedStatement pstat = null;
		ResultSet rs= null;
		List<Repair> rlist = new ArrayList<Repair>();
		try {
			pstat = BaseDao.getConn().prepareStatement(sql);
			pstat.setInt(1, (index-1) * pageSize);
			pstat.setInt(2, pageSize);
			rs = pstat.executeQuery();
			while(rs.next()){
				Repair r = new Repair();
				r.setRi_id(rs.getInt("ri_id"));
				r.setRi_name(rs.getString("ri_name"));
				r.setRepair_state(rs.getString("rs_state"));
				r.setSi_name(rs.getString("si_name"));
				r.setRi_time(rs.getDate("ri_time"));
				r.setRepair_type(rs.getString("rt_type"));
				r.setLocation(rs.getString("l_floor"));
				r.setRi_describe(rs.getString("ri_describe"));
				rlist.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeAll(rs, pstat);
		}
		return rlist;
	}

	@Override
	public int saveRepair(Repair r) {
		PreparedStatement pstat = null;
		int count = -1;
		try {
			String sql = "insert into repair(ri_id,ri_name,ri_floor,ri_state,ri_store,ri_time,ri_type,ri_describe) values(?,?,?,?,?,?,?,?);";
			pstat = BaseDao.getConn().prepareStatement(sql);
			pstat.setInt(1, r.getRi_id());
			pstat.setString(2, r.getRi_name());
			pstat.setInt(3, r.getRi_floor());
			pstat.setInt(4, r.getRi_state());
			pstat.setInt(5, r.getRi_store());
			pstat.setDate(6, r.getRi_time());
			pstat.setInt(7, r.getRi_type());
			pstat.setString(8, r.getRi_describe());
			count = pstat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, pstat);
		}
		return count;
	}

	@Override
	public int updateRepair(int id, String state) {
		PreparedStatement pstat = null;
		int count = -1;
		try {
			String sql = "UPDATE repair,repair_state set ri_state=rs_id where ri_id=? and rs_state=?;";
			pstat = BaseDao.getConn().prepareStatement(sql);
			pstat.setInt(1, id);
			pstat.setString(2, state);
			count = pstat.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, pstat);
		}
		return count;
	}

	@Override
	public int getTotalCount() {
		ResultSet rs = null;
		int count = -1;
		try {
			String sql = "select count(1) from repair;";
			rs = BaseDao.getConn().prepareStatement(sql).executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(rs, null);
		}
		return count;
	}
}
