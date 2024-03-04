package Cucumber.Tests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
					features= {"src\\main\\java\\Cucumber\\Features\\Emi_Cal.feature"},
					glue="Cucumber.Steps",
					plugin= {"pretty", "html:Reports/Cucumber_Report.html", 
							  "rerun:target/rerun.txt"
							}, 
					tags="@RegressionTesting"
				)
public class testRunners extends AbstractTestNGCucumberTests {
	
} 