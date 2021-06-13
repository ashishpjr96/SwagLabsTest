package com.swaglabs.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.swaglabs.qa.util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static FileInputStream  ip;
	
	public static WebDriver driver;
	
	public TestBase()
	{
		prop= new Properties();
		try {
			 ip=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\SwagLabsTest\\src\\main\\java\\com\\swaglabs\\qa\\config\\config.properties");
	       prop.load(ip);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
	public static void Intializatiion()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\chromedriver_win32 (1)\\chromedriver_win32 (2)\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		 
			else if(browserName.equals("FF"))
			{
				
				System.setProperty("webdriver.gecko.driver","C:\\Users\\HP\\Desktop\\chromedriver_win32 (1)\\geckodriver.exe");
				driver= new FirefoxDriver();
			}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
		
		
		
		driver.get(prop.getProperty("url"));
		
		
		
		
	}
	

	}
