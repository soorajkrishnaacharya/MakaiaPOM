package projectDay;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {

	public static void main(String[] args) throws IOException {
		
		//non editable
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/report.html");
		html.setAppendExisting(true);
		// following two lines makes editable report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		//Define report content
		ExtentTest test = extent.createTest("TC001_CreateLead","Create a new lead");
		test.assignCategory("smoke");
		test.assignAuthor("Sooraj");
		test.pass("The Data Demo is entered successfully", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
		extent.flush();

	}

}
