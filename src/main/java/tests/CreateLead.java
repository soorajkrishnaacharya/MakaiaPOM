package tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.reader.ReadExcel;
import lib.selenium.WebDriverServiceImpl;
import pages.MyHome;

public class CreateLead extends PreAndPost{

	@BeforeTest
	public void setValue() {

		testCaseName = "CreateLead";
		testDesc = "To create a new Lead";
		nodeName = "Lead";
		author = "Sooraj";
		category = "qa";
		excelName = "CreateLead";
	}

	//invocationCount=2,
	//groups= {"smoke"},
	//(  dataProvider= "QA", groups= {/*"common",*/"smoke"})
	@Test
	public void createLead(String companyName, String fName, String lName) {


		new MyHome(driver, test)
		.clickLeads()
		.clickCreateLead()
		.typeCompanyName(companyName)
		.typeFirstName(fName)
		.typeLastName(lName)
		.clickCreateLeadBtn()
		.verifyCompanyText(companyName);
		


		/*WebElement eleCreateLead = locateElement("xpath","//a[text()='Create Lead']");
		click(eleCreateLead);



		WebElement eleCompanyName = locateElement("id","createLeadForm_companyName");
		type(eleCompanyName,companyName);

		WebElement eleFirstName = locateElement("id", "createLeadForm_firstName");
		type(eleFirstName, fName);*/

		/*WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName, lName);

		WebElement source = locateElement("id", "createLeadForm_dataSourceId");
		selectDropDownUsingIndex(source,40);

		WebElement eleBtnCreateLead = locateElement("xpath","//input[@value='Create Lead']");
		click(eleBtnCreateLead);*/



	}

	/*//, indices= {1}
	@DataProvider(name="QA")
	public String[][] getData() throws IOException {

		ReadExcel input = new ReadExcel();
		String[][] data = input.readExcel("CreateLead");


		String[][] data = new String[2][3];
		data[0][0]="SoorajFoods";
		data[0][1]="Sooraj";
		data[0][2]="Krishna";

		data[1][0]="JayavelFoods";
		data[1][1]="Jayavel";
		data[1][2]="Sivan";

		return data;

	}
	 */
}




