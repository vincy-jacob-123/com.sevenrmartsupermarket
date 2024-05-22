package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageOrdersPage;

public class ManageOrdersTest extends Base {
	
	ManageOrdersPage manageOrdersPage;
	LoginPage loginPage;
	
	@Test
	public void verifyManageOrdersPageNavigation() {
		manageOrdersPage = new ManageOrdersPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login();
		manageOrdersPage.clickOnManageOrderOption();
	}
	
	@Test
	public void searchOrder() {
		manageOrdersPage = new ManageOrdersPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login();
		manageOrdersPage.clickOnManageOrderOption();
		manageOrdersPage.searchAOrderId(111);
	}

}
