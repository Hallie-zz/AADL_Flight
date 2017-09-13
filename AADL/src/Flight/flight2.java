package Flight;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;


public class flight2 {

public static void main(String[] args) throws Exception{
	DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
 Document document=db.parse(new FileInputStream("F:\\text2.xml"));//把文件解析成DOCUMENT类型
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

NodeList root1 = root.getChildNodes(); 
for(int i=0;i<root1.getLength();i++){
	if(root1.item(i).getNodeType()==Node.ELEMENT_NODE){ 
	String cname=root1.item(i).getNodeName();   
	System.out.println("第一层子结点标记名："+cname);
	Element childNode=(Element)root1.item(i);
	String value1=childNode.getAttribute("name");
	System.out.println("子属性值："+value1);
	String value11=childNode.getAttribute("compType");
	System.out.println("子属性值："+value11);
}}
Element childNode1=(Element)root1.item(1);
NodeList root2 = childNode1.getChildNodes(); 
for(int i=0;i<root2.getLength();i++){
	if(root2.item(i).getNodeType()==Node.ELEMENT_NODE){ 
	String cname=root2.item(i).getNodeName();   
	System.out.println("第二层子结点标记名："+cname);
	Element childNode=(Element)root2.item(i);
	String value2=childNode.getAttribute("name");
	System.out.println("子属性值："+value2);
	String value21=childNode.getAttribute("compType");
	System.out.println("子属性值："+value21);
}}
Element childNode2=(Element)root2.item(1);
NodeList root3 = childNode2.getChildNodes(); 
for(int i=0;i<root3.getLength();i++){
	if(root3.item(i).getNodeType()==Node.ELEMENT_NODE){ 
	String cname=root3.item(i).getNodeName();   
	System.out.println("第三层子结点标记名："+cname);
	Element childNode=(Element)root3.item(i);
	String value3=childNode.getAttribute("name");
	System.out.println("子属性值："+value3);
	String value31=childNode.getAttribute("classifier");
	System.out.println("子属性值："+value31);
	System.out.println("classifier引用的"+value31+"不存在");
}}
}}