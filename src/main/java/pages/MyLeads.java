package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.listeners.WebDriverListener;
import lib.selenium.WebDriverServiceImpl;

public class MyLeads extends WebDriverServiceImpl {
	
	public MyLeads(EventFiringWebDriver driver, ExtentTest test) {
		this.driver= driver;
		this.test= test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Create Lead']")
	WebElement eleCreateLead;
	
	public CreateLead clickCreateLead() {
		click(eleCreateLead);
		return new CreateLead(driver, test);
	}
	
	@FindBy(xpath="//a[text()='Find Leads']")
	WebElement eleFindLeadsLink;
	
	public FindLeads clickFindLeadsLink() {
		click(eleFindLeadsLink);
		return new FindLeads(driver, test);	
	}
	
	@FindBy(xpath="//a[text()='Merge Leads']")
	WebElement eleMergeLeadsLink;
	
	public MergeLeads clickMergeLeadsLink() {
		click(eleMergeLeadsLink);
		return new MergeLeads(driver, test);	
	}

	
	
	

}
