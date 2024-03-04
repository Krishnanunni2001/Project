package Project_POM;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ExcelWork.ExcelScript;

public class LoanCal1 {
 
	WebDriver driver;
	static String EMI;
	static String a;
	ExcelScript ex;
 
// Constructor
	public LoanCal1(WebDriver driver) throws IOException {
		this.driver = driver;
		ex=new ExcelScript();
		ex.EmiFill();
		PageFactory.initElements(driver,this);
	}
//Locators
	
	
	
	@FindBy(xpath="//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement CalClick;
	
	@FindBy(xpath="//*[@id=\"menu-item-2423\"]")
	WebElement LoanCalClick;
	
	@FindBy(id="loanamount")
	static WebElement LoanAmt;
	
	@FindBy(xpath="//*[@id=\"loanamountslider\"]/span")
	static WebElement LoanAmtSlide;
	
	@FindBy(id="loaninterest")
	static WebElement loanIntrst;
	
	@FindBy(xpath="//*[@id=\"loaninterestslider\"]/span")
	static WebElement loanIntrstSlide;
	
	@FindBy	(id="loanterm")
	static WebElement loanTerm;
	
	@FindBy(xpath="//*[@id=\"loantermslider\"]/span")
	static WebElement loanTermSlide;
	
	@FindBy(xpath ="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[1]")
	static WebElement termMnth;
	
	@FindBy(id="loanfees")
	static WebElement Fee;
	
	@FindBy(xpath="//*[@id=\"loanfeesslider\"]/span")
	static WebElement FeeSlide;
	
	@FindBy(xpath="//*[@id=\"loansummary-emi\"]/p/span")
	WebElement emi;
	
	@FindBy(xpath="//*[@id=\"leschemewrapper\"]/div/div/div/div/label[1]")
	static WebElement adv;
	
	@FindBy(className = "highcharts-point")
	static List<WebElement> hover;
	
	@FindBy(id="startmonthyear")
	static WebElement date;
	
	@FindBy(xpath="//tr//td//span[@class='month'][4]")
	static WebElement month;
	
	@FindBy(id="yearformat")
	static WebElement dropdown; //financialyear
	
	@FindBy(xpath="//*[@id=\"ecalprintandshare\"]/a[1]")
	static WebElement print;
	
	@FindBy(xpath="//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[2]")
	static WebElement close;
	
	@FindBy(xpath="//*[@id='ecalprintandshare']/a[2]")
	static WebElement share;
	
	@FindBy(xpath="/html/head/title")
	static WebElement title;
	
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]")
	static WebElement monthChange;
	
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[1]")
	static WebElement yearChange;
	
//Action method
	
	public void LoanCalClick() {
		CalClick.click();
		LoanCalClick.click();
	}
	public void LoanAMT() throws InterruptedException {
		
		Thread.sleep(3000);
		LoanAmt.sendKeys(Keys.CONTROL + "a");
		LoanAmt.sendKeys(ex.getEmi_LA());
		//To move the slider
		Thread.sleep(3000);
		Actions move1 = new Actions(driver);
		Action action1 = (Action) move1.dragAndDropBy(LoanAmtSlide, 100,0).build();
	    action1.perform();
	    System.out.println("Loan Amount textbox and slider is working");
	}
	public void LoanINt() throws InterruptedException {
		
		loanIntrst.sendKeys(Keys.CONTROL + "a");
		loanIntrst.sendKeys(ex.getEmi_IR());
		//To move the slider
		Thread.sleep(3000);
		Actions move2 = new Actions(driver);
		Action action2 = (Action) move2.dragAndDropBy(loanIntrstSlide, 50, 0).build();
	    action2.perform();
	    System.out.println("Interest Rate textbox and slider is working");
	}
	public void Tenure() throws InterruptedException {
		
		loanTerm.sendKeys(Keys.CONTROL + "a");
		loanTerm.sendKeys(ex.getEmi_LT());
		//To move the slider
		Thread.sleep(3000);
		Actions move3 = new Actions(driver);
		Action action3 = (Action) move3.dragAndDropBy(loanTermSlide, 60, 0).build();
	    action3.perform();
	    System.out.println("Loan Tenure textbox and slider is working");	
	}
	public void yearTomonth() {
		String b=loanTerm.getAttribute("value");
		monthChange.click();
		String c =loanTerm.getAttribute("value");
        System.out.println("The change is "+b+" to "+c);	
	}
	public void feeCharges() throws InterruptedException {
		
		Fee.sendKeys(Keys.CONTROL + "a");
		Fee.sendKeys(ex.getEmi_FC());
		//To move the slider
		Thread.sleep(3000);
		Actions move4 = new Actions(driver);
		Action action4 = (Action) move4.dragAndDropBy(FeeSlide, 60, 0).build();
	    action4.perform();
	    System.out.println("Fees & Charges textbox and slider is working");
	}
	public void emi() {
		EMI=emi.getText();
	}
	public void adv() {
		adv.click();
	}
	public void date() {
		date.click();
	}
	public void month() {
		month.click();
	}
	public void Dropdn() {
		Select s=new Select(dropdown);
	    s.selectByIndex(1);
	}
	public void hover() {
		Actions Hover = new Actions(driver);
	    for(WebElement i:hover) {
	    	Hover.moveToElement(i).perform();
	    }
	}
	
}