package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;

public class HomeTest extends Base{
	
	HomePage homePage ;
	
	@Test
	public void verifyIsRemeberMeDisplayed() {
		
		homePage = new HomePage(driver);		
		Assert.assertTrue(homePage.isRememberMeDisplayed());		
	}
	
	@Test
	public void verifyIsRemeberMeSelected() { //doubt
		
		homePage = new HomePage(driver);
		homePage.clickOnRememberMe();
		boolean isSelected = homePage.isRememberMeSelected();
		System.out.println("isSelected0 " + isSelected);
		Assert.assertTrue(isSelected);		
	}
	
	@Test
	public void verifyIsSignInDisplayed() {
		
		homePage = new HomePage(driver);		
		Assert.assertTrue(homePage.isSignInButtonDisplayed());
	
	}
	
	
	@Test
	public void clickOnSignInButon() {
		
		homePage = new HomePage(driver);		
		
		homePage.clickOnSignInButton();
	}
}

