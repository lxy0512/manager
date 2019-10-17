package cn.boss.test;

import cn.boss.dao.impl.MemberDaoImpl;

public class Test {
	public static void main(String[] args) {
		MemberDaoImpl msi = new MemberDaoImpl();
		System.out.println(msi.saveVip(null));
	}
}
