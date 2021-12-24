package ExcelNew.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Amazonpractice extends LibGlobal{
	public static void main(String[] args) throws Exception {
	getDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	WebElement txtiphones = driver.findElement(By.id("twotabsearchtextbox"));
	txtiphones.sendKeys("iphones");
	WebElement btnlogin = driver.findElement(By.id("nav-search-submit-button"));
	btnlogin.click();
	Thread.sleep(3000);
	WebElement btnclick = driver.findElement(By.xpath("(//span[text()='New Apple iPhone 12 (128GB) - Green'])[1]//parent::span//parent::a//parent::h2//parent::div//parent::div//parent::div//parent::div//span[text()='₹70,900']"));
	String priceofiphone = btnclick.getText();
	System.out.println(priceofiphone);
	driver.quit();
	
	
	
	
	}
}
