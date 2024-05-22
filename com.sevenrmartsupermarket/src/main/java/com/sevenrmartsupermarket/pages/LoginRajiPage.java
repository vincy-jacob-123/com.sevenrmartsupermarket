package com.sevenrmartsupermarket.pages;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.sevenrmartsupermarket.constants.Constants;

	import java.io.FileInputStream;
	import java.util.Properties;

	public class LoginRajiPage {
		
		WebDriver driver;
		
		Properties properties = new Properties();
		
		@FindBy (xpath = "//input[@name='username']")
		private WebElement userNameField;	
		@FindBy (xpath = "//input[@name='password']")
		private WebElement passwordField;	 //encapulation	
		@FindBy (xpath = "//button[text()='Sign In']")
		private WebElement loginButtonField;
		@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
		private WebElement incorrectUserAlertMsg;
		
		
		public LoginRajiPage(WebDriver driver) {
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
		
		public String getIncorrectUserAlertMsg() {
			String alertMsg = driver.switchTo().alert().getText();
			System.out.println(alertMsg);
			return alertMsg;
		}
		
//		public String getErrorMessage(){
//			
//		}
		//utility --1. for fetching data --> general utility
		//2. interacting with webpage  --> drop down select
		
		
		//remember me checkbox exists
		//remeber me checkbox clickable
		
		
		 
	}


