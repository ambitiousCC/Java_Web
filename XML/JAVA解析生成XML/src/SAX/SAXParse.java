package SAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import SAXHandler.CCHandler;

public class SAXParse {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//��������
		SAXParserFactory fac = SAXParserFactory.newInstance();
		//����������
		SAXParser parser = fac.newSAXParser();
		//��ʼ����xml
		parser.parse("d://JavaWeb//XML//11.xml",new CCHandler());
		
	}
}	
