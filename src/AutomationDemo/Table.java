package AutomationDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {

	
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "/Users/chiranjeeb/Downloads/chromedriver 2");
			WebDriver driver = new ChromeDriver();//

			//implicit wait
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);//In case of implicit wait the selenium will wait for 10 sec before execution of each and every step
			driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
			for(int i=1;i<=7;i++)
			{
				for(int x=1;x<=3;x++)
				{
					String Test = driver.findElement(By.xpath("//*[@id=\"task-table\"]/tbody/tr["+i+"]/td["+x+"]")).getText();
					System.out.println(Test);
				}
			}
	}

}
//*[@id="task-table"]/tbody/tr[1]/td[2]
//*[@id="task-table"]/tbody/tr[1]/td[3]