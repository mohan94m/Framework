package org.test;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pages.BookAHotelPage;
import org.pages.BookingConfirmationPage;
import org.pages.LoginPage;
import org.pages.SearchHotelPage;
import org.pages.SelectAHotelPage;
import org.utility.BaseClass;

public class AdactinBooking extends BaseClass{

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
		String location = getDataFromExcel(fileLocation, "SearchHotelPage", 1, 0);
		String hotels = getDataFromExcel(fileLocation, "SearchHotelPage", 2, 1);
		 String roomType = getDataFromExcel(fileLocation, "SearchHotelPage", 2, 2);
		 String roomNos= getDataFromExcel(fileLocation, "SearchHotelPage", 2, 3);
		 String checkInDate = getDataFromExcel(fileLocation, "SearchHotelPage", 2, 4);
		 String checkOutDate = getDataFromExcel(fileLocation, "SearchHotelPage", 2, 5);
		 String adultRoom = getDataFromExcel(fileLocation, "SearchHotelPage", 2, 6);
		 String childRoom = getDataFromExcel(fileLocation, "SearchHotelPage", 2, 7);
		 String firstName = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 0);
		 String lastName = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 1);
		 String billingAddress = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 2);
		 String creditCardNo = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 3);
		 String creditCardType = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 4);
		 String expMonth = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 5);
		 String expYear = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 6);
		 String cvvNo = getDataFromExcel(fileLocation, "BookAHotelPage", 1, 7);
		 
		 LoginPage loginPage = new LoginPage();
		 loginPage.login(userName, password);
		 
		 SearchHotelPage searchHotelPage = new SearchHotelPage();
		 searchHotelPage.searchHotel(location, hotels, roomType, roomNos, checkInDate, checkOutDate, adultRoom, childRoom);
		 
		 SelectAHotelPage selectAHotelPage=new SelectAHotelPage();
		 selectAHotelPage.selectAhotel();
				 
		 
		BookAHotelPage bookAHotelPage= new BookAHotelPage();
		bookAHotelPage.searchAHotel(firstName, lastName, billingAddress, creditCardNo, creditCardType, expMonth, expYear, cvvNo);
		
		 BookingConfirmationPage bookingConfirmationPage=new BookingConfirmationPage();
		 bookingConfirmationPage.bookingConfirmation();
		 }
}
