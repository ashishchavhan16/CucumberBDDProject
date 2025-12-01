package StepDefination;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.CheckEligibility;
import PageObject.LoginPage;
import Utilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	public LoginPage loginPg;
	public CheckEligibility chkEligibility;
	public static Logger log;
	public ReadConfig readConfig;
}
