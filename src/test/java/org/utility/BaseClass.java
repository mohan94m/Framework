package org.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static  WebDriver driver ;
	public static Actions actions;
	public static JavascriptExecutor executor;
	public static Select select;

	public static  WebDriver openBrowser(String browser) {
		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		}else { WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();			
		}

		manageOptionsInDriver().window().maximize();
		manageOptionsInDriver().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}


	//WebDriver Interface Methods

	public static void quitAllBrowserWindow() {
		driver.quit();

	}
	public  void closeCurrentWindow() {
		driver.close();
	}
	public  void goToUrl(String url) {
		driver.get(url);    
	}
	public static Navigation navigate() {
		return driver.navigate();
	}
	public  String getCurrentPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;     
	}
	public  String getCurrentPageTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;     
	}
	public  TargetLocator switchToTarget() {
		TargetLocator switchTo = driver.switchTo();
		return switchTo;    
	}
	public static Options manageOptionsInDriver() {
		Options manage = driver.manage();
		return manage;
	}    
	public  String getCurrentWindowId() {
		String handle = driver.getWindowHandle();
		return handle;
	}
	public  List<String> getAllWindowId() {
		Set<String> handles = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<String>();
		windowHandles.addAll(handles);
		return windowHandles;
	}	
	public  WebElement findElementById(String locator) {
		WebElement element = driver.findElement(By.id(locator));
		return element;
	}

	public  WebElement findElementByName(String locator) {
		WebElement element = driver.findElement(By.name(locator));
		return element;
	}

	public  WebElement findElementByClassName(String locator) {
		WebElement element = driver.findElement(By.className(locator));
		return element;
	}

	public  WebElement findElementByXpath(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element;
	}

	public  WebElement findElementByCssSelector(String locator) {
		WebElement element = driver.findElement(By.cssSelector(locator));
		return element;
	}

	public  WebElement findElementByTagname(String locator) {
		WebElement element = driver.findElement(By.tagName(locator));
		return element;
	}

	public  WebElement findElementByLinkText(String locator) {
		WebElement element = driver.findElement(By.linkText(locator));
		return element;
	}

	public  WebElement findElementByPartialLinkText(String locator) {
		WebElement element = driver.findElement(By.partialLinkText(locator));
		return element;
	}

	public  List<WebElement> findElementsById(String locator) {
		List<WebElement> element = driver.findElements(By.id(locator));
		return element;
	}

	public  List<WebElement> findElementsByName(String locator) {
		List<WebElement> element = driver.findElements(By.name(locator));
		return element;
	}

	public  List<WebElement> findElementsByClassName(String locator) {
		List<WebElement> element = driver.findElements(By.className(locator));
		return element;
	}

	public  List<WebElement> findElementsByXpath(String locator) {
		List<WebElement> element = driver.findElements(By.xpath(locator));
		return element;
	}

	public  List<WebElement> findElementsByCssSelector(String locator) {
		List<WebElement> element = driver.findElements(By.cssSelector(locator));
		return element;
	}

	public List<WebElement> findElementsByTagname(String locator) {
		List<WebElement> element = driver.findElements(By.tagName(locator));
		return element;
	}

	public List<WebElement> findElementsByLinkText(String locator) {
		List<WebElement> element = driver.findElements(By.linkText(locator));
		return element;
	}

	public List<WebElement> findElementsByPartialLinkText(String locator) {
		List<WebElement> element = driver.findElements(By.partialLinkText(locator));
		return element;
	}


	//WebElement  Interface Methods
	public  void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}
	public  void clickButton(WebElement element) {
		element.click();
	}
	public String getTextFromTag(WebElement element) {
		String text = element.getText();
		return text;

	}
	public String getAttribute(WebElement element, String Attribute) {
		String text = element.getAttribute(Attribute);
		return text;	
	}
	public String getAttribute(WebElement element) {
		String text = element.getAttribute("value");
		return text;	
	}
	public void clearText(WebElement element) {
		element.clear();
	}
	public void isElementEnabled(WebElement element) {
		element.isEnabled();
	}
	public void isElementSelected(WebElement element) {
		element.isSelected();
	}
	public void isElementDisplayed(WebElement element) {
		element.isDisplayed();
	}


	//Select class methods
	public  void selectDDByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);	  
	}
	public  void selectDDByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);	  
	}
	public  void selectDDByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);	  
	}
	public List<WebElement> getDDOptions(WebElement element) {
		select = new Select(element);
		List<WebElement> list = select.getOptions();
		return list;
	}
	public boolean isDDMultiple(WebElement element) {
		select = new Select(element);
		return select.isMultiple();
	}
	public  void deSelectDDByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);	  
	}
	public  void deSelectDDByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);	  
	}
	public  void deSelectDDByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);	  
	}
	public void deSelectAllDD(WebElement element) {
		select = new Select(element);
		select.deselectAll();
	}
	public WebElement getDDFirstSelectedOption(WebElement element) {
		select = new Select(element);
		return select.getFirstSelectedOption();
	}
	public List<WebElement> getDDAllSelectedOption(WebElement element) {
		select = new Select(element);
		return select.getAllSelectedOptions();
	}


	//Action Class methods
	public void performAction() {
		actions = new Actions(driver);
		actions.perform();
	}
	public void moveToElementAction(WebElement element) {
		actions.moveToElement(element).perform();
	}
	public  void doubleClickAction(WebElement element) {
		actions.doubleClick(element).perform();
	}
	public void contextClickAction(WebElement element) {
		actions.contextClick(element).perform();
	}
	public void dragAndDropAction(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}


	//Navigation methods
	public static void navigateToUrl(String url) {
		navigate().to(url);   
	}
	public void navigateBack() {
		navigate().back();
	}
	public void navigateForward() {
		navigate().forward();
	}
	public void navigateRefresh() {
		navigate().refresh();
	}


	//Frames handling methods
	public void frameByNameOrId(String nameOrId) {
		switchToTarget().frame(nameOrId);
	}
	public void frameByElement(WebElement element) {
		switchToTarget().frame(element);
	}
	public void frameByIndex(int index) {
		switchToTarget().frame(index);
	}
	public void frameToWebPage() {
		switchToTarget().defaultContent();
	}
	public void toParentFrame() {
		switchToTarget().parentFrame();
	}


	//Alert handling methods
	public Alert switchToAlert() {
		return switchToTarget().alert();
	}
	public void acceptAlert() {
		switchToAlert().accept();
	}
	public void dismissAlert() {
		switchToAlert().dismiss();
	}
	public void sendKeysAlert(String text) {
		switchToAlert().sendKeys(text);
	}
	public String getTextAlert() {
		return switchToAlert().getText();
	}


	//Getting Data From Excel DataDrivenDevelopment
	public  String getDataFromExcel(String fileLocation, String sheet, int rowIndex, int cellIndex) throws IOException {
		String value= null;
		File location = new File(fileLocation);
		FileInputStream input = new FileInputStream(location);
		Workbook workbook = new XSSFWorkbook(input);
		Sheet sheet2 = workbook.getSheet(sheet);
		Row row = sheet2.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		int type = cell.getCellType();
		if (type==1) {
			value = cell.getStringCellValue();

		}else if (type==0) {
			if (DateUtil.isCellDateFormatted(cell)) {

				SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
				value = s.format(cell.getDateCellValue());
			}else {
				value = String.valueOf((long) cell.getNumericCellValue());
			}
		}

		return value;
	}
	//Write data into Excel
	public void writeData(String fileLocation, String sheetName, int rowIndex, int cellIndex, String data) throws IOException {
		File loc = new File(fileLocation);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(rowIndex);
		Cell cell = row.createCell(cellIndex);
		cell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(loc);
		workbook.write(stream);


	}
	public void writeData(String fileLocation, String sheetName, int rowIndex, int cellIndex, int data) throws IOException {
		File loc = new File(fileLocation);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(rowIndex);
		Cell cell = row.createCell(cellIndex);
		cell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(loc);
		workbook.write(stream);
	}

	//Update data into Excel
	public void updateData(String fileLocation, String sheetName, int rowIndex, int cellIndex, String oldData, String newData) throws IOException {
		File loc = new File(fileLocation);
		FileInputStream stream = new FileInputStream(loc);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		String value = cell.getStringCellValue();
		if (value.equalsIgnoreCase(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream output = new FileOutputStream(loc);
		workbook.write(output);		
	}
	public void writeDataInCell(String fileLocation, String sheetName, int rowIndex, int cellIndex, String data) throws IOException {
		File loc = new File(fileLocation);
		FileInputStream stream = new FileInputStream(loc);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.createCell(cellIndex);
		cell.setCellValue(data);
	    FileOutputStream output = new FileOutputStream(loc);
		workbook.write(output);		
	}

	//JavaScriptExecuter methods
	public  void javaScriptInsert(WebElement element, String name) {
		executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value','"+name+"')", element);
	}
	public  void javaScriptClick(WebElement element) {
		executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
	}
	public  void javaScriptGetAttribute(WebElement element, String attriname) {
		executor= (JavascriptExecutor)driver;
		executor.executeScript("returnargumernts[0].getAttribute('value','"+attriname+"')", element);
	}
	public  void scrollUp(WebElement element) {
		executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public  void scrollDown(WebElement element) {
		executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}


	//TakeSreenShots
	public void takeScreenShot(String name) throws IOException {
		TakesScreenshot  screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File("D:\\Mohan\\Framework\\DataDrivenFramework\\Screenshots\\"+name+".png");
		FileUtils.copyFile(s, d);
	}
	public void takeScreenShot(WebElement element, String name) throws IOException {
		File s = element.getScreenshotAs(OutputType.FILE);
		File d = new File("D:\\Mohan\\Framework\\DataDrivenFramework\\Screenshots\\"+name+".png");
		FileUtils.copyFile(s, d);
	}
	public void time() {
		Date d = new Date();
		System.out.println(d);
	}
}
