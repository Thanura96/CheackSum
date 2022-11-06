import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFileUsingDOM {

	public static void main(String[] args) {
		try 
		{
			File xmlDoc = new File("cheacksum.xml");
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			Document doc = (Document) dBuild.parse(xmlDoc);
			
		
			
			//Read root element
			//                                   doc locate root           give me its name
			System.out.println("Root element:" + doc.getDocumentElement().getNodeName());
			
			//read array of PaymentItem
			//this array is called NodeList
			NodeList nList = doc.getElementsByTagName("PaymentItem");
			
			for(int i=0;i<nList.getLength();i++) 
			{
				Node nNode = nList.item(i);
				System.out.println("Node name: " + nNode.getNodeName() + " " + (i+1));
				if(nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) nNode;
					System.out.println("DIN Value: " + eElement.getElementsByTagName("DIN").item(0).getTextContent());
					System.out.println("Amount Value: " + eElement.getElementsByTagName("Amount").item(0).getTextContent());
					
				  
					
				}
				
			}
		}
		catch(Exception e) {}
	}

}
