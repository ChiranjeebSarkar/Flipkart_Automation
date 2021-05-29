package AutomationDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/chiranjeeb/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();//

		//implicit wait
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);//In case of implicit wait the selenium will wait for 10 sec before execution of each and every step
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		
		int Size = driver.findElements(By.id("todrag")).size();
		for(int i=1;i<=Size;i++)
		{
			WebElement fromElement = driver.findElement(By.xpath("//*[@id=\"todrag\"]/span["+i+"]"));
			WebElement toElement = driver.findElement(By.xpath("mydropzone"));
			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.clickAndHold(fromElement)
					.moveToElement(toElement)
					.release(toElement)
					.build();
//					
			//builder.dragAndDrop(fromElement, toElement).perform();
			String draggedelements = driver.findElement(By.xpath("//*[@id=\"droppedlist\"]/span["+i+"]")).getText();
			System.out.println(draggedelements);
			
		}
	
		

		
		//Creating object of Actions class to build composite actions
		
		//Building a drag and drop action
//		Action dragAndDrop = builder.clickAndHold(fromElement)
//		.moveToElement(toElement)
//		.release(toElement)
//		.build();
//		

		//Performing the drag and drop action
		//dragAndDrop.perform();

	}

}
//*[@id="todrag"]/span[1]