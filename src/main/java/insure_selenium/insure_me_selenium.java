package insure_selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class insure_me_selenium {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "/var/lib/jenkins/msedgedriver");
		//WebDriverManager.edgedriver().setup();
				
		
        WebDriver driver = new EdgeDriver();
		driver.get("http://44.204.143.178:8084/contact.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("inputName")).sendKeys("Sandeep");
		driver.findElement(By.id("inputNumber")).sendKeys("9895915902");
		driver.findElement(By.id("inputMail")).sendKeys("sandeep.ajayakumar@gmail.com");
		driver.findElement(By.id("inputMessage")).sendKeys("Insure me selenium project");
		driver.findElement(By.id("my-button")).click();
		
		String message = driver.findElement(By.id("response")).getText();
		if(message.equals("Message Sent")) {
			System.out.println("Script Executed Successfully");
		} else 
		{
			System.out.println("Script Failed");
		}
		
		
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File ("./scr.png");
		FileUtils.copyFile(screenShot, destFile);
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}
}
