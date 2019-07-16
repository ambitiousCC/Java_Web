package listenerTest;

import java.sql.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class httpSessionTest implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		String sessionId = hse.getSession().getId();
		Date createTime = new Date(hse.getSession().getCreationTime());
		System.out.print("setId:"+sessionId+",createTime:"+createTime);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		String sessionId = hse.getSession().getId();
		System.out.println("destoryed,session id:"+sessionId);
	}

}
