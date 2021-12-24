package ExcelNew.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Amazonreview extends LibGlobal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement txtiphones = driver.findElement(By.id("twotabsearchtextbox"));
		txtiphones.sendKeys("iphones");
		WebElement btnlogin = driver.findElement(By.id("nav-search-submit-button"));
		btnlogin.click();
		WebElement reviewclick = driver.findElement(By.xpath("//span[text()='Apple iPhone 13 Mini (128GB) - Pink']//parent::a//parent::h2//parent::div//a[@class='a-link-normal']"));
		 reviewclick.click();		
	}

}
