package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUpload {
	public static void main(String args[])
	{

	
		System.setProperty("webdriver.chrome.driver", "C:/Users/akumar94/Downloads/chromedriver_1.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		uploadElement.sendKeys("C:\\Users\\akumar94\\Desktop\\11.jpg");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.name("send")).click();

	
	}
}
