package listenerTest;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class attributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("added:"+scae.getName()+",value:"+scae.getValue()+"\n");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("remove:"+scae.getName()+",value:"+scae.getValue()+"\n");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("replaced:"+scae.getName()+",value:"+scae.getValue()+"\n");//�����õ�ֵ��Ȼ��֮ǰ��ֵ������ֵ�ĵ�ȷȷ�Ѿ����滻��
	}
	
}
