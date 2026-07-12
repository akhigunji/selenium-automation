package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import encapsulatedpageobjectmodel.Loginpage1;



public class BaseTest {

	public static WebDriver driver;
	
	public static WebDriver initializeDriver() throws IOException {

		Properties prop=new Properties();
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+ "//src//test//java//Resources//GlobalData.properties");
		System.out.println("System Property browser = " + System.getProperty("browser"));
		prop.load(file);
		prop.getProperty("browser");
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//prop.getProperty("browser");
		System.out.println("Browser from command line: " + browserName);
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")){
			options.addArguments("headless");
			}		
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new org.openqa.selenium.firefox.FirefoxDriver();
			// 
		} else if(browserName.equalsIgnoreCase("edge")) {

		    EdgeOptions options = new EdgeOptions();

		    options.addArguments("--headless=new");
		    options.addArguments("--no-sandbox");
		    options.addArguments("--disable-dev-shm-usage");
		    options.addArguments("--disable-gpu");
		    options.addArguments("--remote-allow-origins=*");
		    options.addArguments("--disable-extensions");

		    driver = new EdgeDriver(options);
		}
		System.out.println("******** USING BASETEST1 ********");
	driver.manage().window().maximize();
	return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

	    String jsonContent = FileUtils.readFileToString(
	            new File(filePath),
	            StandardCharsets.UTF_8
	    );

	    ObjectMapper mapper = new ObjectMapper();

	    List<HashMap<String, String>> data =
	            mapper.readValue(
	                    jsonContent,
	                    new TypeReference<List<HashMap<String, String>>>() {}
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
