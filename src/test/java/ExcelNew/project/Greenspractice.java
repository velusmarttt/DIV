package ExcelNew.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Greenspractice extends LibGlobal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement txttype = driver.findElement(By.name("q"));
		txttype.sendKeys("greens t");
		//get the length of dropdown options
		
		
		
	}

}
