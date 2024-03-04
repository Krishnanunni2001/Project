package Utilities;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public String ScreenShotTaker(WebDriver d,String name) throws IOException, AWTException, InterruptedException {
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	TakesScreenshot takesScreenshot = (TakesScreenshot) d;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_"+".png";
	File targetFile=new File(targetFilePath);
	sourceFile.renameTo(targetFile);
	return targetFilePath;
	}

	
}
