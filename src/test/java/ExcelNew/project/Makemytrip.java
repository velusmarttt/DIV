package ExcelNew.project;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Makemytrip extends LibGlobal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getDriver();
		driver.get("https://www.tripodeal.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement origin = driver.findElement(By.id("origin"));
		origin.sendKeys("DEL");
		Robot robot=new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement destination = driver.findElement(By.id("destination"));
		destination.sendKeys("BLR");
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		WebElement search = driver.findElement(By.name("search"));
		search.click();
		WebElement selectbox = driver.findElement(By.xpath("//div[@class='bg-light p-3  bg-white  rounded fadeIn animated small']"));
		selectbox.findElement(By.xpath("//div[text()='Vistara']")).click();
		//to select vistara delhi to bangalore first flight
		//WebElement btnclick = driver.findElement(By.xpath("(//div[@id='flight_nav']//button)[1]"));
	//	btnclick.click();
	}

}
