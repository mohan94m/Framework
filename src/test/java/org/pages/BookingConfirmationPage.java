package org.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class BookingConfirmationPage extends BaseClass{
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);}
	@FindBy(id="order_no")
	private WebElement txtOrderNo;
	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}
	@FindBy(xpath="//a[contains(text(),'Booked Itinerary')]")
	private WebElement lnkBookedItry;
	
	public WebElement getLnkBookedItry() {
		return lnkBookedItry;
	}
	public void bookingConfirmation() throws IOException {
		String fileLocation = "D:\\Mohan\\Framework\\DataDrivenFramework\\Excel\\AdactinOrderBooking.xlsx";
		String orderNo = getAttribute(getTxtOrderNo());
		System.out.println("Order No: " + orderNo);
		Assert.assertEquals("Verify if order no is generated", false, orderNo.isEmpty());
		writeDataInCell(fileLocation, "BookingConfirmation", 3, 0, orderNo);

	}
	
	public void clicklnkBookedItry() {
		clickButton(getLnkBookedItry());
		}
	
}
