package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
	WebElement adminUsersBox;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newUserButton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameLabel;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordLabel;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement userTypeLabel;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert alert')]")
	WebElement userAdditionResultPopUp;	
	@FindBy(xpath = "//tbody//tr//td[1]")
	List<WebElement> userNameColumnElements;
	
	GeneralUtility generalUtility = new GeneralUtility();
	PageUtility pageUtility = new PageUtility(driver);
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickOnAdminUserBox() {
		adminUsersBox.click();
	}
	
	public void clickOnNewUserButton() {
		newUserButton.click();
	}
	
	public void enterUsername(String UserName) {
		userNameLabel.sendKeys(UserName);
	}
	public void enterPassword(String password) {
		passwordLabel.sendKeys(password);
	}

	public void enterUserType(String UserType) {
		pageUtility.select_ByValue(userTypeLabel, UserType);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
	public String verifySuccessMsgAfterNewUserAddition(String type) {
		//String color = pageUtility.getCssValue(userAdditionResultPopUp, type);
		//System.out.println(color);
		return pageUtility.getCssValue(userAdditionResultPopUp, type);
	}
	
	public String addNewAdminUser(String UserName, String Password, String userType) {
		clickOnNewUserButton();
		enterUsername(UserName);
		enterPassword(Password);
		enterUserType(userType);
		clickOnSaveButton();
		return verifySuccessMsgAfterNewUserAddition("background-color");
	}
	
	public void deactivateUser(String userName) {
		List<String> namesList = new ArrayList();
		namesList = generalUtility.getTextOfListelements(userNameColumnElements);
		
		
//		for (WebElement uerName : userNameColumnElements) {
//			if
//			System.out.println(uerName.getText());
//		}
		int index = 0;
		for (index = 0; index< namesList.size(); index++) {
			if (namesList.get(index).equals(userName)) {
				index++;
				break;
			}
		}
		WebElement deactivateButton = driver.findElement(By.xpath("//table//tr[" + index + "]//td[5]//a[1]"));
		pageUtility.scrollAndClick(deactivateButton);  //to scroll to end of the page..if name is at last 
	}

}
