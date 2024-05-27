package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {	
	
	public List<String> getTextOfListelements(List<WebElement> elements) {
		List<String> namesList = new ArrayList<String>();
		elements.forEach(element -> namesList.add(element.getText()));
		return namesList;		
	}
	
	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);		
	}
	
	public String getCssProperty(WebElement element, String css ) {
		return element.getCssValue(css);		
	}
	
	public static String getRandomFullName() {
		Faker faker = new Faker();
		return faker.name().fullName();
	}
	
	public boolean isTextConatins(WebElement element, String expectedText) {
		return element.getText().contains(expectedText);
	}
}
