package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationPage {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='titlep']")
	private WebElement titleElement;	
	@FindBy(xpath = "//input[@name='description']")
	private WebElement descriptionElement;	
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement sendButton;
	@FindBy (xpath = "//i[@class='nav-icon fas fa-fas fa-bell']//following-sibling::p")
	private WebElement pushNotifOption;
	
	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTitle(String title) {
		titleElement.sendKeys(title);		
	}
	
	public void enterDescription(String description) {
		descriptionElement.sendKeys(description);
		
	}
	
	public void clickOnSendButton() {
		sendButton.click();		
	}
	
	public void clickOnPushNotifOption() {
		pushNotifOption.click();		
	}
	
	public void sendNotification(String title, String description) {
		enterTitle(title);
		enterDescription(description);
		clickOnSendButton();
	}
	
	
	
}
