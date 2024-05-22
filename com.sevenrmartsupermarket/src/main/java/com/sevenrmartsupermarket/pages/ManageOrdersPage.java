package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageOrdersPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//i[@class='nav-icon fas fa-shopping-basket']//following-sibling::p")
	private WebElement managerOderOptionLabel;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@name='od']")
	private WebElement orderIDLabel;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchLink;
	
	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageOrderOption() {
		managerOderOptionLabel.click();
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void enterOrderId(String orderId) {
		orderIDLabel.sendKeys(orderId);
	}
	
	public void clickOnSearchLink() {
		searchLink.click();
	}
	
	public void searchAOrderId(int id) {
		clickOnSearchButton();
		enterOrderId(String.valueOf(id));
		clickOnSearchLink();
	}
	
	
//	public String enterUserId() {
//		
//	}
//	
//	public String enterStartDate() {
//		
//	}
//
//	public String enterEndDate() {
//	
//	}
//	public String enterPaymentMode() {
//		
//	}
//	
//	public String enterStatus() {
//		
//	}
	
	
}
