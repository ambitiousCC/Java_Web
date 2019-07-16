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
		
		//����������һ����¼��(����)
		if(LOGIN_USER.equals(attrName)) {
			//���session���Թ�����
			String attrVal = (String)hsbe.getValue();
			HttpSession session = hsbe.getSession();
			//sessionΨһ�ı�ʶ
			String sessionId = session.getId();
			
			//ͨ����¼�����sessionId
			String sessionId2 = loginCache.getInstance().getSessionIdByUsername(attrVal);
			if(null==sessionId2) {
				
			} else {
				//���ظ���¼����Ҫͨ��sessionId��ȡsession2
				HttpSession session2 = loginCache.getInstance().getSessionBySessionId(sessionId2);
				//����֮ǰ��session��ֵ
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
