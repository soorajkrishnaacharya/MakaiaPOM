package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;
import pages.FindLeads;
import pages.MyHome;

public class DeleteLead extends PreAndPost {
	//dependsOnMethods =  {"tests.CreateLead.createLead"},
	//groups= {"sanity"},
	//dependsOnMethods =  {"tests.CreateLead.createLead"},
	//(  alwaysRun = true, groups= {"common","sanity"})
	
	
	@BeforeTest
	public void setValue() {

		testCaseName = "DeleteLead";
		testDesc = "To delete a new Lead";
		nodeName = "Lead";
		author = "Sooraj";
		category = "qa";
		excelName = "CreateLead";
	}

	@Test
	public void deleteLead() throws InterruptedException{
		
	FindLeads objFindLeads = new MyHome(driver, test)
		.clickLeads()
		.clickFindLeadsLink()
		.clickPhoneTab()
		.typePhoneNumber("9")
		.clickFindLeadsBtn();
	
	String textFirstResultingLead = objFindLeads.getTextFirstResultingLead();
	
	objFindLeads.clickFirstLeadResultIDLink()
	.clickDeleteLead()
	.clickFindLeadsLink()
	.typeLeadId(textFirstResultingLead)
	.clickFindLeadsBtn()
	.verifyLeadListMessage("No");
	
		
		
		
		
				
		/*WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);
		
		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);
		
		WebElement elePhone = locateElement("xpath", "//span[text()='Phone']");
		click(elePhone);
		
		WebElement elePhoneNumber = locateElement("name", "phoneNumber");
		type(elePhoneNumber, "9874898748");
		
		WebElement eleFindLeadsBtn = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsBtn);
		
		WebElement eleFirstLeadResult = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		String text = getText(eleFirstLeadResult);
		System.out.println("First Lead result id is : "+text);
		click(eleFirstLeadResult);
		
		
		WebElement eleDeleteButton = locateElement("xpath", "//a[text()='Delete']");
		click(eleDeleteButton);
		
		
		WebElement eleFindLeadsLink = locateElement("xpath", "//a[text()='Find Leads']");
		click(eleFindLeadsLink);
		
		
		WebElement eleLeadIdTxtBox = locateElement("name", "id");
		type(eleLeadIdTxtBox, text);
		
		
		
		WebElement eleFindLeadsBtn1 = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsBtn1);
		
		
		WebElement eleResultsLabel = locateElement("xpath", "//div[@class='x-paging-info']");
		String resultsLabelTxt = getText(eleResultsLabel);
		System.out.println("After delete operation, the results fetched:"+resultsLabelTxt);*/
		
		
		
		
		
		
		
		
	}

}
