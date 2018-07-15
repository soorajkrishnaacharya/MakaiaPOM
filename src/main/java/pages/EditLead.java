package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.listeners.WebDriverListener;
import lib.selenium.WebDriverServiceImpl;

public class EditLead extends WebDriverServiceImpl {
	
	public EditLead(EventFiringWebDriver driver, ExtentTest test) {
		this.driver= driver;
		this.test= test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="updateLeadForm_companyName")
	WebElement eleCompanyName;
	
	@FindBy(id="updateLeadForm_firstName")
	WebElement eleFirstName;
	
	@FindBy(id="updateLeadForm_lastName")
	WebElement eleLastName;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement eleUpdateBtn;
	
	
	public EditLead typeCompanyName(String companyName ) {
		clear(eleCompanyName);
		type(eleCompanyName, companyName);
		return this;
	}
	
	public EditLead typeFirstName(String firstName ) {
		clear(eleFirstName);
		type(eleFirstName, firstName);
		return this;
	}
	
	public EditLead typeLastName(String lastName ) {
		clear(eleLastName);
		type(eleLastName, lastName);
		return this;
	}
	
	public ViewLead clickUpdateBtn() {
		click(eleUpdateBtn);
		return new ViewLead(driver, test);
	}
	

}
