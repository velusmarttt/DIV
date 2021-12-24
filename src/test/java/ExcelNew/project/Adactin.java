package ExcelNew.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Adactin{
	
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "F:\\velu smarttt\\Workspace\\project\\src\\test\\java\\resources\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://adactinhotelapp.com/");
	WebElement txtuser = driver.findElement(By.xpath("//input[@id='username']"));
	txtuser.sendKeys("velu");
	WebElement txtpass = driver.findElement(By.xpath("//input[@id='password']"));
	txtpass.sendKeys("monster");
	Thread.sleep(3000);
	WebElement btnclick = driver.findElement(By.xpath("//input[@id='login']"));
	btnclick.click();
	driver.quit();
}
}
