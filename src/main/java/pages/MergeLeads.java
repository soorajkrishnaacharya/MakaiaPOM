package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class MergeLeads extends WebDriverServiceImpl {
	
	public MergeLeads(EventFiringWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//span[text()='From Lead']/following::img")
	WebElement eleFromLeadIcon;
	
	public LookupLeads clickEleFromLeadIcon() {
		click(eleFromLeadIcon);
		switchToWindow(1);
		return new LookupLeads(driver,test);
	}
	
	@FindBy(xpath="//span[text()='To Lead']/following::img")
	WebElement eleToLeadIcon;
	
	public LookupLeads clickEleToLeadIcon() {
		click(eleToLeadIcon);
		switchToWindow(1);
		return new LookupLeads(driver,test);
	}
	
	
	@FindBy(xpath="//a[text()='Merge']")
	WebElement eleMergeLeadsBtn;
	
	public ViewLead clickMergeLeadsBtn() {	
		click(eleMergeLeadsBtn);
		acceptAlert();
		return new ViewLead(driver, test);		
	}
	

}
