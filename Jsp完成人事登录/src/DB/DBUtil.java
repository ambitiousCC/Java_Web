package DB;

import java.util.*;
import loginBean.*;

public class DBUtil {
	//模拟数据库存储数据，包括判断是否是正确的数据
	public static Map<String,emp> map= new HashMap<String,emp>(); 
	//利用静态初始化块初始化
	static {//eclipse 内置浏览器传递中文会出错，气人
		map.put("101",new emp("101","123456","101@qq.com","cc"));
		map.put("102",new emp("102","888888","102@qq.com","xx"));
		map.put("103",new emp("103","654321","103@qq.com","ww"));
		map.put("104",new emp("104","000000","104@qq.com","tt"));
	}
	
	public static boolean selectEmpByAccountAndPassword(emp emp) {
		boolean flag = false;
		for(String key : map.keySet()) {
			//逐一比对
			emp e = map.get(key);
			if(e.getAccount().equals(emp.getAccount())
					&& e.getPassword().equals(emp.getPassword())) {
				flag = true;
			}
		}
		return flag;
	}
}
