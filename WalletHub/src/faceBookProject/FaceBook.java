package faceBookProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {

	public static void main(String[] args) throws InterruptedException {
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
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.xpath("//*[@name='login']")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//*[@class='a8c37x1j ms05siws hwsy1cff b7h9ocf4'])[1]")).click();
		WebElement ele = driver.findElement(By.xpath(("(//*[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7'])[11]")));
		ele.click();
		//Find the Status Text Area and enter the status message as Hello World
		driver.findElement(By.xpath("//div[@class=\"_1mf _1mj\"]")).sendKeys("Hello World");
		driver.findElement(By.xpath("(//div[@class='oajrlxb2 s1i5eluu gcieejh5 bn081pho humdl8nn izx4hr6d rq0escxv nhd2j8a9 j83agx80 p7hjln8o kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x jb3vyjys d1544ag0 qt6c0cv9 tw6a2znq i1ao9s8h esuyzwwr f1sip0of lzcic4wl l9j0dhe7 abiwlrkh p8dawk7l beltcj47 p86d2i9g aot14ch1 kzx2olss cbu4d94t taijpn5t ni8dbmo4 stjgntxs k4urcfbm tv7at329'])")).click();
		Thread.sleep(5000);
		driver.close();

	}

}
