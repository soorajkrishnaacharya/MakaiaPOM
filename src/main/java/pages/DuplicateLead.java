package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.listeners.WebDriverListener;
import lib.selenium.WebDriverServiceImpl;

public class DuplicateLead extends WebDriverServiceImpl {
	
	public DuplicateLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver= driver;
		this.test= test;
		PageFactory.initElements(driver, this);
	}
	

	
	public boolean verifyPartialTitle() {
		return verifyPartialTitle("Duplicate");
	}
	
	@FindBy(xpath="//input[@value='Create Lead']")
	WebElement eleCreateLeadBtn;
	
	public ViewLead clickCreateLeadBtn() throws InterruptedException {
		click(eleCreateLeadBtn);
		Thread.sleep(2000);
		return new ViewLead(driver, test);
	}
	

}
