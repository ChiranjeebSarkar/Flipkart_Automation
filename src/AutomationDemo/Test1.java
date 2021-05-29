package AutomationDemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/chiranjeeb/Downloads/chromedriver 2");
		WebDriver driver = new ChromeDriver();//

		//implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Explicit wait
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name(utility.getPropertyKeyValue("searchBox"))).sendKeys("Nissan Magnite");
		//Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("btnK"))));
		driver.findElement(By.name(utility.getPropertyKeyValue("searchButton"))).click();
		if(driver.findElement(By.xpath(utility.getPropertyKeyValue("searchitembadging"))).isDisplayed())
		{
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		//popup - WIndow based (FB)
		
		//alert - web based
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		
		
		
		driver.quit();
	}

}
//why cant we write chromedriver driver = new chromedriver() ??