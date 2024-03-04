package Utilities;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSetup {
	
	public WebDriver SelectDriver() {
		WebDriver d = null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the browser to execute \n1.Chrome\n2.Edge");
		int a=sc.nextInt();
		switch(a){
			case 1: d=new ChromeDriver();
			        break;
			case 2: d=new EdgeDriver();
	                break;
	        default: System.out.println("Wrong choice\n");         
		}
		d.get("https://emicalculator.net/");
		d.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(d, Duration.ofSeconds(30));
		WebElement h=wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div/div/main/article/div[1]/h1"))));
		
		return d;
	}

}
