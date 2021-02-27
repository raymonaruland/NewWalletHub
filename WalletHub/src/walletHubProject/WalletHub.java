package walletHubProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.collections4.FactoryUtils;


public class WalletHub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("D:\\Rays\\Sel\\WalletHub\\src\\loginDetails.properties");

		FileInputStream fileInput = null;
		try{
			fileInput = new FileInputStream(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		}catch(IOException e) {
			e.printStackTrace();
		}

		System.setProperty("webdriver.chrome.driver",prop.getProperty("driverPath"));
		WebDriver driver = new ChromeDriver();
		//Enter URL, Username and Password then click login button
		driver.manage().window().maximize();
		driver.get("http://wallethub.com/profile/test_insurance_company/");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("(//*[@class='rvs-star-svg'])[14]"));
		//actions.moveToElement(target).click();
		target.click();
		driver.findElement(By.xpath("//*[contains(text(),'Select...')]")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Health Insurance')])[14]")).click();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FactoryUtils.copyFile(src,new File("D:\\eclipse"));

		}

}
