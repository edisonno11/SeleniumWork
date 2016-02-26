package com.dreamworks.selenium.driver;


import com.dreamworks.selenium.businessLib.Basis;
import com.dreamworks.selenium.businessLib.customMap;
import com.dreamworks.selenium.driver.CustomClassLoader;




public class Driver {
	
	
	
	static Basis basis = new Basis();
	/**
	 * 
	 * @param args
	 * @throws Exception
	 * @author xieyid
	 */
	public static void main(String[] args) throws Exception{
		String testdatalocation;
		String casePath;		
		
		//Load Driver.xml
		basis.getTestCase();
		//Iterator ITCaseMap = Basis.TestCasesStorage.iterator();
//				.entrySet().iterator();
//		while (ITCaseMap.hasNext()) {
//			
//			Map.Entry entry = (Map.Entry) ITCaseMap.next();			
//			casePath = entry.getKey().toString();
//			executionFlag = entry.getValue().toString().toLowerCase();
//			if (executionFlag.equals("true")) {
//				startExecution(casePath);
//			}			
//		}
		for(customMap testcase:Basis.TestCasesStorage){
			
			testdatalocation = testcase.key.toLowerCase();
			casePath = testcase.value;
			basis.getTestData(testdatalocation);			
			startExecution(casePath);				
		}						
												
	}
	
	public static void driveProcess(String casePath, String testdatalocation) throws Exception{
		Basis basis = new Basis();
		basis.getTestData(testdatalocation);
		startExecution(casePath);
	}
	
	/**
	 * 
	 * @param FlowXMLPath
	 * @throws Exception
	 * @desc load test flow and start execution
	 * @author xieyid
	 */
	public static void startExecution(String FlowXMLPath) throws Exception{
		
		CustomClassLoader cl = new CustomClassLoader();		
		Basis basis = new  Basis();		
		basis.getTestFlow(FlowXMLPath);
//		Iterator ITFlowMap = basis.TestFlowStorage.entrySet().iterator();
//		while (ITFlowMap.hasNext()) {
//			Map.Entry entry = (Map.Entry) ITFlowMap.next();			
//			cl.Load(entry.getValue().toString(), entry.getKey().toString());			
//		}
		for(customMap testflow:Basis.TestFlowStorage){
			cl.Load(testflow.key,testflow.value);
		}
		
	}

}
