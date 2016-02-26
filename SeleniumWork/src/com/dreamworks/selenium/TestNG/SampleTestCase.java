package com.dreamworks.selenium.TestNG;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.reporters.util.*;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.*;
import org.testng.asserts.*;
import org.testng.annotations.Test;
import com.dreamworks.selenium.businessLib.*;
import com.dreamworks.selenium.driver.Driver;
public class SampleTestCase extends TestListenerAdapter 
{
	Basis basis = new Basis();	
	
	@BeforeClass
	public void beforeClass(){
		
		System.out.println("this is before class");
	}
	
	@Test
	public void TestNGSampleTestCase(){
		System.out.println("this is testNG test case");		
	}	
	
	@Test
	public void TestNGSampleTestcase01() throws Exception{
		Driver driver = new Driver();
		driver.driveProcess("SeleniumAdditional/BusinessFlow/SampleTestCase.xml","SeleniumAdditional/TestData/SampleTestCaseTestData.xml");		
		//driver.startExecution("SeleniumAdditional/BusinessFlow/SampleTestCase.xml");
	}
	@Test
	public void OpenBrowser() throws Exception{
		basis.OpenBrowser("Chrome", "http://home.hp.com");		
//		Assert.fail("it's a fail case");
		Assert.assertTrue(true);
		
	
	}
	@Test
	public void EnterHPE() throws Exception{
		basis.ClickElement("//div[@id='container']/div[3]");
	}
	
	
	
	@AfterClass
	public void afterClass(){
		System.out.println("this is after class");
	}
	
}
