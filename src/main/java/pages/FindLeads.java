package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.listeners.WebDriverListener;
import lib.selenium.WebDriverServiceImpl;

public class FindLeads extends WebDriverServiceImpl {
	
	public FindLeads(EventFiringWebDriver driver, ExtentTest test) {
		this.driver= driver;
		this.test= test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='id']")
	WebElement eleLeadId;
	
	public FindLeads typeLeadId(String leadId) {
		type(eleLeadId, leadId);
		return this;
	}
	
	@FindBy(xpath="(//input[@name='firstName'])[3]")
	WebElement eleFirstName;
	
	public FindLeads typeFirstName(String firstName) {
		type(eleFirstName, firstName);
		return this;
	}
	
	@FindBy(xpath="(//input[@name='lastName'])[3]")
	WebElement eleLastName;
	
	public FindLeads typeLastName(String lastName) {
		type(eleLastName, lastName);
		return this;
	}
	
	@FindBy(xpath="(//input[@name='companyName'])[2]")
	WebElement eleCompanyName;
	
	public FindLeads typeCompanyName(String companyName) {
		type(eleCompanyName, companyName);
		return this;
	}
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsBtn;
	
	public FindLeads clickFindLeadsBtn() throws InterruptedException {
		click(eleFindLeadsBtn);
		Thread.sleep(2000);
		return this;
	}
	
	

	
	@FindBy(xpath="//span[text()='Phone']")
	WebElement phoneTab;
	
	public FindLeads clickPhoneTab() {
		click(phoneTab);
		return this;
	}
	
	@FindBy(xpath="//span[text()='Email']")
	WebElement emailTab;
	
	public FindLeads clickEmailTab() {
		click(emailTab);
		return this;
	}
	
	@FindBy(name="phoneNumber")
	WebElement txtPhoneNumber;
	
	public FindLeads typePhoneNumber(String phoneNumber) {
		type(txtPhoneNumber, phoneNumber);
		return this;
	}
	
	@FindBy(name="emailAddress")
	WebElement txtEmailAddress;
	
	public FindLeads typeEmail(String emailAddress) {
		type(txtEmailAddress, emailAddress);
		return this;
	}
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement firstResultingLeadId;
	
	public String getTextFirstResultingLead() {
		String text = getText(firstResultingLeadId);
		System.out.println("The first resulting lead id "+text);
		return text;
	}
	
	@FindBy(xpath="((//table[@class='x-grid3-row-table'])[1]//a)[5]")
	WebElement firstResultingCompanyName;
	
	public String getTextFirstResultingCompanyName() {
		String text = getText(firstResultingCompanyName);
		System.out.println("The first resulting company name "+text);
		return text;
	}
	
	@FindBy(xpath="((//table[@class='x-grid3-row-table'])[1]//a)[1]")
	WebElement eleFirstLeadResultIDLink;
	
	public ViewLead clickFirstLeadResultIDLink() throws InterruptedException {
		//Thread.sleep(5000);
		
		explicitlyWait(eleFirstLeadResultIDLink, 10);
		click(eleFirstLeadResultIDLink);
		return new ViewLead(driver, test);
	}
	
	
	@FindBy(xpath="((//table[@class='x-grid3-row-table'])[1]//a)[5]")
	WebElement eleFirstLeadResultCompanyNameLink;
	
	public ViewLead clickFirstLeadResultCompanyNameLink() throws InterruptedException {
		//Thread.sleep(5000);
		
		explicitlyWait(eleFirstLeadResultCompanyNameLink, 10);
		click(eleFirstLeadResultCompanyNameLink);
		return new ViewLead(driver, test);
	}
	
	
	@FindBy(xpath="//div[@class='x-paging-info']")
	WebElement eleLeadListMessage;
	
	public void verifyLeadListMessage(String expectedtext) {
		verifyPartialText(eleLeadListMessage, expectedtext);
	}
	
	
	
	
	
	

}
