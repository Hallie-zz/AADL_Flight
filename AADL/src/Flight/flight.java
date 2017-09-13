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
 Document document=db.parse(new FileInputStream("F:\\test1.xml"));//���ļ�������DOCUMENT����
 Element root = document.getDocumentElement();  //�õ�Document�ĸ����ڵ�������
 System.out.println("���ڵ�������" + root.getTagName());  
 System.out.println("*****�������XMLԪ��*****");
 NamedNodeMap attris=root.getAttributes();
 String  save[ ] = new String[10];    
 for(int j=0;j<attris.getLength();j++){
	 Node attri=attris.item(j);
	 String attriName=attri.getNodeName();
	 System.out.println("��������"+attriName);
	 String attriValue=attri.getNodeValue();
	 save[j]=attriValue;
	 System.out.println("����ֵ��"+attriValue);
 }

NodeList childNodes = root.getChildNodes(); 
for(int i=0;i<childNodes.getLength();i++){
	if(childNodes.item(i).getNodeType()==Node.ELEMENT_NODE){ 
	String cname=childNodes.item(i).getNodeName();   
	System.out.println("�ӽ��������"+cname);
	Element childNode=(Element)childNodes.item(i);
	//String name=
	//System.out.println("����������"+name);
	String value=childNode.getAttribute("name");
	System.out.println("������ֵ��"+value);
    String temp[] = value.split("\\.");   
	for(int j=0;j<attris.getLength();j++)
	{		if(temp[0].equals(save[j])==false)
				System.out.println(value+"�е�"+temp[0]+"���Ͳ����ڣ������޸�Ϊ"+save[j]+"."+temp[1]);
	}
	String value1=childNode.getAttribute("compType");
	System.out.println("������ֵ��"+value1);
	if(value.equals(value1)==false)
		System.out.println("compType���õ��������"+value1+"��"+temp[0]+"����ͬ");
}}
}}