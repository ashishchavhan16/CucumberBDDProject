package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id = "username")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(xpath = "//span[@class='p-button-label ng-star-inserted']")
	WebElement loginBtn;
	
	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[6]")
	WebElement logOutBtn;
	
	//============================================
	
	public void enterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String passWord) {
		pass.clear();
		pass.sendKeys(passWord);
	}
	
	public void loginBtnClick() {
		loginBtn.click();
	}
	
	public void logOutBtnClick() throws InterruptedException {
		Thread.sleep(4000);
		logOutBtn.click();
	}
}
