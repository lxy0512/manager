package cn.boss.dao;

import java.sql.Date;
import java.util.List;

import cn.boss.pojo.Activity;
import cn.boss.pojo.Finance;

public interface IFinanceDao {
	/**
	 * �������������Ϣ 
	 * @param id ���
	 * @param income ����
	 * @param expend ֧��
	 * @param netincome ������
	 * @param direction	��ϸ
	 * @param startdate ��ʼʱ��
	 * @param enddate ����ʱ��
	 * @return ��Ӱ������
	 */
	int insertFinanceAll(int id ,double income , double expend , double netincome , String direction , Date date);
	/**
	 * ��������Ÿ�¼��Ϣ
	 * @param id ���
	 * @param name ����
	 * @param date ����
	 * @param type ��Ʒ����
	 * @param money ���
	 * @param number ���
	 * @return ��Ӱ������
	 */
	int saveActivity(int id,int name, Date time,int type,double money,String number,int department);
	
	int getNameId(String name);
	
	int getTypeId(String type);
	
	int getDepartmentId(String department);
	/**
	 * ��ѯ������Ϣ��ȫ������
	 * @return list����,����˳��Ϊ ���|����|֧��|������|����|��ʼʱ���|����ʱ���
	 */
	List<Finance> listFinanceAll();
	
	int dataTotal(int id,int income,int expend,int netincome,String direction,Date date);
	/**
	 * ��Ѱactivity��ĳʱ��������,����ͳ��,��дfinance��
	 * @param date
	 * @return list����,����˳��Ϊ ���׽��|ʱ��
	 */
	List<Activity> listActivityF(Date date);
	 
	/**
	 * ��ѯactivityĳ�������ڵ�num2������
	 * @param department ����
	 * @param startdate ��ʼʱ��
	 * @param enddate ����ʱ��
	 * @return list����,����˳��Ϊ ����|����|���׽��|ʱ��|����
	 */
	List<Activity> listFinanceADepartment(String department,int num1, int num2);
	/**
	 * ��Ѱactivity��ĳʱ��ε�����
	 * @param date
	 * @return list����,����˳��Ϊ ����|���׽��|ʱ��|��Ʒ����|����
	 */
	List<Finance> listFinance(Date startdate,Date enddate);
	
	List<Finance> listFinance2(Date startdate,Date enddate);
	
	List<Finance> listFinance3(Date startdate,Date enddate);
	
	int listFinanceADepartmentNum(String department);
}
