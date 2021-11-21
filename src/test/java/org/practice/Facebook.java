package org.practice;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.utility.BaseClass;

public class Facebook {
	static BaseClass base;
	static WebDriver driver;
	@BeforeClass
	public static void launchBrowser() {
		base = new BaseClass();
		driver = BaseClass.openBrowser("chrome");
		BaseClass.navigateToUrl("https://www.facebook.com/");

	}
	@AfterClass
	public static void closeBrowser() {
		BaseClass.quitAllBrowserWindow();
	}
	@Before
	public void startTime() {
		Date d = new Date();
		System.out.println(d);
	}
	@After
	public void endTime() {
		Date d = new Date();
		System.out.println(d);
	}
	@Test
	public void TestCase1() {
		driver.findElement(By.id("email")).sendKeys("Mohan");
		driver.findElement(By.id("pass")).sendKeys("Mohan");
		driver.findElement(By.name("login")).click();
		
	}
	
	

}
