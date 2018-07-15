package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.listeners.WebDriverListener;
import lib.selenium.WebDriverServiceImpl;

public class ViewLead extends WebDriverServiceImpl {
	
	public ViewLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver= driver;
		this.test= test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="viewLead_companyName_sp")
	WebElement eleCompanyNameText;
	
	public void verifyCompanyText(String expectedText) {
		verifyPartialText(eleCompanyNameText,expectedText);
	}
	
	@FindBy(xpath="//a[text()='Duplicate Lead']")
	WebElement eleDuplicateLead;
	
	public DuplicateLead clickDuplicateLead() {
		click(eleDuplicateLead);
		return new DuplicateLead(driver, test);
	}
	
	@FindBy(xpath="//a[text()='Delete']")
	WebElement eleDeleteLead;
	
	public MyLeads clickDeleteLead() {
		click(eleDeleteLead);
		return new MyLeads(driver, test);
	}
	
	@FindBy(xpath="//a[text()='Edit']")
	WebElement eleEditLead;
	
	public EditLead clickEditLead() {
		click(eleEditLead);
		return new EditLead(driver, test);
	}
	
	
	

}
