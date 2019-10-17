package cn.boss.service.impl;

import cn.boss.dao.impl.ChangeDaoImpl;
import cn.boss.service.IChangeService;

public class ChangeServiceImpl implements IChangeService {

	public int changePwd(String password, String username) {
		ChangeDaoImpl cd = new ChangeDaoImpl();
		int i = cd.changPwd(password, username);
		System.out.println(i);
		if(i > 0){
			return 1;
		}else{
			return 0;
		}
	}
}
