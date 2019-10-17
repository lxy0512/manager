package cn.boss.service;

import java.util.List;

import cn.boss.pojo.Repair;
import cn.boss.util.Page;

public interface IRepairService {
	
//	 List<Repair> listRepair();
	 
	 int saveRepair(Repair r);
	 
	 int updateRepair(int id, String state);
	 Page getPage(int index, int pageSize);
}