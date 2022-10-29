import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testing.Assert;
import org.testng.Assert;

public class Driver_Objects {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mohit\\eclipse-workspace\\project_end_to_end_login\\Login_Page_Test\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginPage(driver,"Mohit Kumar","TestingPass");
		String errorMsg = driver.findElement(By.cssSelector("p.error")).getText();
		Assert.assertEquals(errorMsg,"* Incorrect username or password");
		System.out.println(errorMsg);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		
		//System.out.println(PasswordString);
		String PassWord = passwordReset(driver);
		//for(String S:passWord)
		//	System.out.println(s);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		loginPage(driver,"Mohit Kumar",PassWord);
		driver.quit();
		 

	}
	public static void loginPage(WebDriver driver,String userName,String password) {
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		
	}
	public static String passwordReset(WebDriver driver) {
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mohit");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("mk9@gmail.com");
		driver.findElement(By.xpath("//form/input[@type='text'][3]")).sendKeys("00000");
		//driver.findElement(By.cssSelector("div.forgot-pwd-btn-container button.reset-pwd-btn")).click();
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String PasswordString = driver.findElement(By.tagName("p")).getText();
		String[] passWord = PasswordString.split("'");
		
		
		return passWord[1];
	}

}
