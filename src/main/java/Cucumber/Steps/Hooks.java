package Cucumber.Steps;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Project_POM.CarPOM;
import Utilities.DriverSetup;
import Utilities.ScrollDown;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	static WebDriver driver;
	static DriverSetup dd;
		@BeforeAll
	    public static void before_or_after_all() throws IOException, InterruptedException{
		   dd=new DriverSetup();
		   driver=dd.SelectDriver();  
	}
		@AfterStep
	    public void addScreenshot(Scenario scenario) {
	    if(!scenario.isFailed()) {
	       TakesScreenshot ts=(TakesScreenshot) driver;
	       byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	       scenario.attach(screenshot, "image/png",scenario.getName());
	        }
		}
		@AfterAll
		public static void before_or_after_all1() {
			driver.quit();
			String reportFilePath = "C:\\Users\\2303964\\eclipse-workspace\\MainProject\\Reports\\Cucumber_Report.html";
	        File htmlFile = new File(reportFilePath);
	        try {
				Desktop.getDesktop().browse(htmlFile.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}




