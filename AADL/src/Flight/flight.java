package Flight;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;


public class flight {

public static void main(String[] args) throws Exception{
	DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
 Document document=db.parse(new FileInputStream("F:\\test1.xml"));//把文件解析成DOCUMENT类型
 Element root = document.getDocumentElement();  //得到Document的根（节点名：）
 System.out.println("根节点标记名：" + root.getTagName());  
 System.out.println("*****下面遍历XML元素*****");
 NamedNodeMap attris=root.getAttributes();
 String  save[ ] = new String[10];    
 for(int j=0;j<attris.getLength();j++){
	 Node attri=attris.item(j);
	 String attriName=attri.getNodeName();
	 System.out.println("属性名："+attriName);
	 String attriValue=attri.getNodeValue();
	 save[j]=attriValue;
	 System.out.println("属性值："+attriValue);
 }

NodeList childNodes = root.getChildNodes(); 
for(int i=0;i<childNodes.getLength();i++){
	if(childNodes.item(i).getNodeType()==Node.ELEMENT_NODE){ 
	String cname=childNodes.item(i).getNodeName();   
	System.out.println("子结点标记名："+cname);
	Element childNode=(Element)childNodes.item(i);
	//String name=
	//System.out.println("子属性名："+name);
	String value=childNode.getAttribute("name");
	System.out.println("子属性值："+value);
    String temp[] = value.split("\\.");   
	for(int j=0;j<attris.getLength();j++)
	{		if(temp[0].equals(save[j])==false)
				System.out.println(value+"中的"+temp[0]+"类型不存在，建议修改为"+save[j]+"."+temp[1]);
	}
	String value1=childNode.getAttribute("compType");
	System.out.println("子属性值："+value1);
	if(value.equals(value1)==false)
		System.out.println("compType引用的组件类型"+value1+"与"+temp[0]+"不相同");
}}
}}