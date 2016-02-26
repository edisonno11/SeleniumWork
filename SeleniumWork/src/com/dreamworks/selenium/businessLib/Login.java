package com.dreamworks.selenium.businessLib;
import java.util.Observable;
import com.dreamworks.selenium.businessLib.Basis;
public class Login extends Observable
{
	Basis basis = new Basis() ;
	
	/**
	 * @desc sample login HP home
	 * @author xieyid
	 */	
	public void loginTest(){
		
		basis.OpenBrowser(Basis.DataEngine.get("BrowserType").toString(),Basis.DataEngine.get("LoginURL").toString());
		System.out.println("open home.hp.com");
		
		if (basis.checkElementExist(Basis.OR.get("HPE_Button").toString())) {
			System.out.println("open home.hp.com successfully");						
		} else {
			System.out.println("open home.hp.com failed");
		}
		
		
	}
	
	/**
	 * @desc sample click
	 * @author xieyid 
	 */
	public void EnterHPE(){
		
		if (basis.ClickElement(Basis.OR.get("HPE_Button").toString())) {
			System.out.println("click HPE successfully");
			
		} else {
			System.out.println("click HPE fail");
		}
		
						
	}
	

}
