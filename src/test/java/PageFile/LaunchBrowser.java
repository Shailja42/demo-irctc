package PageFile;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchBrowser {

	public static WebDriver driver = null;
	public static WebDriverWait waitVar = null;

	public void createDriver() throws MalformedURLException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/akumar94/Downloads/chromedriver_1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		waitVar = new WebDriverWait(driver, 20);
		//waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Ok')]")));
		boolean ele = driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).isDisplayed();
		System.out.print("vlaue of elenemt is : + " + ele);
		if (ele == true) {
			driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		}
	}

	public void booking(String username, String pswd) throws MalformedURLException, InterruptedException {
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("usrPwd")).sendKeys(pswd);
		driver.findElement(By.id("cnfUsrPwd")).sendKeys(pswd);
	}

	public void selectques(String ques) throws MalformedURLException, InterruptedException {
		driver.findElement(By.xpath("//label[@class='ng-tns-c10-4 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")).click();
		//Select ques1 = new Select(driver.findElement(By.xpath("//label[contains(text(),'Select Security Question')]")));
		//ques1.selectByValue(ques);
		List<WebElement> options = driver.findElements(By.xpath("//span[@class='ng-tns-c10-4 ng-star-inserted']"));
		options.get(1).click();
		System.out.println("Size of list is********" +options.size());
		System.out.println("questions---->"+ques);
	//	for(WebElement option : options) {
//			
//		    if (option.getText().equals(ques))
//		    {
//		        option.click();
//		        
//		    }
//		}
	}
	
	//This method is used to provide security answer
	public void selectans(String ans) throws MalformedURLException, InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Security Answer']")).sendKeys(ans);
	}

	// This method is used to select language
	public void selectlang(String lang) throws MalformedURLException, InterruptedException {
		//Select sellang = new Select(driver.findElement(By.xpath("//label[contains(text(),'Select Preferred Language')]")));
		//sellang.selectByValue(lang);
		driver.findElement(By.xpath("//label[@class='ng-tns-c10-5 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")).click();
        List<WebElement> op = driver.findElements(By.xpath("//li[@class='ng-tns-c10-5 ui-dropdown-item ui-corner-all ng-star-inserted']"));
        op.get(0).click();
        
		// Filling personal details
//			String[] splt = username.split("\\s");
//			System.out.print("lenght of usrename:" + splt.length);
//			if (splt.length > 1) {
//				driver.findElement(By.id("firstName")).sendKeys(splt[0]);
//				driver.findElement(By.id("lastname")).sendKeys(splt[1]);
//			} else {
//				driver.findElement(By.id("firstName")).sendKeys(username);}	
	}

	public void enteringuserdeatils(String firstname, String lastname)throws MalformedURLException, InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		// Selecting Gender
		driver.findElement(By.id("F")).click();
				
	}
	
	public void seluserdob(String mon,String year,String day)throws MalformedURLException, InterruptedException
	{
		Random rand = new Random();
		int dates = 31;
		driver.findElement(By.xpath("//input[@class='ng-tns-c11-6 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")).click();
		driver.findElement(By.xpath("//select[@class='ui-datepicker-month ng-tns-c11-6 ng-star-inserted']")).click();
		Select month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month ng-tns-c11-6 ng-star-inserted']")));
		month.selectByVisibleText(mon);
		Select yr = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year ng-tns-c11-6 ng-star-inserted']")));
		yr.selectByValue(year);
		int int_random = rand.nextInt(dates); 
		driver.findElement(By.xpath("//a[contains(text(), '" + int_random + "')]")).click();
		boolean close = driver.findElement(By.id("corover-close-btn")).isDisplayed();
		if (close==true)
		{
			driver.findElement(By.id("corover-close-btn")).click();
		}
		else
		{
			System.out.print("There is no add at all");
		}
		driver.findElement(By.xpath("//label[contains(text(),'Select Occupation')]")).click();
       
		List <WebElement> occ = driver.findElements(By.xpath("//li[@class='ng-tns-c10-7 ui-dropdown-item ui-corner-all ng-star-inserted']"));
		occ.get(3).click();
		
		
		driver.findElement(By.xpath("//input[@class='ng-untouched ng-pristine ng-valid' and @value='M']")).click();
	}
	
	public void selcntry(String cntry)
	{
		Select country = new Select(driver.findElement(By.xpath("//select[@class='form-control ng-dirty ng-invalid ng-touched']")));
		country.selectByValue(cntry);
	}
	
	public void entermailid(String mailid)
	{
		driver.findElement(By.id("email")).sendKeys(mailid);
	}

	public void enterphn(String phno) {
		driver.findElement(By.id("mobile")).sendKeys(phno);	
	}

	public void nationality(String nation) {
		Select nationality = new Select(driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-invalid']")));
		driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-invalid']")).click();
		nationality.selectByVisibleText(nation);
	}

	public void address() throws InterruptedException {
		driver.findElement(By.id("resAddress1")).sendKeys("A-906 , Yashwin scoiety");
		
		//driver.findElement(By.id("resState")).sendKeys("Maharashtra");
		driver.findElement(By.id("resAddress2")).sendKeys("hygyguh");
		driver.findElement(By.id("resAddress3")).sendKeys("hygyjguh");
		driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid' and @formcontrolname='resPinCode']")).sendKeys("411045");
		
		driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-invalid' and@formcontrolname='resCity']")).click();
	//	Select city = new Select(driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-invalid']")));
		WebElement city = driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-invalid']"));
		//driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-invalid']")).sendKeys(Keys.ARROW_DOWN);			
		city.click();
		city.sendKeys(Keys.ARROW_DOWN);
		city.sendKeys(Keys.ENTER);
		
		Select postoffc = new Select(driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-invalid']")));
		driver.findElement(By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-invalid']")).click();
		postoffc.selectByIndex(2);
		driver.findElement(By.id("resPhone")).sendKeys("9041674650");
		driver.findElement(By.xpath("//input[@class='ng-untouched ng-pristine ng-invalid' and @value='Y']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='ng-untouched ng-pristine ng-invalid' and @formcontrolname='termCondition']")).click();
		
	}
	
	//resAddress1

}
