package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;
import pages.MyHome;
import pages.MyLeads;

public class MergeLeads extends PreAndPost {
	
	@BeforeTest
	public void setValue() {

		testCaseName = "MergeLeads";
		testDesc = "To merge 2 leads";
		nodeName = "Lead";
		author = "Sooraj";
		category = "qa";
		excelName = "CreateLead";
	}

	@Test(groups= {"common","regression"})
	public void mergeLeads() throws InterruptedException  {

		
		new MyHome(driver, test)
		.clickLeads()
		.clickMergeLeadsLink()
		.clickEleFromLeadIcon()
		.typeLeadID("10196")
		.clickFindLeadsButton()
		.clickFirstLeadResultIDLink()
		.clickEleToLeadIcon()
		.typeLeadID("10199")
		.clickFindLeadsButton()
		.clickFirstLeadResultIDLink()
		.clickMergeLeadsBtn();
		
		new MyLeads(driver, test)
		.clickFindLeadsLink()
		.typeLeadId("10196")
		.clickFindLeadsBtn()
		.verifyLeadListMessage("No");
		
		
		
		/*WebElement eleLeadsLink = locateElement("xpath", "//a[text()='Leads']");
		click(eleLeadsLink);

		WebElement eleMergeLeadsLink = locateElement("xpath", "//a[text()='Merge Leads']");
		click(eleMergeLeadsLink);

		WebElement eleFromLeadIcon = locateElement("xpath", "//span[text()='From Lead']/following::img");
		click(eleFromLeadIcon);

		//Thread.sleep(3000);
		switchToWindow(1);

		WebElement eleLeadID = locateElement("xpath", "//input[@name='id']");
		type(eleLeadID, "10045");

		WebElement eleFindLeadsBtn = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsBtn);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")));
		
		//explicitlyWait("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]", 10);
		WebElement eleFirstResultLead = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(eleFirstResultLead));
		explicitlyWait(eleFirstResultLead, 10);
		
		
		click(eleFirstResultLead);

		switchToWindow(0);
		
		
		WebElement eleToLeadIcon = locateElement("xpath", "//span[text()='To Lead']/following::img");
		click(eleToLeadIcon);

		switchToWindow(1);
		
		WebElement eleLeadID1 = locateElement("xpath", "//input[@name='id']");
		type(eleLeadID1, "10046");

		WebElement eleFindLeadsBtn1 = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsBtn1);

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")));
		
		explicitlyWait("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]", 10);
		WebElement eleFirstResultLead1 = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(eleFirstResultLead1));
		//explicitlyWait(eleFirstResultLead1, 10);
		click(eleFirstResultLead1);
		
		
		Thread.sleep(3000);
		
		switchToWindow(0);
		
		
		WebElement eleMergeLeads = locateElement("xpath", "//a[text()='Merge']");
		click(eleMergeLeads);
		
		Thread.sleep(3000);
		acceptAlert();
		
		
		WebElement eleFindLeads = locateElement("xpath", "//a[text()='Find Leads']");
		click(eleFindLeads);
		
		WebElement eleLeadID2 = locateElement("xpath", "//input[@name='id']");
		type(eleLeadID2, "10045");

		WebElement eleFindLeadsBtn2 = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsBtn2);
		
		
		WebElement eleMessage = locateElement("xpath", "//div[@class='x-paging-info']");
		verifyPartialText(eleMessage, "No");
*/

	}

}
