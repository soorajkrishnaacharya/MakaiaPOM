package bdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lib.selenium.WebDriverServiceImpl;

public class Hooks extends WebDriverServiceImpl{
	
	@Before
	public void beforeScenario(Scenario sc) {
		
		/*startTestModule();
		  test.assignAuthor(author);
		  test.assignCategory(category);*/
		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			webdriver = new ChromeDriver();
			
			driver = new EventFiringWebDriver(webdriver);
			driver.register(this);
			
			
			driver.manage().window().maximize();
			/*driver.get(url);
			//driver.get("https://flipkart.com");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			WebElement eleUserName = locateElement("id", "username");
			type(eleUserName, uName);
			
			WebElement elePassword = locateElement("id", "password");
			type(elePassword, password);
			
			WebElement eleLogin = locateElement("class", "decorativeSubmit");
			click(eleLogin);*/
			
			/*WebElement eleCRM = locateElement("link", "CRM/SFA");
			click(eleCRM);
*/
	}
	@After
	public void afterScenario(Scenario sc) {
		System.out.println(sc.getStatus());
		System.out.println(sc.isFailed());
	}

}
