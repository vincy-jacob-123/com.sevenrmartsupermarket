package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.WaitUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class LoginPage {
	
	WebDriver driver;
	
	Properties properties = new Properties();
	
	ExcelReader excelReader = new ExcelReader();
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement userNameField;	
	@FindBy (xpath = "//input[@name='password']")
	private WebElement passwordField;	 //encapulation	
	@FindBy (xpath = "//button[text()='Sign In']")
	private WebElement loginButtonField;
	@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement incorrectUserAlertMsg;	
	@FindBy (xpath = "(//img[@alt='User Image'])[2]")
	private WebElement userLogo;
	
	@FindBy (xpath = "//a[@data-toggle='dropdown']")
	private WebElement leftTopAdminButton;
	@FindBy (xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logoutButton;
	
	WaitUtility waitUtility = new WaitUtility();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			//properties = new Properties();
			FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fs);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginButtonField.click();
	}
	
	
	public void clickOnLeftTopAdminButton() {
		leftTopAdminButton.click();
	}
	
	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	public void login() {
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
	}
	
	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();		
	}
	
	public boolean checkUserLogo(String userName, String password) {
		clickOnLeftTopAdminButton();
		clickOnLogoutButton();
		login(userName,password);
		//waitUtility.waitForElementToBeVisible(userLogo,10.0000);
		//clickOnLeftTopAdminButton();
		//clickOnLogoutButton();
		System.out.println("userLogo.isDisplayed()" + userLogo.isDisplayed());
		return userLogo.isDisplayed();
	}
	
	//listerners are useed to listen to pass or skip or fail a testcase
	
	public String getIncorrectUserAlertMsg() {
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		return alertMsg;
	}
	
//	public String getErrorMessage(){
//		
//	}
	//utility --1. for fetching data --> general utility
	//2. interacting with webpage  --> drop down select
	
	//mouse with send keys
	//random name generate 
	
	@DataProvider(name="Newlogin")       //using excel

	public Object[][] Newlogin()  //dataprovide c lass

	{

		excelReader.setExcelFile("LoginData","DataProviderSheet");

		return excelReader.getMultidimentionalData(3, 2);

	}
	 
}
