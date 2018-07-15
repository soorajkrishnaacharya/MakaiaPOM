package tests;

import org.testng.annotations.Test;

import data.reader.ReadExcel;
import lib.selenium.WebDriverServiceImpl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PreAndPost extends WebDriverServiceImpl {
	
	String testCaseName,testDesc,nodeName,author,category,excelName;
	
  @Parameters({"url","uName","passWord"})	
  @BeforeMethod(groups= {"common"})
  public void beforeMethod(String url, String uName, String password) {
	  
	  startTestModule(nodeName);
	  test.assignAuthor(author);
	  test.assignCategory(category);
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		
		
		driver.manage().window().maximize();
		driver.get(url);
		//driver.get("https://flipkart.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, uName);
		
		WebElement elePassword = locateElement("id", "password");
		type(elePassword, password);
		
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
  }

  @AfterMethod(groups= {"common"})
  public void afterMethod() {
	 System.out.println("afterMethod"); 
	 driver.close();
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass"); 
	  startTestCase(testCaseName,testDesc);
	  /*String className = getClass().getName();
	  
	  if(className.equals("tests.CreateLead"))
		  startTestCase("TC_01", "Create a new Lead under LeafTaps");
	  
	  if(className.equals("tests.DeleteLead"))
		  startTestCase("TC_02", "Delete a Lead under LeafTaps");*/
	  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass"); 
	  //driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest"); 
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest"); 
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite"); 
	  
	  startResult();
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite"); 
	  endResult();
  }

  @DataProvider(name="QA")
  public String[][] getData() throws IOException {
		
		ReadExcel input = new ReadExcel();
		String[][] data = input.readExcel(excelName);
		return data;
  }
}
