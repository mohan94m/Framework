package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class BookAHotelPage extends BaseClass {
public BookAHotelPage() {
	PageFactory.initElements(driver, this);}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	@FindBy(id = "address")
	private WebElement txtBillingAddress;
	@FindBy(id = "cc_num")
	private WebElement txtCreditCardNumber;
	@FindBy(id = "cc_type")
	private WebElement ddCreditCardType;
	@FindBy(id = "cc_exp_month")
	private WebElement ddExpMonth;
	@FindBy(id = "cc_exp_year")
	private WebElement ddExpYear;
	@FindBy(id = "cc_cvv")
	private WebElement txtCvvNumber;
	@FindBy(id = "book_now")
	private WebElement btnBookNow;
	@FindBy(id = "cancel")
	private WebElement btnCancel;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtBillingAddress() {
		return txtBillingAddress;
	}

	public WebElement getTxtCreditCardNumber() {
		return txtCreditCardNumber;
	}

	public WebElement getDdCreditCardType() {
		return ddCreditCardType;
	}

	public WebElement getDdExpMonth() {
		return ddExpMonth;
	}

	public WebElement getDdExpYear() {
		return ddExpYear;
	}

	public WebElement getTxtCvvNumber() {
		return txtCvvNumber;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public void searchAHotel(String firstName, String lastName, String billingAddress, String creditCardNo,
			String creditCardType, String expMonth, String expYear, String cvvNo) {

		sendText(getTxtFirstName(), firstName);

		sendText(getTxtLastName(), lastName);

		sendText(getTxtBillingAddress(), billingAddress);

		sendText(getTxtCreditCardNumber(), creditCardNo);

		selectDDByVisibleText(getDdCreditCardType(),creditCardType);
		selectDDByVisibleText(getDdExpMonth(), expMonth);
		selectDDByVisibleText(getDdExpYear(), expYear);
		sendText(getTxtCvvNumber(), cvvNo);
		clickButton(getBtnBookNow());
	}

}
