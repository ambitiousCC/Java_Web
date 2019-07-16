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
		System.out.println("replaced:"+scae.getName()+",value:"+scae.getValue()+"\n");//这里获得的值仍然是之前的值，但是值的的确确已经被替换了
	}
	
}
