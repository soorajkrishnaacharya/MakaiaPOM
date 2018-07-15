package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.listeners.WebDriverListener;
import lib.selenium.WebDriverServiceImpl;

public class CreateLead extends WebDriverServiceImpl {
	
	public CreateLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver= driver;
		this.test= test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompanyName;
	
	public CreateLead typeCompanyName(String companyName ) {
		type(eleCompanyName, companyName);
		return this;
	}
	
	@FindBy(id="createLeadForm_firstName")
	WebElement eleFirstName;
	
	public CreateLead typeFirstName(String firstName ) {
		type(eleFirstName, firstName);
		return this;
	}
	
	@FindBy(id="createLeadForm_lastName")
	WebElement eleLastName;
	
	public CreateLead typeLastName(String lastName ) {
		type(eleLastName, lastName);
		return this;
	}
	
	@FindBy(xpath="//input[@value='Create Lead']")
	WebElement eleCreateLeadBtn;	

	public ViewLead clickCreateLeadBtn() {
		click(eleCreateLeadBtn);
		return new ViewLead(driver, test);
	}
	

}
