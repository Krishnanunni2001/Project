package Project_POM;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcelWork.ExcelScript;

public class HomePOM {
	public WebDriver driver;
	ExcelScript ex;

	public HomePOM(WebDriver driver) throws IOException
	{
		this.driver=driver;
		ex=new ExcelScript();
		ex.HomeLoan();
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="homeprice")
	WebElement Home_P;
	
	@FindBy(id="downpayment")
	WebElement Home_DP;
	
	@FindBy(id="homeloaninsuranceamount")
	WebElement Home_LI;
	
	@FindBy(id="homeloanamount")
	WebElement Home_LA;
	
	@FindBy(id="homeloaninterest")
	WebElement Home_LIT;
	
	@FindBy(id="homeloanterm")
	WebElement Home_T;
	
	@FindBy(id="loanfees")
	WebElement Home_LF;
	
	@FindBy(xpath="//*[@id=\"paymentschedule\"]/table/tbody")
	WebElement LoanTable;
	
	public void Home_Loan_Set() {
		Home_P.sendKeys(Keys.CONTROL + "a");
        Home_P.sendKeys(ex.getHome_P());
        Home_DP.sendKeys(Keys.CONTROL + "a");
        Home_DP.sendKeys(ex.getHome_DP());
        Home_LI.sendKeys(Keys.CONTROL + "a");
        Home_LI.sendKeys(ex.getHome_LI());
        Home_LIT.sendKeys(Keys.CONTROL + "a");
        Home_LIT.sendKeys(ex.getHome_LIT());
        Home_T.sendKeys(Keys.CONTROL + "a");
        Home_T.sendKeys(ex.getHome_T());
        Home_LF.sendKeys(Keys.CONTROL + "a");
        Home_LF.sendKeys(ex.getHome_LF());
		
	}
	public void WriteTable() throws IOException {
		ex.HomeLone_write(LoanTable);
	}

}
