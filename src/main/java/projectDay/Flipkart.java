package projectDay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class Flipkart extends WebDriverServiceImpl {
	
	@Test
	public void flipKartComparison() {
		
		WebElement eleClose = locateElement("xpath", "//button[text()='✕']");
		click(eleClose);
		
		WebElement eleTV_Appliances = locateElement("xpath", "//span[text()='TVs & Appliances']");
		mouseHover(eleTV_Appliances);
		
		WebElement eleTVBrand = locateElement("link", "Samsung");
		click(eleTVBrand);
		
		WebElement eleMinPrice = locateElement("xpath", "(//select[@class='fPjUPw'])[1]");
		selectDropDownUsingValue(eleMinPrice,"25000");
		
		WebElement eleMaxPrice = locateElement("xpath", "(//select[@class='fPjUPw'])[2]");
		selectDropDownUsingValue(eleMaxPrice,"60000");
		
		WebElement eleScreenSize = locateElement("xpath", "//div[text()='Screen Size']");
		click(eleScreenSize);
		
		//div[text()='48 - 55']/preceding-sibling::div
		WebElement eleScreenSizeCheck = locateElement("xpath", "//div[text()='48 - 55']/preceding-sibling::div");
		click(eleScreenSizeCheck);
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='_3SQWE6'])[1]")));
		*/
		WebElement eleResult1 = locateElement("xpath", "(//div[@class='_3SQWE6'])[1]");
		explicitlyWait(eleResult1, 10);
		click(eleResult1);
		
		WebElement elePriceText = locateElement("xpath", "(//div[@class='_1vC4OE _2rQ-NK'])[1]");
		String priceText_result1 = getText(elePriceText);
		
		switchToWindow(1);
		
		//div[@class='_1vC4OE _3qQ9m1']
		WebElement elePriceText_Child = locateElement("xpath", "//div[@class='_1vC4OE _3qQ9m1']");
		//String priceText_Child = getText(elePriceText_Child);
		
		System.out.print("Comparing Price text");
		verifyExactText(elePriceText_Child, priceText_result1);
		
		closeActiveBrowser();
		
		switchToWindow(0);
		
		//(//div[@class='_2kFyHg']//div)[1]
				
		
		WebElement eleAddCompare_1 = locateElement("xpath", "(//div[@class='_2kFyHg']//div)[1]");
		click(eleAddCompare_1);
		
		WebElement eleAddCompare_2 = locateElement("xpath", "(//div[@class='_2kFyHg']//div)[2]");
		click(eleAddCompare_2);
		
		
		WebElement eleBtnCompare = locateElement("xpath", "//span[text()='COMPARE']");
		click(eleBtnCompare);
		
		//(//div[@class='_3eykh1']//span)[1]
		
		WebElement eleCompareText = locateElement("xpath", "(//div[@class='_3eykh1']//span)[1]");
		System.out.print("Verify Compare text : ");
		verifyExactText(eleCompareText, "Compare");
		
		//(//div[@class='_1vC4OE'])[1]
				
		WebElement elePriceTextCom1 = locateElement("xpath", "(//div[@class='_1vC4OE'])[1]");
		String priceText1 = getText(elePriceTextCom1);
		String sub = priceText1.substring(1);
		String rep = sub.replaceAll(",", "");
		int price1 = Integer.parseInt(rep);
		
		
		WebElement elePriceTextCom2 = locateElement("xpath", "(//div[@class='_1vC4OE'])[2]");
		String priceText2 = getText(elePriceTextCom2);
		String sub1 = priceText2.substring(1);
		String rep1 = sub1.replaceAll(",", "");
		int price2 = Integer.parseInt(rep1);
		
		System.out.print("Lowest Price: ");
		if(price1<price2) {
			
			System.out.println(price1);
		}
		else {
			System.out.println(price2);
		}
				
				
				
				
		
		
		
		
		
	}


}
