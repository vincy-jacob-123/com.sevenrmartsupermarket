package com.sevenrmartsupermarket.tests;

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
	public void verifyNewUserCreation() {
		loginPage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginPage.login();	
		adminUsersPage.clickOnAdminUserBox();
		excelReader.setExcelFile("NewUserLoginData", "LoginData");
		String userName = excelReader.getCellData(4, 0) ;
		userName = userName + GeneralUtility.getRandomFullName();
		String password = excelReader.getCellData(4, 1);
		String userType = "admin";
		String actualUserAdditonResultColour = adminUsersPage.addNewAdminUser(userName, password, userType);
		String expectedUserAdditonResultColour = "rgba(40, 167, 69, 1)";
		softAssert.assertEquals(actualUserAdditonResultColour, expectedUserAdditonResultColour);		
	}
	
	@Test
	public void verifyReLoginAfterNewUserCreation() {		
		loginPage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		excelReader.setExcelFile("NewUserLoginData", "LoginData");
		loginPage.login();	
		adminUsersPage.clickOnAdminUserBox();
		excelReader.setExcelFile("NewUserLoginData", "LoginData");
		String userName = excelReader.getCellData(1, 0);
		String password = excelReader.getCellData(1, 1);
		String userType = "admin";
		String actualUserAdditonResultColour = adminUsersPage.addNewAdminUser(userName, password, userType);
		String expectedUserAdditonResultColour = "rgba(40, 167, 69, 1)";
		softAssert.assertEquals(actualUserAdditonResultColour, expectedUserAdditonResultColour);
	
		softAssert.assertTrue(loginPage.checkReLogin(userName, password));
		softAssert.assertAll();
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
