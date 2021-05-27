package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {
	static Properties prop;
	public static String DriverName;
	public static String DriverPath;
	public static String UserId;
	public static String Password;
	
	public static void init() throws Exception {
		File propFile = new File("data.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop = new Properties();
		prop.load(fis);
		DriverName = prop.getProperty("driverName");
		DriverPath = prop.getProperty("driverPath");
		UserId = prop.getProperty("userId");
		Password = prop.getProperty("password");
	}
	
	public void setDriverName() {
		DriverName = prop.getProperty("driverName");
	}
}
