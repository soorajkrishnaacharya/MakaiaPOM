package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class TestngListener implements IAnnotationTransformer, IRetryAnalyzer{

	int maxcount=1;
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
		/*if(testMethod.getName().equals("createLead")) {
		annotation.setTimeOut(100);
		}*/
		/*if(testMethod.getName().equals("deleteLead")) {
		annotation.setEnabled(true);
		}*/
		
	}
	

	public boolean retry(ITestResult result) {
		if(!result.isSuccess() & maxcount < 2) {
			maxcount++;
			return true;
		}
		return false;
	}
	
	
	public void CodeCheckIn() {
		System.out.println("Bingooo!!");
	}
	
	

}
