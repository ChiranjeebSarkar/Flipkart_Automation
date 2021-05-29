package AutomationDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Álert {

	public static void main(String[] args) {
		
		
	}
	
	
	public void webAlert() {
		ChromeDriver dv = new ChromeDriver();
		Alert al = dv.switchTo().alert();
		al.accept();
		al.dismiss();
		al.getText();

	}
	
	public void windowAlert() {
		 	    ChromeOptions options = new ChromeOptions();
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				caps.setCapability("acceptInsecureCerts", true);
				WebDriver driver = new ChromeDriver(caps);
		}

}
