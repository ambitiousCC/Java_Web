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
		//创建保存XML结果流对象
		Result resultXML = new StreamResult(new File("d://JavaWeb//XML//22.xml"));
		
		//获取由sax生成工厂对象的实例
		SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		
		//获取处理者对象
		TransformerHandler transformerHandler=saxTransformerFactory.newTransformerHandler();
		transformerHandler.setResult(resultXML);
		
		//生成器
		Transformer transformer = transformerHandler.getTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT,"yes");//编码
		
		//生成文档开始
		transformerHandler.startDocument();
		//属性值
		AttributesImpl attrlmpl = new AttributesImpl();		
		transformerHandler.startElement("", "", "教学计划", attrlmpl);
		transformerHandler.startElement("", "", "分类", attrlmpl);
		
		transformerHandler.startElement("", "", "基础课程", attrlmpl);
		transformerHandler.startElement("", "", "课程名", attrlmpl);
		
		transformerHandler.startElement("","","大学英语",attrlmpl);
		transformerHandler.startElement("","","课时",attrlmpl);
		transformerHandler.characters("36".toCharArray(), 0, "36".length());
		transformerHandler.endElement("","","课时");
		transformerHandler.startElement("","","考核方法",attrlmpl);
		transformerHandler.characters("考试".toCharArray(), 0, "考试".length());
		transformerHandler.endElement("","","考核方法");
		transformerHandler.endElement("", "", "大学英语");
		
		transformerHandler.startElement("","","高等数学",attrlmpl);
		transformerHandler.startElement("","","课时",attrlmpl);
		transformerHandler.characters("70".toCharArray(), 0, "70".length());
		transformerHandler.endElement("","","课时");
		transformerHandler.startElement("","","考核方法",attrlmpl);
		transformerHandler.characters("考试".toCharArray(), 0, "考试".length());
		transformerHandler.endElement("","","考核方法");
		transformerHandler.endElement("", "", "高等数学");
		
		transformerHandler.startElement("","","计算机应用基础",attrlmpl);
		transformerHandler.startElement("","","课时",attrlmpl);
		transformerHandler.characters("108".toCharArray(), 0, "108".length());
		transformerHandler.endElement("","","课时");
		transformerHandler.startElement("","","考核方法",attrlmpl);
		transformerHandler.characters("上机操作".toCharArray(), 0, "上机操作".length());
		transformerHandler.endElement("","","考核方法");
		transformerHandler.endElement("", "", "计算机应用基础");
		
		transformerHandler.startElement("","","工程制图",attrlmpl);
		transformerHandler.startElement("","","课时",attrlmpl);
		transformerHandler.characters("60".toCharArray(), 0, "60".length());
		transformerHandler.endElement("","","课时");
		transformerHandler.startElement("","","考核方法",attrlmpl);
		transformerHandler.characters("考查".toCharArray(), 0, "考查".length());
		transformerHandler.endElement("","","考核方法");
		transformerHandler.endElement("", "", "工程制图");
		
		transformerHandler.endElement("", "", "课程名");
		transformerHandler.endElement("", "", "基础课程");
		
		transformerHandler.startElement("", "", "专业课", attrlmpl);
		transformerHandler.startElement("", "", "课程名", attrlmpl);
		
		transformerHandler.startElement("","","Java基础入门",attrlmpl);
		transformerHandler.startElement("","","课时",attrlmpl);
		transformerHandler.characters("72".toCharArray(), 0, "72".length());
		transformerHandler.endElement("","","课时");
		transformerHandler.startElement("","","考核方法",attrlmpl);
		transformerHandler.characters("考试".toCharArray(), 0, "考试".length());
		transformerHandler.endElement("","","考核方法");
		transformerHandler.endElement("", "", "Java基础入门");
		
		transformerHandler.startElement("","","MySQL数据库入门",attrlmpl);
		transformerHandler.startElement("","","课时",attrlmpl);
		transformerHandler.characters("108".toCharArray(), 0, "108".length());
		transformerHandler.endElement("","","课时");
		transformerHandler.startElement("","","考核方法",attrlmpl);
		transformerHandler.characters("考试".toCharArray(), 0, "考试".length());
		transformerHandler.endElement("","","考核方法");
		transformerHandler.endElement("", "", "MySQL数据库入门");
		
		transformerHandler.startElement("","","网页设计与制作",attrlmpl);
		transformerHandler.startElement("","","课时",attrlmpl);
		transformerHandler.characters("74".toCharArray(), 0, "74".length());
		transformerHandler.endElement("","","课时");
		transformerHandler.startElement("","","考核方法",attrlmpl);
		transformerHandler.characters("考查".toCharArray(), 0, "考查".length());
		transformerHandler.endElement("","","考核方法");
		transformerHandler.endElement("", "", "网页设计与制作");
		
		transformerHandler.endElement("", "", "课程名");
		transformerHandler.endElement("", "", "专业课");
		

		transformerHandler.endElement("", "", "分类");
		transformerHandler.endElement("", "", "教学计划");
		transformerHandler.endDocument();
		//结束
		System.out.println("文档输出成功");
	}

}
