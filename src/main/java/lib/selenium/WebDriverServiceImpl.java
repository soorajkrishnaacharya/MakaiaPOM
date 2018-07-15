package lib.selenium;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locValue));

			case "class": return driver.findElement(By.className(locValue));

			case "link" : return driver.findElement(By.linkText(locValue));

			case "xpath": return driver.findElement(By.xpath(locValue));

			case "name": return driver.findElement(By.name(locValue));

			default:
				break;
			}
		}
		catch(NoSuchElementException e) {
			System.err.println("The locator "+locator+" is not found for the value "+locValue);
			//throw new NoSuchElementException("locator not found");
		}
		catch(WebDriverException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}
		return null;
	}

	public void clear(WebElement ele) {
		try {
			//driver.unregister(this);
			ele.clear();
			//driver.register(this);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String exceptionClass = e.getClass().getCanonicalName();

			System.err.println("Exception Class:"+exceptionClass);
		}
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);		
			this.reportSteps("The input string "+data+" is entered successfully", "pass");
		}
		catch(NullPointerException e) {
			System.err.println("The web element is not found sucessfully to perform type action");
			this.reportSteps("The input string"+data+"is not entered successfully", "fail");
		}
		catch(InvalidElementStateException e) {
			System.err.println("The element is not ready for typing");
			this.reportSteps("The element is not ready for typing", "fail");
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
		} catch(InvalidElementStateException e) {
			System.err.println("The element is not ready for clicking");
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}		
		catch(Exception e) {
			String exceptionClass = e.getClass().getCanonicalName();
			e.printStackTrace();
			System.err.println("Exception Class:"+exceptionClass);
		}
	}

	public String getText(WebElement ele) {
		String text = null;
		try {
			 text = ele.getText();
		} catch(InvalidElementStateException e) {
			System.err.println("The element is not visible or interactable to get the text");
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}		
		catch(WebDriverException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}
		return text;
		
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			Select dropDownMembers = new Select(ele);
			dropDownMembers.selectByVisibleText(value);
		} catch(NoSuchElementException e) {
			System.err.println("No dropdown element present with given visible text");
			//throw new NoSuchElementException("locator not found");
		} catch(WebDriverException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}
		

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select dropDownMembers = new Select(ele);
			dropDownMembers.selectByValue(value);
		}  catch(NoSuchElementException e) {
			System.err.println("No dropdown element present with given value");
			//throw new NoSuchElementException("locator not found");
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dropDownMembers = new Select(ele);
			dropDownMembers.selectByIndex(index);
		} catch (NoSuchElementException e) {
			System.err.println("No dropdown element present with given index");
		}

	}

	public boolean verifyExactTitle(String expectedTitle) {
		if(driver.getTitle().equals(expectedTitle))
		{
			return true;
		}
		else {
			return false;
		}
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		if(driver.getTitle().contains(expectedTitle))
		{
			return true;
		}
		else {
			return false;
		}
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		if(ele.getText().equals(expectedText)) {
			System.out.println("verification passed");
			this.reportSteps("Verification Passed", "pass");
		}
		else {
			System.out.println("verification failed");
			this.reportSteps("Verification failed", "fail");
		}


	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		if(ele.getText().contains(expectedText)) {
			System.out.println("verification passed");
			this.reportSteps("Verification Passed", "pass");
		}
		else {
			System.out.println("verification failed");
			this.reportSteps("Verification failed", "fail");
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		if(ele.getAttribute(attribute).equals(value)) {
			System.out.println("verification passed");
		}
		else {
			System.out.println("verification failed");
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		if(ele.getAttribute(attribute).contains(value)) {
			System.out.println("verification passed");
		}
		else {
			System.out.println("verification failed");
		}
	}

	public void verifySelected(WebElement ele) {
		if(ele.isSelected()==true) {
			System.out.println("The element is selected");
		}
		else {
			System.out.println("The element is not selected");
		}

	}

	public void verifyDisplayed(WebElement ele) {
		if(ele.isDisplayed()==true) {
			System.out.println("The element is displayed");
		}
		else {
			System.out.println("The element is not displayed");
		}

	}

	public void switchToWindow(int index) {
		try {
			Set<String> windowsSet = driver.getWindowHandles();
			List<String> windowsList = new ArrayList<String>();
			windowsList.addAll(windowsSet);
			driver.switchTo().window(windowsList.get(index));
		} catch (NoSuchWindowException e) {
			System.err.println("There is no such window with the given index");
		} catch(IndexOutOfBoundsException e) {
			System.err.println("There is no such window with the given index");
		}

	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			System.err.println("There is no such frame to switch");
		} catch (WebDriverException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}

	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch(NoAlertPresentException e) {
			System.err.println("There is no such alert to accept");
		}catch (UnhandledAlertException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}catch (WebDriverException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}

	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch(NoAlertPresentException e) {
			System.err.println("There is no such alert to dismiss");
		}catch (UnhandledAlertException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}catch (WebDriverException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}

	}

	public String getAlertText() {
		String text = null;
		try {
			text= driver.switchTo().alert().getText();
			
		}  catch(NoAlertPresentException e) {
			System.err.println("There is no such alert to get text");
		}catch (UnhandledAlertException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}catch (WebDriverException e) {
			String exceptionClass = e.getClass().getCanonicalName();
			System.err.println("Exception Class:"+exceptionClass);
		}
		return text;
	}

	public void closeActiveBrowser() {
		driver.close();

	}

	public void closeAllBrowsers() {
		driver.quit();

	}
	
	public void explicitlyWait(WebElement ele, long secs ) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	
	public void explicitlyWait(String xpath, long secs ) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locateElement("xpath", xpath)));		
	}
	
	public void mouseHover(WebElement ele ) {
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();		
	}
	
	/*public void keyBoardAction(EventFiringWebDriver driver) {
		Actions builder = new Actions(driver);
		builder.
	}*/
}
