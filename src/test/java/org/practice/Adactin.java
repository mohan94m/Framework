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

public class Adactin extends BaseClass{
	static WebDriver driver;
	@BeforeClass
	public static void launchBrowser() {
		
		driver = openBrowser("chrome");
		navigateToUrl("https://adactinhotelapp.com/");

	}
	@AfterClass
	public static void closeBrowser() {
		quitAllBrowserWindow();
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
	public void login() {
		driver.findElement(By.id("username")).sendKeys("mohnkumr");
		driver.findElement(By.id("password")).sendKeys("mohanm");
		driver.findElement(By.id("login")).click();

	}



}
