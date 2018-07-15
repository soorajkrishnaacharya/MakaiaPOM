package lib.reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reports {
	
	public static ExtentHtmlReporter html;
	public static ExtentReports extent ;
	public ExtentTest  testSuite,test;
	
	//@BeforeSuite
	public void startResult() {
		html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
		html.loadXMLConfig("./src/main/resources/extent-config.xml");
	}
	
	//@BeforeClass
	public ExtentTest startTestCase(String testCaseName, String testCaseDesc) {
		testSuite = extent.createTest(testCaseName, testCaseDesc);
		return testSuite;
	}	
	
	//@BeforeMethod
	public ExtentTest startTestModule(String nodes) {
		/*test.createNode(node);
		test.assignCategory(category);
		test.assignAuthor(author);*/
		
		test = testSuite.createNode(nodes);
		return test;
	}
	
	//@AfterSuite
	public void endResult() {
		extent.flush();
	}
	
	
	public abstract long takeSnap();

	public void reportSteps(String desc,String status) {
		
		MediaEntityModelProvider img = null;

		long snapNumber = 1000000L;
		snapNumber = takeSnap();

	
		try {
			img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/"+snapNumber+".png").build();
		} catch (IOException e) {			
		}		

		if(status.equalsIgnoreCase("PASS")) {
			test.pass(desc, img);		
		}else if(status.equalsIgnoreCase("FAIL")) {
			test.fail(desc, img);
			throw new RuntimeException();
		}else if(status.equalsIgnoreCase("WARNING")) {
			test.warning(desc, img);		
		}else {
			test.info(desc);
		}
	}

	/*public void reportSteps(String desc,String status) {
		try {
		MediaEntityModelProvider img = MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build();
			if (status.equalsIgnoreCase("PASS")) {				
				test.pass(desc,img);
			} else if (status.equalsIgnoreCase("FAIL")) {				
				test.fail(desc,img);
				throw new RuntimeException();
			}else if (status.equalsIgnoreCase("warning")) {				
				test.warning(desc,img);
			}				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}
