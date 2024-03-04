package ExcelWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExcelScript {
	public String Car_P;
	public String Car_I;
	public String Car_LT;
	public String Home_P,Home_DP,Home_LI,Home_LA,Home_LIT,Home_T,Home_LF;
	public String Emi_LA,Emi_IR,Emi_LT,Emi_FC;
	FileInputStream file;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public ExcelScript() throws IOException {
	 file = new FileInputStream("C:\\Users\\2303964\\eclipse-workspace\\MainProject\\DataSet\\EmiCalc_Data.xlsx") ;
	 workbook = new XSSFWorkbook(file);
	 sheet = workbook.getSheet("InputData");
		
	}
	
	public void CarLoan() {
		// TODO Auto-generated method stub
		XSSFRow currentRow = sheet.getRow(0);
		Car_P =currentRow.getCell(1).toString();
		Car_I =currentRow.getCell(2).toString();
		Car_LT =currentRow.getCell(3).toString();
	}
	public void HomeLoan() throws IOException {
		XSSFRow currentRow = sheet.getRow(1);
		Home_P=currentRow.getCell(1).toString();
		Home_DP=currentRow.getCell(2).toString();
		Home_LI=currentRow.getCell(3).toString();
		Home_LIT=currentRow.getCell(4).toString();
		Home_T=currentRow.getCell(5).toString();
		Home_LF=currentRow.getCell(6).toString();
		
	
	}
public void HomeLone_write(WebElement LoanTable) throws IOException {
		
		FileOutputStream file = new FileOutputStream("C:\\Users\\2303964\\eclipse-workspace\\MainProject\\DataSet\\EmiCalc_DataWrite.xlsx") ;
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		int table_row = LoanTable.findElements(By.xpath("tr")).size();
		System.out.println(table_row);
		int i=0;
		String h1=LoanTable.findElement(By.xpath("tr[1]/th[1]")).getText();
		String h2=LoanTable.findElement(By.xpath("tr[1]/th[2]")).getText();
		String h3=LoanTable.findElement(By.xpath("tr[1]/th[3]")).getText();
		String h4=LoanTable.findElement(By.xpath("tr[1]/th[4]")).getText();
		String h5=LoanTable.findElement(By.xpath("tr[1]/th[5]")).getText();
		String h6=LoanTable.findElement(By.xpath("tr[1]/th[6]")).getText();
		String h7=LoanTable.findElement(By.xpath("tr[1]/th[7]")).getText();
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue(h1);
		row.createCell(1).setCellValue(h2);
		row.createCell(2).setCellValue(h3);
		row.createCell(3).setCellValue(h4);
		row.createCell(4).setCellValue(h5);
		row.createCell(5).setCellValue(h6);
		row.createCell(6).setCellValue(h7);
		for(int r=2;r<=table_row;r+=2)
		{
			
			String year = LoanTable.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
			String principle = LoanTable.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
			String Interest = LoanTable.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			String Taxes = LoanTable.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
			String Total_Payment = LoanTable.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
			String Balance = LoanTable.findElement(By.xpath("tr["+r+"]/td[6]")).getText();
			String Loan_Paid = LoanTable.findElement(By.xpath("tr["+r+"]/td[7]")).getText();
			i++;
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(year);
			row.createCell(1).setCellValue(principle);
			row.createCell(2).setCellValue(Interest);
			row.createCell(3).setCellValue(Taxes);
			row.createCell(4).setCellValue(Total_Payment);
			row.createCell(5).setCellValue(Balance);
			row.createCell(6).setCellValue(Loan_Paid);
		}
		System.out.println("Table has been stored in Excel");
		workbook.write(file);
		workbook.close();
		file.close();
	}
    public void EmiFill() {
    	XSSFRow currentRow = sheet.getRow(2);
    	Emi_LA=currentRow.getCell(1).toString();
    	Emi_IR=currentRow.getCell(2).toString();
    	Emi_LT=currentRow.getCell(3).toString();
    	Emi_FC=currentRow.getCell(4).toString();
    	
    }
	public String getEmi_LA() {
		return Emi_LA;
	}

	public String getEmi_IR() {
		return Emi_IR;
	}

	public String getEmi_LT() {
		return Emi_LT;
	}

	public String getEmi_FC() {
		return Emi_FC;
	}

	public String getCar_P() {
		return Car_P;
	}

	public String getCar_I() {
		return Car_I;
	}

	public String getCar_LT() {
		return Car_LT;
	}



	public String getHome_P() {
		return Home_P;
	}

	public String getHome_DP() {
		return Home_DP;
	}

	public String getHome_LI() {
		return Home_LI;
	}

	public String getHome_LIT() {
		return Home_LIT;
	}

	public String getHome_T() {
		return Home_T;
	}

	public String getHome_LF() {
		return Home_LF;
	}

}
