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
	
	@Test
	public void verifyUserLogin() {
		//ScreenShotCapture screenShotCapture = new ScreenShotCapture();
		loginPage = new LoginPage(driver);		
		homePage = new HomePage(driver);
		//screenShotCapture.takeScreenshot(driver, "loginPage");
		String expectedProfileName = "Admin";
		loginPage.login();
		String actualProfileName = homePage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);	
		
	}
	
	@Test
	public void verifyInvalidLoginErrorMsg() { //doubt
		loginPage = new LoginPage(driver);	
		loginPage.login("user1", "invalidUser123");
		String expectedAlertmsg = "Invalid Username/Password";
		String actualAlertMsg = loginPage.getIncorrectUserAlertMsg();
		Assert.assertEquals(actualAlertMsg, expectedAlertmsg);
		
	}

}
