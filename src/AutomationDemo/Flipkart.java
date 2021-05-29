package AutomationDemo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		 
		System.setProperty("webdriver.chrome.driver", "/Users/chiranjeeb/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).click();
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("rockingdeep100@gmail.com");
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).click();
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("deepdeep100");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("Iphones");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		List<WebElement> count = driver.findElements(By.xpath("//div[@id='container']/div/div[3]/div/div[2]/div/following-sibling::div/div/div/div/a/div[2]/div[contains(@class,'col col-7-12')]/div[1]"));
		System.out.println("Total no of search results fetched : ");
		System.out.println(count.size());
		System.out.println("List of all the items displayed against the searched result : ");
		for(int i = 1;i<= count.size();i++)
		{
			String Product_Names = driver.findElement(By.xpath("(//div[@id='container']/div/div[3]/div/div[2]/div/following-sibling::div/div/div/div/a/div[2]/div[contains(@class,'col col-7-12')]/div[1])["+i+"]")).getText();
			System.out.println(Product_Names);
		}
		String Name_Of_Product = driver.findElement(By.xpath("(//div/div/div[3]/div/div[2]/div[2]/div/div/div/a[@class='_1fQZEK']/div[2]/div/div)[1]")).getText();
		
		System.out.println(Name_Of_Product);
		driver.findElement(By.xpath("//div/div/div[3]/div/div[2]/div[2]/div/div/div/a[@class='_1fQZEK']")).click();
		
		Thread.sleep(2000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Deliver Here']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
		WebElement Payment = driver.findElement(By.xpath("//span[text()='Payment Options']"));
		if(Payment.isDisplayed())
		{
			System.out.println("Your order for "+Name_Of_Product+" is placed successfully!!");
		}
		else
		{
			System.out.println("Oops!! Your Order for "+Name_Of_Product+"is failed ");
		}
		driver.quit();
		driver.close();
		
		
	}

}

