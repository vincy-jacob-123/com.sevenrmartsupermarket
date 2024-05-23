package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenShotCapture;

public class LoginTest extends Base {
	
	LoginPage loginPage;
	HomePage homePage;
	
	@Test(groups={"SmokeTesting", "parallelExecution"}, retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyUserLogin() {
		//ScreenShotCapture screenShotCapture = new ScreenShotCapture();
		loginPage = new LoginPage(driver);		
		homePage = new HomePage(driver);
		//screenShotCapture.takeScreenshot(driver, "loginPage");
		String expectedProfileName = "Admin1";
		loginPage.login();
		String actualProfileName = homePage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);	
		
	}
	
	@Test(groups="SmokeTesting")
	public void verifyInvalidLoginErrorMsg() { //doubt
		loginPage = new LoginPage(driver);	
		loginPage.login("user1", "invalidUser123");
		String expectedAlertmsg = "Invalid Username/Password";
		String actualAlertMsg = loginPage.getIncorrectUserAlertMsg();
		Assert.assertEquals(actualAlertMsg, expectedAlertmsg);
		
	}
	
//	@Test(dataProvider = "Newlogin",dataProviderClass = DataProviders.class)
//
//	public void verifyLoginDataProvider(String user,String password) {
//
//	loginPage=new LoginPage(driver);
//
//	homePage = new HomePage(driver);
//
//		loginPage.login(user,password);
//		
//		String actualProfileName = homePage.getProfilename();
//
//		String expectedProfileName = user;
//
//		Assert.assertEquals(actualProfileName, expectedProfileName);;
//
//	}

}
