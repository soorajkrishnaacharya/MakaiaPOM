package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;
import pages.MyHome;

public class EditLead extends PreAndPost {
	
	@BeforeTest
	public void setValue() {
		
		testCaseName = "EditLead";
		testDesc = "To edit a  Lead";
		nodeName = "Lead";
		author = "Sooraj";
		category = "qa";
		excelName = "EditLead";
	}
	//dependsOnMethods = {"tests.CreateLead.createLead"},
	//groups= {/*"common",*/"sanity"}
	//,dependsOnMethods = {"tests.CreateLead.createLead"},  description = "To edit the existing lead")
	@Test( dataProvider="QA")
	public void editLead(String existingFirstName, String companyName, String firstName, String lastName) throws InterruptedException {
		
		new MyHome(driver, test)
		.clickLeads()
		.clickFindLeadsLink()
		.typeFirstName(existingFirstName)
		.clickFindLeadsBtn()
		.clickFirstLeadResultIDLink()
		.clickEditLead()
		.typeCompanyName(companyName)
		.typeFirstName(firstName)
		.typeLastName(lastName)
		.clickUpdateBtn()
		.verifyCompanyText(companyName);
		
		
		/*WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);
		
		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);
		
		WebElement eleFirstName = locateElement("xpath","//label[text()='Lead ID:']/following::input[@name='firstName']");
		//clear(eleFirstName);
		type(eleFirstName, existingFirstName);
		
		WebElement eleBtnFindLeads = locateElement("xpath","//button[text()='Find Leads']");
		click(eleBtnFindLeads);
		
		Thread.sleep(5000);
		WebElement eleFirstResultingLead = locateElement("xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		click(eleFirstResultingLead);
		
		verifyPartialTitle("View");
		
		WebElement eleEditLink = locateElement("xpath","//a[text()='Edit']");
		click(eleEditLink);
		
		WebElement eleCompanyName = locateElement("id", "updateLeadForm_companyName");
		clear(eleCompanyName);
		type(eleCompanyName, companyName);
		
		WebElement eleUpdateButton = locateElement("xpath","//input[@value='Update']");
		click(eleUpdateButton);
		
		WebElement eleCompanyNameLabel = locateElement("xpath","//span[@id='viewLead_companyName_sp']");
		verifyPartialText(eleCompanyNameLabel,"Sooraj");
		*/
		
	}
	

}
