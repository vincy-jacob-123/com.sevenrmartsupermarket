package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	
	AdminUsersPage adminUsersPage;
	LoginPage loginPage;
	ExcelReader excelReader = new ExcelReader();
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void verifyNewAdminUserAddition() {
		loginPage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginPage.login();	
		adminUsersPage.clickOnAdminUserBox();
		excelReader.setExcelFile("NewUserLoginData", "LoginData");
		String userName = excelReader.getCellData(4, 0) ;
		userName = userName + GeneralUtility.getRandomFullName();//avoiding duplication
		String password = excelReader.getCellData(4, 1);
		String userType = "admin";
		String actualUserAdditonResultColour = adminUsersPage.addNewAdminUser(userName, password, userType);
		//String actualUserAdditonResultColour = adminUsersPage.addNewAdminUser("aa44121", "aa", "admin");
		//System.out.println(actualUserAdditonResultColour);
		String expectedUserAdditonResultColour = "rgba(40, 167, 69, 1)";
		softAssert.assertEquals(actualUserAdditonResultColour, expectedUserAdditonResultColour);
		
//		String actualNewUserName = adminUsersPage.getNewUserNameFromTable();
//		String expectedNewUserName = userName;
//		softAssert.assertEquals(actualNewUserName, expectedNewUserName);
//		softAssert.assertAll();
	}
	
	@Test
	public void verifyNewlyAddedUserLogin() {
		
		loginPage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginPage.login();	
		adminUsersPage.clickOnAdminUserBox();
		excelReader.setExcelFile("NewUserLoginData", "LoginData");
		String userName = excelReader.getCellData(4, 0);
		//String userName = "sfafafaqq1122";
		String password = excelReader.getCellData(4, 1);
		//String password = "aa";
		String userType = "admin";
		//String actualUserAdditonResultColour = adminUsersPage.addNewAdminUser(userName, password, userType);
		String actualUserAdditonResultColour = adminUsersPage.addNewAdminUser(userName, password, userType);
		//System.out.println(actualUserAdditonResultColour);
		String expectedUserAdditonResultColour = "rgba(40, 167, 69, 1)";
		Assert.assertEquals(actualUserAdditonResultColour, expectedUserAdditonResultColour);
		
		//String actualNewUserLoginSucccess = loginPage.checkUserLogo(userName, password);	
		Assert.assertTrue(loginPage.checkUserLogo("12", password));
	}
	
	@Test
	public void verifyDeactivationFunctionality() {
		adminUsersPage = new AdminUsersPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login();	
		adminUsersPage.clickOnAdminUserBox();
		adminUsersPage.deactivateUser("Nenita O'Keefe");
	}
	

}
