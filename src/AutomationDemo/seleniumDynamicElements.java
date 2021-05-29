package AutomationDemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumDynamicElements {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/chiranjeeb/Downloads/chromedriver 2");
		WebDriver driver = new ChromeDriver();//

		//implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//In case of implicit wait the selenium will wait for 10 sec before execution of each and every step
		//Explicit wait
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name(utility.getPropertyKeyValue("searchBox"))).sendKeys("Nissan Magnite");
		//Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("btnK"))));
		driver.findElement(By.name(utility.getPropertyKeyValue("searchButton"))).click();
		Thread.sleep(2000);
		int mainDivCount = driver.findElements(By.xpath("//div[@id='rso']/div")).size();
		System.out.println(mainDivCount);
		try {
		for(int y=1;y<=mainDivCount;y++) {
			
		
		int count = driver.findElements(By.xpath("//div[@id='rso']/div["+y+"]/div[@class='g']")).size();
		System.out.println(count);
		for(int i=1;i<=count;i++) {
			try {
		String name = driver.findElement(By.xpath("//div[@id='rso']/div["+y+"]/div[@class='g']["+i+"]/div[1]/div[1]/a/h3")).getText();
		System.out.println(name);
			}catch(Exception e) {
				System.out.println(i);
			}
		
		////div[@class='g'][2]
		}
		
		}
		}catch(Exception e) {}

	}

}

