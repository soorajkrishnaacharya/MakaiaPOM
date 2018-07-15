package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;
import pages.FindLeads;
import pages.MyHome;

public class DuplicateLead extends PreAndPost {
	
	@BeforeTest
	public void setValue() {

		testCaseName = "Duplicate";
		testDesc = "To duplicate a  Lead";
		nodeName = "Lead";
		author = "Sooraj";
		category = "qa";
		excelName = "CreateLead";
	}
	
	@Test
	public void duplicateLead() throws InterruptedException {
				
		FindLeads objFindLeads = new MyHome(driver, test)
		.clickLeads()
		.clickFindLeadsLink()
		.clickEmailTab()
		.typeEmail("s")
		.clickFindLeadsBtn();
		
		String textFirstResultingCompanyName = objFindLeads.getTextFirstResultingCompanyName();
		
		pages.DuplicateLead objDuplicateLead = objFindLeads.clickFirstLeadResultIDLink()
		.clickDuplicateLead();
		
		boolean verifyPartialTitle = objDuplicateLead.verifyPartialTitle();
		
		System.out.println("The page partial title is duplicate: "+verifyPartialTitle);
		
		objDuplicateLead.clickCreateLeadBtn()
		.verifyCompanyText(textFirstResultingCompanyName);
		
		/*WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);
		
		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);
		
		WebElement eleEmailLink = locateElement("xpath", "//span[text()='Email']");
		click(eleEmailLink);
		
		WebElement eleEmail = locateElement("name", "emailAddress");
		type(eleEmail, "sooraj@gmail.com");
		
		WebElement eleFindLeadsBtn = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsBtn);
		
		
		WebElement eleFirstResultingLead = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]");
		String nameOfFirstLead = getText(eleFirstResultingLead);
		System.out.println("Name of First Resulting lead : "+nameOfFirstLead);
		click(eleFirstResultingLead);
		
		
		WebElement eleDuplicateLeadlink = locateElement("xpath", "//a[text()='Duplicate Lead']");
		click(eleDuplicateLeadlink);
		
		
		System.out.println(verifyPartialTitle("Duplicate"));
		
		
		
		WebElement eleCreateLeadBtn = locateElement("xpath", "//input[@value='Create Lead']");
		click(eleCreateLeadBtn);
		
		WebElement eleDupLeadName = locateElement("id", "viewLead_firstName_sp");
		verifyExactText(eleDupLeadName,nameOfFirstLead);
*/		
		
	}

}
