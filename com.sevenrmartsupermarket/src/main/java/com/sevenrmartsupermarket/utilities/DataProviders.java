package com.sevenrmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	ExcelReader excelReader = new ExcelReader();
	
	@DataProvider(name="newUsers")
	public Object[][] memberNames()
	{
		return new Object [][] {{"Ezek", "Vincyyy"},{"jacob", "jacob22"},{"Cara", "welcome"}}; 
	}

	@DataProvider(name="Newlogin")     
	public Object[][] Newlogin()
	{
		excelReader.setExcelFile("NewUserLoginData", "LoginData");
		return excelReader.getMultidimentionalData(3, 2);
	}
}
