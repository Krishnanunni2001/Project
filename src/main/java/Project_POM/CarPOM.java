package Project_POM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ExcelWork.ExcelScript;

public class CarPOM {
	
public WebDriver driver;
ExcelScript ex;
	
	//Constructor
	public CarPOM(WebDriver driver) {
		this.driver=driver;
		try {
			ex=new ExcelScript();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ex.CarLoan();
		PageFactory.initElements(driver,this);
	}
	
//	WebElement Locators+identification
	
	@FindBy(tagName="h1")
	WebElement 	Heading_check;
	
	@FindBy(id="car-loan")
	WebElement car_menu;
	
	@FindBy(id="loanamount")
	WebElement LoanAmount;
	
	@FindBy(id="loaninterest")
	WebElement LoanInterest;
	
	@FindBy(id="loanterm")
	WebElement LoanTenure;
	
	@FindBy(xpath="//*[@id=\"emiamount\"]/p/span")//*[@id="emiamount"]/p/span
	WebElement LoanEMI;
	
	@FindBy(xpath="//*[@id=\"emipaymenttable\"]/table/tbody")
	WebElement Table;

	@FindBy(xpath="/html/body/header/div/nav/button/span")
	WebElement Menu;
	
	@FindBy(xpath="//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement Cal;
	
	@FindBy(xpath="//*[@id=\"menu-item-3294\"]/a")
	WebElement a;
	
	
// Action Methods
	
	public String checkHeading()
	{
		String heading=Heading_check.getText();
		return heading;
	}
	
	public void CarClick()
	{
		car_menu.click();
	}
	public void Loan_Amount()
	{
		LoanAmount.sendKeys(Keys.CONTROL + "a");
		LoanAmount.sendKeys(ex.getCar_P());
	}
	public void Loan_Interest()
	{
		LoanInterest.sendKeys(Keys.CONTROL + "a");
		LoanInterest.sendKeys(ex.getCar_I());
	}
	
	public void Loan_Tenure()
	{
		LoanTenure.sendKeys(Keys.CONTROL + "a");
		LoanTenure.sendKeys(ex.getCar_LT());
		driver.findElement(By.xpath("//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div")).click();
	}
	
	public String Loan_EMI()
	{
		String EMI = LoanEMI.getText();
		System.out.print("EMI: "+EMI);
		return EMI;
		
	}
	public void Menu_Click() {
		
		Cal.click();
		a.click();
		
	}

}
