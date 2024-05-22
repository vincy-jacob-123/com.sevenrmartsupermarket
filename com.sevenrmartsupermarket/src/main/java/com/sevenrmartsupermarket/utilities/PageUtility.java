package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.*;

public class PageUtility {
	
	WebDriver driver;
	
	JavascriptExecutor js ;
	
	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor)driver;
	}
	
	public void select_ByIndex(WebElement element, int index) {		
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_ByValue(WebElement element, String value) {  //to-do
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void accpetAlert() {
		
		driver.switchTo().alert().accept();
	}
	
	public String getCssValue(WebElement element, String type) {
		return element.getCssValue(type);		
	}
	
	public void dismissAlert() {
		
		driver.switchTo().alert().dismiss();
	}
	
	public void leftClickAction(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();
	}
	
	public void rightClickAction(WebElement element) {
		
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();
	}
	
	public void scrollAndClick(WebElement element) {
		int y = 0;		
		while (clickStatus(element)) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 5;
		}
	}
	
	public boolean clickStatus(WebElement element) {
		try {
			element.click();
			return false;
		}catch(Exception e) {
			return true;
			//e.printStackTrace();
		}
	}

	
}
	
	
	//dismiss
	
	//actions --> mouse click -- right click, double click, 
	//deselect
	//random pin code geneatiom -->  write in page Class
	//scroll into elemnet --> 

