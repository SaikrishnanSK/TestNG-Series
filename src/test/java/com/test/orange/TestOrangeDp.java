package com.test.orange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOrangeDp {
	@DataProvider(name = "CredData")

	private Object[][] testData() {
		Object[][] cred = { { "Admin", "admin123" }, { "Sai", "sai123" }, { "Krish", "krish123" } };
		return cred;

	}

	@Test(dataProvider = "CredData")
	public void loginApp(String uname, String pass) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		driver.findElement(By.id("btnLogin")).click();
		driver.close();

	}

}
