package com.dreamworks.selenium.driver;

import java.lang.reflect.Method;

import com.dreamworks.selenium.businessLib.Basis;

public class CustomClassLoader {
	Basis basis = new Basis();	 
/**
 * 
 * @param ClassName the class you need to load, eg: com.dreamworks.selenium.businesslib.login
 * @param FunctionName the function you need to load eg: LoginTest
 * @throws Exception
 * @desc using invoke to load class and function 
 * @author xieyid
 */
	public void Load(String ClassName, String FunctionName) throws Exception{
		String[] loador;
		if (FunctionName.toLowerCase().contains("loador")) 
		{	loador = FunctionName.split("\\|");
			basis.loadOR(loador[1]);
		}
		else
		{
			// find class based on class full name eg. com.dreamworks.selenium.businessLib.Login
			Class<?> clz = Class.forName(ClassName);		
			
			Object o = clz.newInstance();
			// get method in the class
			Method m = clz.getMethod(FunctionName);
			//invoke this method to the object so that we can use the method
			m.invoke(o);
		}
	}
	

}