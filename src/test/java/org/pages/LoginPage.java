package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class LoginPage extends BaseClass {
public LoginPage() {
	PageFactory.initElements(driver, this);}

	@FindBy(id = "username")
	private WebElement txtUserName;
	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "login")
	private WebElement btnLogin;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void login(String username, String password) {
		sendText(getTxtUserName(), username);
		sendText(getTxtPassword(), password);
		clickButton(getBtnLogin());
	}

}
