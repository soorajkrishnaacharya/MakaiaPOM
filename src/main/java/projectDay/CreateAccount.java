package projectDay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class CreateAccount extends WebDriverServiceImpl {
	
	@Test
	public void createAccount() throws InterruptedException {
		
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		
		//a[text()='Accounts']
		//Click on Accounts link
		WebElement eleAccounts = locateElement("xpath", "//a[text()='Accounts']");
		click(eleAccounts);
		
		//Click on Create Account
		WebElement eleCreateAccount = locateElement("xpath", "//a[text()='Create Account']");
		click(eleCreateAccount);
		
		//input[@id='accountName']
		//Enter Account name
		WebElement eleAccountName = locateElement("id", "accountName");
		type(eleAccountName, "SoorajI12345");
		
		//select[@name='industryEnumId']
		//Select Industry by visible text
		WebElement eleSelectIndustry = locateElement("xpath", "//select[@name='industryEnumId']");
		selectDropDownUsingVisibleText(eleSelectIndustry, "Health Care");
		
		//Select preferred currency
		//select[@id='currencyUomId']
		WebElement eleSelectPreferredCurrency = locateElement("xpath", "//select[@id='currencyUomId']");
		selectDropDownUsingValue(eleSelectPreferredCurrency, "INR");
		
		//Select Source
		//select[@id='dataSourceId']
		WebElement eleSource = locateElement("xpath", "//select[@id='dataSourceId']");
		selectDropDownUsingValue(eleSource, "LEAD_PR");
		
		//select[@id='marketingCampaignId']
		//Select Marketing campaign
		WebElement eleMarketingCampaign = locateElement("xpath", "//select[@id='marketingCampaignId']");
		selectDropDownUsingIndex(eleMarketingCampaign, 3);
		
		//Enter Phone Number
		WebElement eleAccPhoneNumber = locateElement("xpath", "//input[@id='primaryPhoneNumber']");
		type(eleAccPhoneNumber, "9486500949");
		
		//Enter city
		//input[@id='generalCity']
		WebElement eleAccCity = locateElement("xpath", "//input[@id='generalCity']");
		type(eleAccCity, "Salem");
		
		//input[@id='primaryEmail']
		//Enter Email Address
		WebElement eleAccEmail = locateElement("xpath", "//input[@id='primaryEmail']");
		type(eleAccEmail, "soorajkrishna@gmail.com");
		
		//select[@id='generalCountryGeoId']
		//Select Country
		WebElement eleAccCountry = locateElement("xpath", "//select[@id='generalCountryGeoId']");
		selectDropDownUsingVisibleText(eleAccCountry, "India");
		
		//Select State
		//select[@id='generalStateProvinceGeoId']
		WebElement eleAccState = locateElement("xpath", "//select[@id='generalStateProvinceGeoId']");
		selectDropDownUsingValue(eleAccState, "IN-TN");
		
		//input[@value='Create Account']
		//Click on Create Account
		WebElement eleBtnCreateAccount = locateElement("xpath", "//input[@value='Create Account']");
		click(eleBtnCreateAccount);
		
		WebElement eleAccountID = locateElement("xpath", "//span[text()='Account Name']/following::span[1]");
		String eleAccountNameAndID = getText(eleAccountID);
		
		String[] split = eleAccountNameAndID.split("\\(");
		String txtAccName= split[0];
		String txtAccountID = split[1].replaceAll("\\D", "");
		System.out.println(txtAccName);
		System.out.println(txtAccountID);
		
		//Click on Find Accounts
		//a[text()='Find Accounts']
		WebElement eleFindAccounts = locateElement("xpath", "//a[text()='Find Accounts']");
		click(eleFindAccounts);
		
		//input[@name='id']
		//Enter Account id 
		WebElement eleAccountIDText = locateElement("xpath", "//input[@name='id']");
		type(eleAccountIDText, txtAccountID);
		
		//Enter Account Name
		WebElement eleAccountNameText = locateElement("xpath", "//input[@name='id']/following::input[@name='accountName']");
		type(eleAccountNameText, "SoorajI12345");
		
		//Click on Find Accounts
		//button[text()='Find Accounts']
		WebElement elebtnFindAccounts = locateElement("xpath", "//button[text()='Find Accounts']");
		click(elebtnFindAccounts);
		
		//div[@class='x-grid3-cell-inner x-grid3-col-partyId']
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']")));
		
		//Thread.sleep(5000);
		WebElement accountID = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		click(accountID);
		
		//span[text()='Industry']/following::span
		WebElement industryText = locateElement("xpath", "//span[text()='Industry']/following::span");
		verifyExactText(industryText, "Health Care");
		
		//driver.close();
		
		
		
		
	}
	
	

}
