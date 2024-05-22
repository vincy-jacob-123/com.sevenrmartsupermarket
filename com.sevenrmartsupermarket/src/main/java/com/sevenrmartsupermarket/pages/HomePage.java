package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class HomePage {
	
	WebDriver driver;	
	
	@FindBy (xpath = "//a[@class='d-block']")
	private WebElement userProfileElement; //encapsulation
	
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberMeText;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;
	
	public HomePage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	PageUtility pageUtility = new PageUtility(driver);
	
	public String getProfileName() {
		return userProfileElement.getText();
	}
	
	public boolean isRememberMeDisplayed() {
		return rememberMeText.isDisplayed();
	}
	
	public boolean isRememberMeSelected() {
		return rememberMeText.isSelected();
	}
	
	public void clickOnRememberMe() {
		rememberMeText.click();
	}
	
	public boolean isSignInButtonDisplayed() {
		return signInButton.isDisplayed(); 
	}//isselected  --> only for input tag

	public void clickOnSignInButton() {
		 pageUtility.leftClickAction(signInButton, driver);//doubt
	}
}
