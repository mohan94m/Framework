package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class CancelBookingPage extends BaseClass {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);}
	@FindBy(xpath="(//input[contains(@value,'Cancel')])[1]")
	private WebElement btnCancelOrder;

	public WebElement getBtnCancelOrder() {
		return btnCancelOrder;
	}
	
	public void cancelOrder() {
	   clickButton(getBtnCancelOrder());
	   acceptAlert();
	}

}
