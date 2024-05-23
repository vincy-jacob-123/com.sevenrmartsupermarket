package com.sevenrmartsupermarket.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int counter = 0;
	int retryLimit = 2; //here three times it run...one by defualt..then two ..
	
	@Override
	public boolean retry(ITestResult result) {

		if(counter < retryLimit)
		{
			counter++;
			return true;
		}
		return false;
	}

}
