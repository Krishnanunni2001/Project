package Project_POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanCal3 {
	 
	WebDriver driver;
	LoanCal1 l1;
	LoanCal2 l2;
// Constructor
		public LoanCal3(WebDriver driver) throws IOException {
			this.driver = driver;
			PageFactory.initElements(driver,this);
			 l1=new LoanCal1(driver);
			 l2=new LoanCal2(driver);
		}
	
//Locators
		
	@FindBy(id="loan-tenure-calc")
	WebElement LoanTenCal;
	
//Action Method
	
	public void LoanCal3Click() {
		LoanTenCal.click();
	}
	public void UI_Check3() throws InterruptedException {
		l1.LoanAMT();
		l2.emi();
		l1.LoanINt();
		l1.feeCharges();
		l1.adv();
		l1.date();
		l1.month();
		l1.Dropdn();
		l1.hover();
	}
 
}