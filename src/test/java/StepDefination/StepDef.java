package StepDefination;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageObject.CheckEligibility;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass{
	
	@Before(order = 1)
	public void setUp() throws FileNotFoundException {
//		WebDriverManager.chromedriver().setup();
//	    driver = new ChromeDriver();
		
	    System.out.println("this is Setup method");
	    log = LogManager.getLogger("StepDef");
	    log.info("Setup1 Executed");
	    readConfig = new ReadConfig();
	    String browser = readConfig.getBrowser();
	    
	    switch(browser.toLowerCase()) {
	    case "chrome" :
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	break;
	    	
	    case "edge" :
	    	WebDriverManager.edgedriver().setup();
	    	driver = new EdgeDriver();
	    	
	    case "firefox" :
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    	
	    default :
	    	driver = null;
	    	break;
	    }
	}
	
//	@Before(order = 1)
//	public void setUp1() {
//		WebDriverManager.chromedriver().setup();
//	    driver = new ChromeDriver();
//	    System.out.println("this is Setup method");
//	}
	
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
//		WebDriverManager.chromedriver().clearDriverCache();
	    
	    loginPg = new LoginPage(driver);
	    chkEligibility = new CheckEligibility(driver);
	    log.info("Natigate to browser.........");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String urlLink) {
	    driver.get(urlLink);
	    log.info("URL Opened...........");
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String emailId, String pwd) {
		loginPg.enterEmail(emailId);
		loginPg.enterPassword(pwd);
		log.info("Credentials Entered...........");
	}

	@When("Click on Login")
	public void click_on_login() {
	    loginPg.loginBtnClick();
	    log.info("Clicked login Entered...........");
	}

	@Then("Title page should be {string}")
	public void title_page_should_be(String expectedTitle) {
	    String actualTitle = driver.getTitle();
	    
	    if(actualTitle.equals(expectedTitle)) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertTrue(false);
	    }
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	    loginPg.logOutBtnClick();
	}

/*	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	} */
	
	//====================================Eligibility==================================
	
	@When("User clicks on Eligibility")
	public void user_clicks_on_eligibility() {
		chkEligibility.clickEliigibility();
	}

	@When("User Click on Check Eligibility Button")
	public void user_click_on_check_eligibility_button() {
		chkEligibility.clickChkEligibility();
	}

//	@When("User selects Eligibility Purpose")
//	public void user_selects_as_eligibility_purpose(String string) {
//		chkEligibility.clickDD();
//		chkEligibility.clickAuth();
//		chkEligibility.clickBenifit();
//	}
//
//	@When("User clicks on Next button")
//	public void user_clicks_on_next_button() {
//		chkEligibility.clickNxt();
//	}
	
	@After
	public void tearDown() {
		driver.quit();
		System.out.println("This is After Annotaton");
	}
	
	@AfterStep(order = 1)
	public void addScreenshot(Scenario scenario) {

	    if (scenario.isFailed()) {

	        final byte[] screenshot = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.BYTES);

	        // attach image file to the report (data, media type, name)
	        scenario.attach(screenshot, "image/png", scenario.getName());
	    }
	}

	@AfterStep(order = 2)
	public void beforeStep() {
		System.out.println("this is before Step");
	}
	
	@BeforeStep
	public void afterStep() {
		System.out.println("this is before Step");
	}

}
