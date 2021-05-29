package AutomationDemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumWindowHandling {

	
		public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
			System.setProperty("webdriver.chrome.driver", "/Users/chiranjeeb/Downloads/chromedriver 2");
			WebDriver driver = new ChromeDriver();//

			//implicit wait
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//Explicit wait
			//WebDriverWait wait=new WebDriverWait(driver, 10);
			
			
			driver.get("http://the-internet.herokuapp.com/windows");
			driver.findElement(By.linkText("Click Here")).click();
			Set<String> allWindowHandles = driver.getWindowHandles(); //
			Iterator<String> I1= allWindowHandles.iterator();//??

			while(I1.hasNext())
			{

			String child_window=I1.next();


			System.out.println(driver.switchTo().window(child_window).getTitle());
			String s = driver.switchTo().window(child_window).getTitle();
			if(s.equals("The Internet")) {
				
				driver.switchTo().window(child_window);
				driver.findElement(By.linkText("Click Here")).click();
				//driver.quit();
			}
			
			

			
			}
			
		}
}
