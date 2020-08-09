package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParalletTestXML {

	public WebDriver driver;
	public DesiredCapabilities capability = new DesiredCapabilities();
	
	@Parameters({"browser"})
	@Test
	public void doLaunch(String browser) throws MalformedURLException {
		
		Date d = new Date();
		
		System.out.println(browser+"  "+d.toString());
		
		if(browser.equals("chrome")) {
			
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);
			
			ChromeOptions option = new ChromeOptions();
			option.merge(capability);
			
		}else if(browser.equals("firefox")) {
				
			capability.setPlatform(Platform.ANY);
			capability.setBrowserName("firefox");
				
				FirefoxOptions options = new FirefoxOptions();
				options.merge(capability);
				
			}
			
			
			
			driver = new RemoteWebDriver(new URL("http://192.168.0.161:4444"),capability);
			driver.get("https://www.guru99.com");

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		//	driver.quit();
			
	}
		
}
	

