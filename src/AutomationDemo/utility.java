package AutomationDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utility {
	
	public static String getPropertyKeyValue(String key) throws FileNotFoundException, IOException {
		String value = null;
		File obj = new File("/Users/chiranjeeb/eclipse-workspace/AutomationDemo/Object Repo/google.properties");
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(obj));
		value = prop.getProperty(key);
		
		return value;
		
	}

}
