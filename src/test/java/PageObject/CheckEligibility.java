package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CheckEligibility {

	WebDriver driver;

	public CheckEligibility(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}

	@FindBy(xpath = "(//span[@class='text ng-star-inserted'])[4]")
	WebElement eligibility;

	@FindBy(css=".p-button-label.ng-star-inserted")
	WebElement chkEligi;

	@FindBy(css = "div.p-multiselect-label-container")
	WebElement dropDownB;

	@FindBy(xpath = "//input[@aria-label='Benefits']")
	WebElement chkBenifit;

	@FindBy(xpath = "//input[@aria-label='Auth-Requirements']")
	WebElement chkAuth;
	
	@FindBy(xpath="//p-button[@label='Next']")
	WebElement nxt;

//==============================================================================================

	public void clickEliigibility() {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(eligibility)).click();
	}
	
	public void clickChkEligibility() {
		chkEligi.click();
	}
	
//	public void clickDD() {
//		dropDownB.click();
//	}
//	
//	public void clickBenifit() {
//		chkBenifit.click();		
//	}
//	public void clickAuth() {
//		chkAuth.click();
//	}
//	public void clickNxt() {
//		nxt.click();
//	}
}
