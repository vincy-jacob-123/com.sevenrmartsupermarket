package com.sevenrmartsupermarket.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
	
	public class LoginRajiTest extends Base {

		LoginPage loginpage;
		HomePage homepage;

		@Test

		public void verifyUserLogin() {

			loginpage = new LoginPage(driver);
			loginpage.login();
		}

		@Test

		public void getUserName() {
			loginpage = new LoginPage(driver);
			homepage = new HomePage(driver);
			loginpage.login();
			String actualProfileName = homepage.getProfileName();
			String expectedProfileName = "Admin";
			Assert.assertEquals(actualProfileName, expectedProfileName);
		}

		@Test

		public void invalidLoginTest() {
			loginpage = new LoginPage(driver);
			loginpage.login("Raji", "raji");

		}

}
