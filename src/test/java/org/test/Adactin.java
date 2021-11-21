package org.test;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.utility.BaseClass;

public class Adactin extends BaseClass {

	@BeforeClass
	public static void lauchingapplication() {
		openBrowser("chrome");
		navigateToUrl("https://adactinhotelapp.com/");

	}

	@AfterClass
	public static void closingapplication() {
		quitAllBrowserWindow();
	}

	@Before
	public void startTime() {
		time();
	}

	@After
	public void endTime() {
		time();
	}

	@Test
	public void bookingOrder() throws IOException {
		String fileLocation = "D:\\Mohan\\Framework\\DataDrivenFramework\\Excel\\AdactinOrderBooking.xlsx";
		String userName = getDataFromExcel(fileLocation, "LoginPage", 1, 0);
		String password = getDataFromExcel(fileLocation, "LoginPage", 1, 1);

		// LoginPage
		WebElement txtUserName = findElementById("username");

		sendText(txtUserName, userName);
		Assert.assertEquals("Verify Username", getAttribute(txtUserName), userName);

		WebElement txtPassword = findElementById("password");

		sendText(txtPassword, password);
		Assert.assertEquals("Verify Password", getAttribute(txtPassword), password);

		clickButton(findElementById("login"));

		// Search Hotel page
		selectDDByVisibleText(findElementById("location"), getDataFromExcel(fileLocation, "SearchHotelPage", 1, 0));

		selectDDByVisibleText(findElementById("hotels"), getDataFromExcel(fileLocation, "SearchHotelPage", 2, 1));

		selectDDByVisibleText(findElementById("room_type"), getDataFromExcel(fileLocation, "SearchHotelPage", 2, 2));

		selectDDByVisibleText(findElementById("room_nos"), getDataFromExcel(fileLocation, "SearchHotelPage", 2, 3));

		sendText(findElementById("datepick_in"), getDataFromExcel(fileLocation, "SearchHotelPage", 2, 4));
		sendText(findElementById("datepick_out"), getDataFromExcel(fileLocation, "SearchHotelPage", 2, 5));
		selectDDByVisibleText(findElementById("adult_room"), getDataFromExcel(fileLocation, "SearchHotelPage", 2, 6));

		selectDDByVisibleText(findElementById("child_room"), getDataFromExcel(fileLocation, "SearchHotelPage", 2, 7));
		clickButton(findElementById("Submit"));

		// Select Hotel Page
		clickButton(findElementById("radiobutton_0"));
		clickButton(findElementById("continue"));

		// BookAHotel page
		WebElement txtFirstname = findElementById("first_name");
		String firstname = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 0);
		sendText(txtFirstname, firstname);
		Assert.assertEquals("Verify First name", getAttribute(txtFirstname), firstname);

		WebElement txtLastname = findElementById("last_name");
		String lastName = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 1);
		sendText(txtLastname, lastName);
		Assert.assertEquals("Verify Lart name", getAttribute(txtLastname), lastName);

		WebElement txtAddress = findElementById("address");
		String address = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 2);
		sendText(txtAddress, address);
		Assert.assertEquals("Verify Address", getAttribute(txtAddress), address);

		WebElement txtCreditcardNo = findElementById("cc_num");
		String CreditCardno = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 3);
		sendText(txtCreditcardNo, CreditCardno);
		Assert.assertEquals("Verify credit card number", getAttribute(txtCreditcardNo), CreditCardno);

		selectDDByVisibleText(findElementById("cc_type"), getDataFromExcel(fileLocation, "BookAHotelPage", 1, 4));
		selectDDByVisibleText(findElementById("cc_exp_month"), getDataFromExcel(fileLocation, "BookAHotelPage", 1, 5));
		selectDDByVisibleText(findElementById("cc_exp_year"), getDataFromExcel(fileLocation, "BookAHotelPage", 1, 6));
		sendText(findElementById("cc_cvv"), getDataFromExcel(fileLocation, "BookAHotelPage", 1, 7));
		clickButton(findElementById("book_now"));

		// Write Order No into Excel

		String orderNo = getAttribute(findElementById("order_no"));
		System.out.println("Order No: " + orderNo);
		Assert.assertEquals("Verify if order no is generated", false, orderNo.isEmpty());
		writeDataInCell(fileLocation, "BookingConfirmation", 3, 0, orderNo);

	}

}
