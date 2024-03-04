package Main_TestNG;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Project_POM.CarPOM;
import Project_POM.HomePOM;
import Project_POM.LoanCal1;
import Project_POM.LoanCal2;
import Project_POM.LoanCal3;
import Utilities.DriverSetup;
import Utilities.EmiCalculation;
import Utilities.ExtentReportManager;
import Utilities.Screenshots;
import Utilities.ScrollDown;
@Listeners(Utilities.ExtentReportManager.class)
public class CarTestNG  {
	
	public static WebDriver driver;
	CarPOM lp;
	HomePOM Hl ;
	Screenshots ss;
	LoanCal1 lc;
	LoanCal2 l2;
	LoanCal3 lc3;
	ScrollDown sd;
	
	


	@BeforeClass(alwaysRun=true)
	void setup() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		
		ss=new Screenshots();
		sd=new ScrollDown();
		
	}
	@Test(priority=1,groups = "RegressionTest")
	void testLogo() throws IOException, AWTException, InterruptedException
	{
		lp=new CarPOM(driver);
		ss.ScreenShotTaker(driver,"EmiCal");
	    Assert.assertEquals(lp.checkHeading(), "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");
	}
	@Test(priority = 2, groups = {"SmokeTest", "RegressionTest"})
	public void car_Loan() throws IOException {
		lp=new CarPOM(driver);
		lp.CarClick();
		System.out.println("Smoke testing for car loan funtionality is passed");
		System.out.println();
	}
	@Test(priority=3,groups = "RegressionTest")
	void Car_Loan() throws IOException, AWTException, InterruptedException
	{
		
		lp.Loan_Amount();
		lp.Loan_Interest();
		lp.Loan_Tenure();	
		ss.ScreenShotTaker(driver,"CarLoan");
		WebElement EMII=driver.findElement(By.xpath("//*[@id=\"leschemewrapper\"]/div/label"));
	    sd.ScrollDownElement(driver, EMII);
	    ss.ScreenShotTaker(driver,"CarLoanEmi");
	}
	@Test(priority=4,groups = "RegressionTest")
	void EMI_Calculation() throws IOException
	{
		String EMI=lp.Loan_EMI();
		EMI = EMI.replace(",", "");
		int intValue = Integer.parseInt(EMI);
		System.out.println("The Loan EMI "+intValue);
		EmiCalculation ec=new EmiCalculation();
		long emi=ec.EmiCalculator();
		Assert.assertEquals(intValue, emi);
		//lp.Menu_Click();	
	}
	@Test(priority =5, groups = {"SmokeTest", "RegressionTest"} )
	public void home_Loan() {
		lp.Menu_Click();
		System.out.println("Smoke testing for loan loan funtionality is passed");
		System.out.println();
	}
    @Test(priority=6,groups = "RegressionTest")
    public void Home_page() throws IOException, InterruptedException, AWTException {
  	   Hl=new HomePOM(driver);
	   Hl.Home_Loan_Set();
	   Thread.sleep(5000);
	   ss.ScreenShotTaker(driver,"HomeLoan");
	   WebElement EMI=driver.findElement(By.id("monthlyprincipalandinterestterm"));
	   sd.ScrollDownElement(driver, EMI);
	   ss.ScreenShotTaker(driver,"HomeLoanEMI");
	   WebElement Table=driver.findElement(By.xpath("//*[@id=\"paymentschedule\"]/table"));
	   sd.ScrollDownElement(driver, Table);
	   Hl.WriteTable();
	   ss.ScreenShotTaker(driver,"HomeLoanTable");
    }
    @Test(priority = 7, groups = {"SmokeTest", "RegressionTest"})
	public void Loan_cal1() throws IOException {
		lc=new LoanCal1(driver);
		lc.LoanCalClick();
		System.out.println("Smoke testing for EMI calculator page funtionality is passed");
		System.out.println();
	}
    @Test(priority=8,groups = "RegressionTest")
    public void Emi_Calc() throws InterruptedException, IOException {
		lc.LoanAMT();
		lc.LoanINt();
		lc.Tenure();
		lc.yearTomonth();
		lc.feeCharges();
		lc.emi();
		lc.adv();
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();
    }
    @Test(priority = 9, groups = {"SmokeTest", "RegressionTest"})
   	public void Loan_cal2() throws  InterruptedException, IOException {
    	l2=new LoanCal2(driver);
    	l2.LoanCal2Click();
   		System.out.println("Smoke testing for Loan Amount calculator page funtionality is passed");
   		System.out.println();
   	}
    
    @Test(priority=10,groups = "RegressionTest")
    public void Calc2() throws InterruptedException, IOException {
     	l2.emi();
   		l2.UI_Check2();
		 }
   
	@Test(priority = 11, groups = {"SmokeTest", "RegressionTest"})
	public void Loan_cal3() throws IOException {
		lc3=new LoanCal3(driver);
		lc3.LoanCal3Click();
		System.out.println("Smoke testing for Loan Tenure calculator page funtionality is passed");
	}
    @Test(priority=12,groups = "RegressionTest")
    public void Calc3() throws InterruptedException, IOException {
    	
		lc3.UI_Check3();
    }
    
    @AfterClass(alwaysRun=true)
    public void close_b() {
    	
    	driver.close();
    }
}
