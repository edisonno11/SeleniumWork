package com.dreamworks.selenium.utillab;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * @class: XmlReaderByDom4J
 * @author Morgan
 * @desc: Reference for how to get xml data by Dom4J
 * @date: 2015/12/16
 */

public class XmlReaderByDom4J {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		XmlReaderByDom4J xmlreaderbydom4j = new XmlReaderByDom4J();
	}
	
	/**
	 * @function_desc 
	 * @date: 2015/12/17
	 * @param strFilePath
	 * @return node
	 * @throws Exception
	 */
	public Element getNode(String strFilePath) throws Exception{
		strFilePath = "SeleniumAdditional/OR/LoginPage.xml";
		 // Creat saxReader object  
        SAXReader reader = new SAXReader();  
        // Read the xml file and convert to document object
        Document document = reader.read(new File(strFilePath));
        //Get root node element 
        Element node = document.getRootElement();
        return node;
	}
	
	
	/**
	 * @desc: How to get xml data by several methods
	 * @date: 2015/12/16
	 * @throws Exception
	 */
	public XmlReaderByDom4J() throws Exception {
		// call getNode method and get the node object
		Element node = getNode("SeleniumAdditional/OR/LoginPage.xml");
  
        /* 1. Get specified node element and attribute
        //Specify node name
        Element e = node.element("OR");
        //Specify subNode name
        Element strXpath = e.element("xpath");
        // Define list for xpath node
        List<Element> list = e.elements("xpath");
        for(Element ele:list){
        	System.out.println(ele.getText());
        	List<Attribute> attList = ele.attributes();
        	for(Attribute att:attList){
        		System.out.println(att.getName()+"----"+att.getText());
        	}
        }
        */
		
		/* 2. Use Iterator to get element and attribute
        Iterator IT = node.elementIterator();
        // loop element in the IT object
        while(IT.hasNext()){
        	Element element = (Element)IT.next();
        	System.out.println(element.getName());
        	
        	//Get the subElement for IT
        	Iterator eleIT = element.elementIterator();
        	while(eleIT.hasNext()){
        		Element e = (Element)eleIT.next();
        		System.out.println(e.getName()+"----"+e.getText());
        	}
        	//Get attribute
        	Iterator attIT = element.attributeIterator();
        	while(attIT.hasNext()){
        		Attribute att = (Attribute)attIT.next();	
        	}      	
        }
        */
                
        /* 3.use Element to read data
        List<Element> childElement = node.elements();
        for(Element child:childElement){
        	System.out.println(child.getName()+"----"+child.getText());
        	System.out.println();
        	List<Attribute> childAttribute = child.attributes();
        	for(Attribute attr: childAttribute){
        		System.out.println(attr.getName()+"----"+attr.getValue());
        	}
        }
        */
		
        /* 4.Ergodic all item element  
        listNodes(node); 
        */     
	}
	
	/**
	 * @desc: Get all node element and attribute
	 * @author Morgan
	 * @param node
	 * @date: 2015/12/16
	 */
	public void listNodes(Element node){
		System.out.println("Current node:"+node.getName());
		//Get all arrtibute of nodes of current node
		List<Attribute> list = node.attributes();
		
		for(Attribute att:list){
			System.out.println(att.getText()+"----"+att.getName()+"----"+att.getValue());
		}
		
		if(!node.getTextTrim().equals("")){
			System.out.println("Text comments£º"+node.getText());
		}
		
		// Subnode Iterator of currect node  
        Iterator<Element> it = node.elementIterator();  
        // Ergodic
        while (it.hasNext()) {  
            // Get subnode object  
            Element e = it.next();  
            // Ergodic subnode  
            listNodes(e);  
        } 
	}

}
