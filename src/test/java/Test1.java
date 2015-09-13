import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Test1 {
	   public static WebDriver driver;
		@BeforeSuite
		public void init(){
			driver = new FirefoxDriver();
			driver.get("http://gmail.com");
		}
		
		@Test
		public void doLogin(){
			driver.findElement(By.id("Email")).sendKeys("aaaaa");
			
		}
		@AfterSuite
		public void end(){
			driver.quit();
		}
	

}

