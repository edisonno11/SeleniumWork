package com.dreamworks.selenium.JUnitTests;

import static org.junit.Assert.*;

//import java.io.File;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.dreamworks.selenium.businessLib.Basis;
//import com.dreamworks.selenium.driver.CustomClassLoader;

//import org.apache.commons.collections.map.LinkedMap;
//import org.dom4j.Attribute;
//import org.dom4j.Document;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;

public class BasisTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testGetTestFlow()  throws Exception{
//		
//		CustomClassLoader cl = new CustomClassLoader();
//		
//		System.out.println("start");
//		
//        SAXReader reader = new SAXReader();  
//        LinkedMap map = new LinkedMap();
//        Document document = reader.read(new File("SeleniumAdditional/BusinessFlow/SampleTestCase.xml"));
//        System.out.println("Load XML file successfully");  
//        Element node = document.getRootElement();
//        Iterator IT = node.elementIterator();               
//        while (IT.hasNext()) {
//        	Element element = (Element)IT.next();
//        	map.put(element.getData(),element.attributeValue("class"));        	        	        	
//		}
//        
//        Iterator ITMap = map.entrySet().iterator();
//    	while (ITMap.hasNext()) {
//    		Map.Entry entry =(Map.Entry) ITMap.next();
//    		String key = entry.getKey().toString();
//    		String value = entry.getValue().toString();    		    		    	
//    		System.out.println(key);
//    		System.out.println(value);
//    		cl.Load(value, key);
//		}
//		
//		//fail("Not yet implemented");
//	}
//	
//	

	
	
	@Test
	public void testCustomMap() throws Exception{
		
		
		Basis basis = new Basis();
		
		//List<customMap> list = new LinkedList<customMap>();  
//		list.add( new customMap("key1","value1"));
//		list.add( new customMap("key1","value1"));
//		list.add( new customMap("key2","value2"));
		basis.getTestData("SeleniumAdditional/TestData/SampleTestCaseTestData.xml");
		//list = basis.loadDataFromXML("SeleniumAdditional/Driver.xml", "executionFlag","");		//		
		System.out.println(Basis.DataEngine.get("LoginURL").toString());	
		
		
		
		
		
		
		
	}
}
