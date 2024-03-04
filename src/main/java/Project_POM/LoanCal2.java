package Project_POM;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanCal2 {
 
	WebDriver driver;
	LoanCal1 l1;
// Constructor
	public LoanCal2(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		l1=new LoanCal1(driver);
	}
	
	
//Locators
	@FindBy(id="loan-amount-calc")
	WebElement LoanAmtCal;
	
	@FindBy(id="loanemi")
	static WebElement emi1;
	
	@FindBy(xpath="//*[@id=\"loanemislider\"]/span")
	static WebElement emi1Slide;
	
	@FindBy(xpath="//*[@id=\"leschemewrapper\"]/div/div/div/div/label[2]")
	WebElement arrear;
	
	@FindBy(xpath="//tr//td//span[@class='month'][2]")
	WebElement month;
	
//Action Method
	
	public void LoanCal2Click() {
		LoanAmtCal.click();
	}
	public void emi() throws InterruptedException {
		Thread.sleep(3000);
		emi1.sendKeys(Keys.CONTROL + "a");
		emi1.sendKeys(LoanCal1.EMI);
		//To move the slider
		Thread.sleep(3000);
		Actions move1 = new Actions(driver);
		Action action1 = (Action) move1.dragAndDropBy(emi1Slide, 50, 0).build();
	    action1.perform();
	}
	public void UI_Check2() throws InterruptedException {
		l1.LoanINt();
		l1.Tenure();
		l1.feeCharges();
		arrear.click();
		l1.Dropdn();
		l1.date();
		month.click();
		l1.hover();
	}
 
}