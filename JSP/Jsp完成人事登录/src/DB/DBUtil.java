package DB;

import java.util.*;
import loginBean.*;

public class DBUtil {
	//ģ�����ݿ�洢���ݣ������ж��Ƿ�����ȷ������
	public static Map<String,emp> map= new HashMap<String,emp>(); 
	//���þ�̬��ʼ�����ʼ��
	static {//eclipse ����������������Ļ��������
		map.put("101",new emp("101","123456","101@qq.com","cc"));
		map.put("102",new emp("102","888888","102@qq.com","xx"));
		map.put("103",new emp("103","654321","103@qq.com","ww"));
		map.put("104",new emp("104","000000","104@qq.com","tt"));
	}
	
	public static boolean selectEmpByAccountAndPassword(emp emp) {
		boolean flag = false;
		for(String key : map.keySet()) {
			//��һ�ȶ�
			emp e = map.get(key);
			if(e.getAccount().equals(emp.getAccount())
					&& e.getPassword().equals(emp.getPassword())) {
				flag = true;
			}
		}
		return flag;
	}
}
