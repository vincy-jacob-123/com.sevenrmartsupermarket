package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class PushNotificationTest extends Base{
	
	LoginPage loginPage;
	PushNotificationPage pushNotificationPage;
	ExcelReader excelReader = new  ExcelReader();
	
	@Test
	public void sendPushNotification() {
		loginPage = new LoginPage(driver);
		loginPage.login();		
		pushNotificationPage = new PushNotificationPage(driver);
		pushNotificationPage.clickOnPushNotifOption();
		
		excelReader.setExcelFile("PushNotificationData", "Notifications"); //workbookname, sheetName //here extension of excel sheet is not needed
		String title = excelReader.getCellData(1, 0);
		String description = excelReader.getCellData(1, 1); //close the excel while running
		
		String name = GeneralUtility.getRandomFullName();
		System.out.println(name);
		String title1 = excelReader.getCellData(2, 0);
		String description2 = excelReader.getCellData(2, 1);
		
		pushNotificationPage.sendNotification(name, description2);
	}
}
