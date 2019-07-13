package SAXHandler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CCHandler extends DefaultHandler {
	//定义变量保存正在处理的tag
	private String currentTag;
	
	@Override
	public void characters(char[] ch, int start, int len) throws SAXException {
		// TODO Auto-generated method stub
		String content = new String(ch,start,len);
		if(content.trim().length()>0) {
			System.out.println("<"+currentTag+">元素的值是"+content.trim());
		}
	}

	//解析文档结束
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("解析文档结束");
	}

	//解析元素结束
	@Override
	public void endElement(String url, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub

		System.out.println("处理<"+qName+">元素结束");
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("解析文档开始");
	}

	//解析元素开始
	@Override
	public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//当前的元素值
		currentTag = qName;
		System.out.println("处理元素<"+qName+">开始");
		//如果元素有属性值
		if(attributes.getLength()>0) {
			System.out.println("<"+currentTag+">元素属性如下");
			for(int i = 0; i < attributes.getLength();i++) {
				System.out.println(attributes.getQName(i)+"-->"+attributes.getValue(i));
			}
		}
	}

}
