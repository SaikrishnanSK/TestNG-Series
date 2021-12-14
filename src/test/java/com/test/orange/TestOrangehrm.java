package com.test.orange;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOrangehrm {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.out.println("Test Execution Starts");
      
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Method Starts");
	}

	@AfterMethod
	public void afterMethod() {
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Method Ends");
	}

	@Test
	public void openOrangeHrm() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		System.out.println(Thread.currentThread().getId());

	}

	@AfterTest
	public void afterTest() {
		driver.close();

	}

	@AfterMethod
	public void takeScreenShot() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TakesScreenshot tks = (TakesScreenshot) driver;
       File srclocation= tks.getScreenshotAs(OutputType.FILE);
       File destlocation= new File("./Screenshot/OrangeHRM.png");
       try {
		FileUtils.copyFile(srclocation, destlocation);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       
	}}
//	@Test
//	public void Sampletest() {
//		int a = 2,b=3 ;
//		Assert.assertEquals(a, b);
//		
//	}
//	public void tearDown(ITestResult result) {
//		if (ITestResult.FAILURE== result.getStatus()) {
//			takeScreenShot();
//		}
//	}
//}
