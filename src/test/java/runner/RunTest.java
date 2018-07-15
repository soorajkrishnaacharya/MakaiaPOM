package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features="src/main/java/features/createLead.feature",glue= {"pages","bdd"},monochrome= true)
@RunWith(Cucumber.class)
public class RunTest {

}
