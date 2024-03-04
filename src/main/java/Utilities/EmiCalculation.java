package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import ExcelWork.ExcelScript;

public class EmiCalculation {
	ExcelScript ex;
	public long EmiCalculator() throws IOException {
		ex=new ExcelScript();
		ex.CarLoan();
		double e, principle_amount;
		double rate_of_interest;
		int tenture_in_month;
		principle_amount = Double.parseDouble(ex.getCar_P());
		float interest=Float.parseFloat(ex.getCar_I());
		rate_of_interest = (interest/12)/100;
		float year=Float.parseFloat(ex.getCar_LT());
		tenture_in_month =(int) (year*12);
		e = principle_amount * rate_of_interest;
		Math.pow(2, 3);
		e = e * Math.pow(1+rate_of_interest, tenture_in_month);
		e = e/(Math.pow(1+rate_of_interest, tenture_in_month)-1);
		System.out.println("Monthly EMI to be paid "+e);
		double Month_Interest =  e*(rate_of_interest);
		System.out.println("Monthly interest to be paid "+Month_Interest);
		double Month_principle = e - Month_Interest ;
		System.out.println("Monthly interest to be paid "+Month_principle);
	    long emi=Math.round(e);
	    return emi;
	}

}
