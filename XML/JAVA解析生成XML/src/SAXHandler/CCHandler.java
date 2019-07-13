package SAXHandler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CCHandler extends DefaultHandler {
	//��������������ڴ����tag
	private String currentTag;
	
	@Override
	public void characters(char[] ch, int start, int len) throws SAXException {
		// TODO Auto-generated method stub
		String content = new String(ch,start,len);
		if(content.trim().length()>0) {
			System.out.println("<"+currentTag+">Ԫ�ص�ֵ��"+content.trim());
		}
	}

	//�����ĵ�����
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("�����ĵ�����");
	}

	//����Ԫ�ؽ���
	@Override
	public void endElement(String url, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub

		System.out.println("����<"+qName+">Ԫ�ؽ���");
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("�����ĵ���ʼ");
	}

	//����Ԫ�ؿ�ʼ
	@Override
	public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//��ǰ��Ԫ��ֵ
		currentTag = qName;
		System.out.println("����Ԫ��<"+qName+">��ʼ");
		//���Ԫ��������ֵ
		if(attributes.getLength()>0) {
			System.out.println("<"+currentTag+">Ԫ����������");
			for(int i = 0; i < attributes.getLength();i++) {
				System.out.println(attributes.getQName(i)+"-->"+attributes.getValue(i));
			}
		}
	}

}
