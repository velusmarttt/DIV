package ExcelNew.project;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Image;
		
public class Flipkartpractice extends BaseClass {
	public Flipkartpractice() {
		PageFactory.initElements(driver, this);
	}
	@Test
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try {
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		}
		catch(Exception e){
		
			System.out.println("No Modal Window");
		}
			WebElement btnlogin = driver.findElement(By.xpath("//a[text()='Login']"));
			btnlogin.click();
			WebElement txtusername = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
			txtusername.sendKeys("dinesh.ak37@gmail.com");
			WebElement txtpass = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
			txtpass.sendKeys("1021320040dinesh");
			WebElement btnclick = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
			btnclick.click();
			Thread.sleep(2000);
			WebElement mobiles = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Mobiles']")));
			//WebElement btnmob = driver.findElement(By.xpath("//div[text()='Mobiles']"));
			mobiles.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//img[@class='kJjFO0 _3DIhEh'])[15]")).click();
			Thread.sleep(2000);
			WebElement minrange = driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[1]"));
			WebElement maxrange = driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[2]"));
			Select selectmin=new Select(minrange);
			Select selectmax=new Select(maxrange);
			selectmin.selectByValue("2000");
			Thread.sleep(1000);
			selectmax.selectByValue("20000");
			String parentwindow=driver.getWindowHandle();
			driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> iterator = windowHandles.iterator();
			String childwindow="";
			while(iterator.hasNext()) {
				String temp=iterator.next();
				if(!(parentwindow.equalsIgnoreCase(temp))) {
					childwindow=temp;
				}
			}
			Thread.sleep(2000);
			driver.switchTo().window(childwindow);
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
			Thread.sleep(3000);
			driver.switchTo().window(parentwindow);
			driver.findElement(By.xpath("//div[@class='KK-o3G']")).click();
			driver.quit();
			

			
			
			
	}
	}


