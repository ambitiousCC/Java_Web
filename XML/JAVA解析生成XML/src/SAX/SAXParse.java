package SAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import SAXHandler.CCHandler;

public class SAXParse {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//创建工厂
		SAXParserFactory fac = SAXParserFactory.newInstance();
		//创建解析器
		SAXParser parser = fac.newSAXParser();
		//开始解析xml
		parser.parse("d://JavaWeb//XML//11.xml",new CCHandler());
		
	}
}	
