package cn.boss.service.impl;

import java.util.List;

import cn.boss.dao.impl.EmployeeDaoImpl;
import cn.boss.dao.impl.RepairDaoImpl;
import cn.boss.pojo.Repair;
import cn.boss.service.IRepairService;
import cn.boss.util.Page;

public class RepairServiceImpl implements IRepairService{

	@Override
	public int saveRepair(Repair r) {
		RepairDaoImpl rdi = new RepairDaoImpl();
		r.setRi_floor(1);
		r.setRi_state(1);
		r.setRi_store(1);
		r.setRi_type(1);
		int count = rdi.saveRepair(r);
		if (count > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateRepair(int id, String state) {
		RepairDaoImpl rdi = new RepairDaoImpl();
		int count = rdi.updateRepair(id, state);
		if (count > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public Page getPage(int index, int pageSize) {
		Page p = new Page();
		p.setPageSize(pageSize);
		RepairDaoImpl rdi = new RepairDaoImpl();
		p.setTotalCount(rdi.getTotalCount());
		if (p.getPageCount() == 0) {
			p.setIndex(1);
		}else if (index > p.getPageCount()) {
			p.setIndex(p.getPageCount());
		}else if (index < 1) {
			p.setIndex(1);
		}else {
			p.setIndex(index);
		}
		p.setRlist(rdi.listRepair(p.getIndex(),p.getPageSize()));
		return p;
	}
	
}
