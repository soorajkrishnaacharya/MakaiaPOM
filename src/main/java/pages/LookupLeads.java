package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class LookupLeads extends WebDriverServiceImpl {
	
	public LookupLeads(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//input[@name='id']")
	WebElement eleLeadIDTxt;
	
	public LookupLeads typeLeadID(String leadID) {
		type(eleLeadIDTxt, leadID);
		return this;
	}
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsBtn;
	
	public LookupLeads clickFindLeadsButton() {
		click(eleFindLeadsBtn);
		return this;
	}
	
	@FindBy(xpath="((//table[@class='x-grid3-row-table'])[1]//a)[1]")
	WebElement eleFirstLeadResultIDLink;
	
	public MergeLeads clickFirstLeadResultIDLink() throws InterruptedException {
		//Thread.sleep(5000);
		
		explicitlyWait(eleFirstLeadResultIDLink, 10);
		click(eleFirstLeadResultIDLink);
		switchToWindow(0);
		return new MergeLeads(driver, test);
	}
	

}
