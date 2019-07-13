package SAX;

import java.io.File;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class BuildXMLMain {

	public static void main(String[] args) throws TransformerConfigurationException, SAXException {
		//��������XML���������
		Result resultXML = new StreamResult(new File("d://JavaWeb//XML//22.xml"));
		
		//��ȡ��sax���ɹ��������ʵ��
		SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		
		//��ȡ�����߶���
		TransformerHandler transformerHandler=saxTransformerFactory.newTransformerHandler();
		transformerHandler.setResult(resultXML);
		
		//������
		Transformer transformer = transformerHandler.getTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT,"yes");//����
		
		//�����ĵ���ʼ
		transformerHandler.startDocument();
		//����ֵ
		AttributesImpl attrlmpl = new AttributesImpl();		
		transformerHandler.startElement("", "", "��ѧ�ƻ�", attrlmpl);
		transformerHandler.startElement("", "", "����", attrlmpl);
		
		transformerHandler.startElement("", "", "�����γ�", attrlmpl);
		transformerHandler.startElement("", "", "�γ���", attrlmpl);
		
		transformerHandler.startElement("","","��ѧӢ��",attrlmpl);
		transformerHandler.startElement("","","��ʱ",attrlmpl);
		transformerHandler.characters("36".toCharArray(), 0, "36".length());
		transformerHandler.endElement("","","��ʱ");
		transformerHandler.startElement("","","���˷���",attrlmpl);
		transformerHandler.characters("����".toCharArray(), 0, "����".length());
		transformerHandler.endElement("","","���˷���");
		transformerHandler.endElement("", "", "��ѧӢ��");
		
		transformerHandler.startElement("","","�ߵ���ѧ",attrlmpl);
		transformerHandler.startElement("","","��ʱ",attrlmpl);
		transformerHandler.characters("70".toCharArray(), 0, "70".length());
		transformerHandler.endElement("","","��ʱ");
		transformerHandler.startElement("","","���˷���",attrlmpl);
		transformerHandler.characters("����".toCharArray(), 0, "����".length());
		transformerHandler.endElement("","","���˷���");
		transformerHandler.endElement("", "", "�ߵ���ѧ");
		
		transformerHandler.startElement("","","�����Ӧ�û���",attrlmpl);
		transformerHandler.startElement("","","��ʱ",attrlmpl);
		transformerHandler.characters("108".toCharArray(), 0, "108".length());
		transformerHandler.endElement("","","��ʱ");
		transformerHandler.startElement("","","���˷���",attrlmpl);
		transformerHandler.characters("�ϻ�����".toCharArray(), 0, "�ϻ�����".length());
		transformerHandler.endElement("","","���˷���");
		transformerHandler.endElement("", "", "�����Ӧ�û���");
		
		transformerHandler.startElement("","","������ͼ",attrlmpl);
		transformerHandler.startElement("","","��ʱ",attrlmpl);
		transformerHandler.characters("60".toCharArray(), 0, "60".length());
		transformerHandler.endElement("","","��ʱ");
		transformerHandler.startElement("","","���˷���",attrlmpl);
		transformerHandler.characters("����".toCharArray(), 0, "����".length());
		transformerHandler.endElement("","","���˷���");
		transformerHandler.endElement("", "", "������ͼ");
		
		transformerHandler.endElement("", "", "�γ���");
		transformerHandler.endElement("", "", "�����γ�");
		
		transformerHandler.startElement("", "", "רҵ��", attrlmpl);
		transformerHandler.startElement("", "", "�γ���", attrlmpl);
		
		transformerHandler.startElement("","","Java��������",attrlmpl);
		transformerHandler.startElement("","","��ʱ",attrlmpl);
		transformerHandler.characters("72".toCharArray(), 0, "72".length());
		transformerHandler.endElement("","","��ʱ");
		transformerHandler.startElement("","","���˷���",attrlmpl);
		transformerHandler.characters("����".toCharArray(), 0, "����".length());
		transformerHandler.endElement("","","���˷���");
		transformerHandler.endElement("", "", "Java��������");
		
		transformerHandler.startElement("","","MySQL���ݿ�����",attrlmpl);
		transformerHandler.startElement("","","��ʱ",attrlmpl);
		transformerHandler.characters("108".toCharArray(), 0, "108".length());
		transformerHandler.endElement("","","��ʱ");
		transformerHandler.startElement("","","���˷���",attrlmpl);
		transformerHandler.characters("����".toCharArray(), 0, "����".length());
		transformerHandler.endElement("","","���˷���");
		transformerHandler.endElement("", "", "MySQL���ݿ�����");
		
		transformerHandler.startElement("","","��ҳ���������",attrlmpl);
		transformerHandler.startElement("","","��ʱ",attrlmpl);
		transformerHandler.characters("74".toCharArray(), 0, "74".length());
		transformerHandler.endElement("","","��ʱ");
		transformerHandler.startElement("","","���˷���",attrlmpl);
		transformerHandler.characters("����".toCharArray(), 0, "����".length());
		transformerHandler.endElement("","","���˷���");
		transformerHandler.endElement("", "", "��ҳ���������");
		
		transformerHandler.endElement("", "", "�γ���");
		transformerHandler.endElement("", "", "רҵ��");
		

		transformerHandler.endElement("", "", "����");
		transformerHandler.endElement("", "", "��ѧ�ƻ�");
		transformerHandler.endDocument();
		//����
		System.out.println("�ĵ�����ɹ�");
	}

}
