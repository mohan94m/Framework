package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class SelectAHotelPage extends BaseClass{
	public SelectAHotelPage() {
	
	PageFactory.initElements(driver, this);
	}

	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	@FindBy(id="continue")
	private WebElement btnContinue;
	@FindBy(id="cancel")
	private WebElement btnCancel;
	public WebElement getBtnRadio() {
		return btnRadio;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	public WebElement getBtnCancel() {
		return btnCancel;
	}
	public void selectAhotel() {
		clickButton(getBtnRadio());
		clickButton(getBtnContinue());
	}
		
}
