package cn.boss.dao;

import java.util.List;

import cn.boss.pojo.Repair;
/**
 * 
 * @author lxy
 *
 */
public interface IRepairDao {
	int getTotalCount();
	List<Repair> listRepair(int index, int pageSize);
	int saveRepair(Repair r);
	int updateRepair(int id, String state);
}
