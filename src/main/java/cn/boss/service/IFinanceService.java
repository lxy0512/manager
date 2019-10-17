package cn.boss.service;

import java.util.List;

import cn.boss.pojo.ActivityLimit;
import cn.boss.pojo.Finance;

public interface IFinanceService {
	/**
	 * ����finance����
	 * @param id
	 * @param income
	 * @param expend
	 * @param netincome
	 * @param direction
	 * @param startdate
	 * @param enddate
	 * @return �����ַ���������ɹ���ʧ��
	 */
	String insertFinance(String id ,String income , String expend , String netincome , String direction , String date);
	/**
	 * ����activity����
	 * @param id
	 * @param name
	 * @param date
	 * @param type
	 * @param money
	 * @param number
	 * @return �����ַ���������ɹ���ʧ��
	 */
	String insertActivity(String id,String name,String date,String type,String money,String number,String department);
	/**
	 * ��ȡfinanceȫ������
	 * @return �������ݼ���
	 */
	List<Finance> listFinanceAll();
	/**
	 * ���ϼ�¼�������,���м���,��������
	 * @return �����ַ������ɹ���ʧ��
	 */
	String dataTotal(String date,String direction);
	/**
	 * ��ȡactivityĳ������ĳʱ��ε�����
	 * @param department
	 * @param startdate
	 * @param enddate
	 * @return �������ݼ���
	 */
	ActivityLimit listFinanceADepartment(String department,int num1, int num2);
	/**
	 * ��ȡfinanceĳʱ��ε�����
	 * @param startdate
	 * @param enddate
	 * @return �������ݼ���
	 */
	List<Finance> listFinanceDate(String startdate,String enddate);
}
