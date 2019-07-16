package cache;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class loginCache {
	private static loginCache instance = new loginCache();
	
	//��¼��session�洢�������û��ڴ�
	private Map<String,String> loginUserSession = new HashMap<String,String>();
	private Map<String,HttpSession> loginSession = new HashMap<String,HttpSession>();
	
	private loginCache() {
		
	}
	
	public static loginCache getInstance() {
		//���浥��ģʽ
		return instance;
	}
	
	public String getSessionIdByUsername(String username) {
		return loginUserSession.get(username);
	}
	
	public HttpSession getSessionBySessionId(String sessionId) {
		return loginSession.get(sessionId);
	}
	
	public void setSessionIdByUserName(String username,String sessionId) {
		loginUserSession.put(username,sessionId);
	}
	
	public void setSessionIdBySessionId(HttpSession session,String sessionId) {
		loginSession.put(sessionId,session);
	}
}
