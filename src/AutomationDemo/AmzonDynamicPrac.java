package AutomationDemo;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmzonDynamicPrac {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/chiranjeeb/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();//

		//implicit wait
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);//In case of implicit wait the selenium will wait for 10 sec before execution of each and every step
		//Explicit wait
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("searchDropdownBox")).click();
		//driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]/option[@value=\"search-alias=pantry\"]")).click();
		//driver.findElement(By.)
		Select sel = new Select(driver.findElement(By.id("searchDropdownBox")));
		sel.selectByVisibleText("Amazon Pantry");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Cakes");
		driver.findElement(By.id("nav-search-submit-button")).click();
		int count = driver.findElements(By.xpath("//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]/div")).size();
		System.out.println(count);
		//int count = driver.findElement(By.xpath("//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]")).size();
		//System.out.println(count);
		try
		{
			for(int z=1;z<=count;z++)
			{
				try {
				String name = driver.findElement(By.xpath("//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]/div["+z+"]/div/span/div/div/div/div/span/a/div/img")).getAttribute("alt");
				System.out.println(name);
				System.out.println(z);
				}
				catch(Exception e){
					System.out.println(z);
				}
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
