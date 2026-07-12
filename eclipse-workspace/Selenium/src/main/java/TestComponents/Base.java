package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import encapsulatedpageobjectmodel.Loginpage1;

import com.fasterxml.jackson.databind.json.JsonMapper;



public class Base {

	public static WebDriver driver;
	
	public static WebDriver initializeDriver() throws IOException {

		Properties prop=new Properties();
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+ "//src//test//java//Resources//GlobalData.properties");
		prop.load(file);
		prop.getProperty("browser");
		String browser = prop.getProperty("browser");

		if(browser.equalsIgnoreCase("chrome"))
		{
		    ChromeOptions options = new ChromeOptions();

		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);

		    options.setExperimentalOption("prefs", prefs);
		    options.addArguments("--disable-features=PasswordLeakDetection");

		    driver = new ChromeDriver(options);
		}
	driver.manage().window().maximize();
	return driver;
	}
	
	 public com.fasterxml.jackson.databind.JsonNode getJsonData() throws IOException {

	        JsonMapper mapper = new JsonMapper();

	        com.fasterxml.jackson.databind.JsonNode data = mapper.readTree(
	                new File(System.getProperty("user.dir")
	                + "\\src\\test\\java\\Testdata\\PurchaseOrder.json")
	        );

	        return data;
	    }
	 
	public static Loginpage1 launchapplication() throws IOException
	{
		
		 driver = initializeDriver();
		 Loginpage1 loginpage=new Loginpage1(driver);
			loginpage.goTo();
			return loginpage;
	
		
	}
	
	
	public void tearDown()
	{
		driver.close();
	}

}
