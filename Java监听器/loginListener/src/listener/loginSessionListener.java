package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cache.loginCache;

public class loginSessionListener implements HttpSessionAttributeListener{
	private static final String LOGIN_USER="loginUser";

	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		String attrName = hsbe.getName();
		
		//如果是添加了一个登录的(属性)
		if(LOGIN_USER.equals(attrName)) {
			//添加session属性功能来
			String attrVal = (String)hsbe.getValue();
			HttpSession session = hsbe.getSession();
			//session唯一的标识
			String sessionId = session.getId();
			
			//通过登录名获得sessionId
			String sessionId2 = loginCache.getInstance().getSessionIdByUsername(attrVal);
			if(null==sessionId2) {
				
			} else {
				//有重复登录，需要通过sessionId获取session2
				HttpSession session2 = loginCache.getInstance().getSessionBySessionId(sessionId2);
				//清理之前的session的值
				session2.invalidate();
			}
			
			loginCache.getInstance().setSessionIdByUserName(attrVal,sessionId);
			loginCache.getInstance().setSessionIdBySessionId(session, sessionId);
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		
	}
	
}
