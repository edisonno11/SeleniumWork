package com.dreamworks.selenium.businessLib;
import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.io.FileUtils;
//import org.dom4j.Attribute;
import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
import org.dom4j.Element;
//import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
//import org.dom4j.io.XMLWriter;

public class Basis extends Observable 
{
		
	public static WebDriver WD;	
	public static LinkedMap DataEngine = new LinkedMap();
	public static List<customMap> TestFlowStorage = new LinkedList<customMap>();
	public static List<customMap> TestCasesStorage = new LinkedList<customMap>();
	public static Document TestReport;
	public static LinkedMap OR = new LinkedMap();
	/**
	 * 
	 * @param path xml location eg. c:\asdf\bbb.xml or SeleniumAdditional/Driver.xml
	 * @param customattribute xml node attribute eg. executionflag and so on
	 * @return null
	 * @throws Exception
	 * @desc load and parse xml file , and output them as an ordered FIFO map
	 * @author xieyid
	 */
	public List<customMap> loadDataFromXML(String path, String...args) throws Exception{
		List<customMap> map = new LinkedList<customMap>();				
		SAXReader reader = new SAXReader();  	        
	    Document document = reader.read(new File(path));
	    Element node = document.getRootElement();
	    String key;

	    for (String s: args){
	    	Iterator<?> IT = node.elementIterator();
	    	while (IT.hasNext()) {
		    	Element element = (Element)IT.next();
		    	key = element.attributeValue(s);
		    	if (!key.toLowerCase().equals("false")) {
		    		map.add(new customMap(element.attributeValue(s),element.getData().toString()));
				}		    				
			}	
	    	
	    }
	    
		return map;
	}	
	
	/**
	 * 
	 * @throws Exception
	 * @desc get test case map
	 * @author xieyid 
	 */	
	public void getTestCase() throws Exception{
		System.out.println("Start Load  Cases");
		List<customMap> map = new LinkedList<customMap>();				
		SAXReader reader = new SAXReader();  	        
	    Document document = reader.read(new File("SeleniumAdditional/Driver.xml"));
	    Element node = document.getRootElement();
	    String key;
	    Iterator<?> IT = node.elementIterator();
    	while (IT.hasNext()) {
	    	Element element = (Element)IT.next();
	    	key = element.attributeValue("executionFlag");
	    	if (!key.toLowerCase().equals("false")) {
	    		map.add(new customMap(element.attributeValue("testdatalocation"),element.getData().toString()));
			}		    				
		}					
		TestCasesStorage=map;
		System.out.println("Load Test Cases Successfully");
	}
	
	/**
	 * 
	 * @param path
	 * @throws Exception
	 * @desc get test flow
	 * @author xieyid
	 */	
	public void getTestFlow(String path) throws Exception
	{
		System.out.println("Start Load Test Flow");
		TestFlowStorage=loadDataFromXML(path,"class");
		System.out.println("Load Test Flow Successfully");
	}
	/**
	 * 
	 * @param path
	 * @throws Exception
	 * @desc get test data
	 * @author xieyid
	 */	
	public void getTestData(String path) throws Exception
	{
		System.out.println("Start Load Test Data");
		LinkedMap map = new LinkedMap();				
		SAXReader reader = new SAXReader();  	        
	    Document document = reader.read(new File(path));
	    Element node = document.getRootElement();
	    Iterator<?> IT = node.elementIterator();
    	while (IT.hasNext()) {
	    	Element element = (Element)IT.next();	    	
	    	map.put(element.attributeValue("name"),element.getData().toString());					    				
		}					
		DataEngine=map;
		System.out.println("Load Test Data Successfully");
	}
	
		
	
	public void loadOR(String path) throws Exception{
		System.out.println("Start Load OR file: "+path);
		LinkedMap map = new LinkedMap();				
		SAXReader reader = new SAXReader();  	        
	    Document document = reader.read(new File(path));
	    Element node = document.getRootElement();
	    Iterator<?> IT = node.elementIterator();
    	while (IT.hasNext()) {
	    	Element element = (Element)IT.next();	    	
	    	map.put(element.attributeValue("name"),element.getData().toString());					    				
		}					
		OR=map;
		System.out.println("Load OR Successfully");
	}
	
	
	public void initialReport()
	{
		
	}
	
	public void addReportStep(String StepDescription,String StepStatus)
	{
		
	}
		 
	/**
	 * 
	 * @param BrowserType choose BrowseType, support Chrome, Firefox, IE, the default is Firefox
	 * @param URL 
	 * @author xieyid
	 */
	public Boolean OpenBrowser(String BrowserType,String URL) 
	{
		//WebDriver WD;
		switch(BrowserType)
		{
		case "Chrome": 
		System.setProperty("webdriver.chrome.driver", "c:/selenium/chromedriver_win32/chromedriver.exe");
		WD = new ChromeDriver(); 
		break;
		
		case "Firefox": WD = new FirefoxDriver();
		break;
		
		case "IE" : WD = new InternetExplorerDriver();
		break;
		
		default: WD = new FirefoxDriver();
		
		}
		try {
			WD.get(URL);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		
	}
	
	/**
	 * 
	 * @param XpathLocation xpath of an element, 
	 * @return
	 * @author xieyid
	 * 
	 */
	public boolean checkElementExist(String XpathLocation){
		try {
			WD.findElement(By.xpath(XpathLocation));
			captureScreen();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
							
	}
	/**
	 * 
	 * @param XpathLocation xpath of an element
	 * @return
	 * @author xieyid
	 */
	
	
	public boolean ClickElement(String XpathLocation){
		try {
			WebElement clickElement = WD.findElement(By.xpath(XpathLocation));
			clickElement.click();
			
			return true;
		} catch (Exception e) {
			System.out.println("obj is not exist..");			
			return false;
		}
	}
	/**
	 * 
	 * @return capture screen shot and save it at c:\temp\seleniumwork
	 * @throws Exception
	 */
	public String captureScreen() throws Exception{
	    String path;
	    try {
	        File source = ((TakesScreenshot)WD).getScreenshotAs(OutputType.FILE);
	        path = "C:\\temp\\SeleniumWork\\" + source.getName();
	        FileUtils.copyFile(source, new File(path)); 
	    }
	    catch(IOException e) {
	        path = "Failed to capture screenshot: " + e.getMessage();
	    }
	    return path;
	}
}

