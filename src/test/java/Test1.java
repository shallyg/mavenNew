import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Test1 {
	   public static WebDriver driver;
		@BeforeSuite
		public void init(){
			driver = new FirefoxDriver();
			driver.get("https://en.wikipedia.org/wiki/Cross_patt%C3%A9e");
		}
		
		@Test
		public void doLogin(){
			//driver.findElement(By.id("Email")).sendKeys("aaaaa");
			//System.out.println("abc");
		
			
			driver.findElement(By.xpath("//*[@id='ca-history']/span/a")).click();
		//	WebElement block = driver.findElement(By.xpath("//*[@id'mw-history-search']"));
			WebElement drop = driver.findElement(By.xpath("//html/body/div/div[3]/div[3]//form/fieldset/select"));
			Select sel = new Select(drop);
			List<WebElement> l1 = sel.getOptions();
			l1.size();
			for(int i = 0; i<l1.size(); i++){
				System.out.println(l1.get(i).getText());
			}
			driver.findElement(By.xpath("//*[@id='year']")).sendKeys("2014");
			driver.findElement(By.xpath("//*[@id='mw-history-compare']/div[1]/input")).click();
			String s  = driver.findElement(By.xpath("//*[@id='mw-content-text']/p[19]/a")).getText();
			System.out.println(s);
			String s1 = driver.findElement(By.xpath("//*[@id='mw-diff-ntitle1']/strong/a")).getText();
			System.out.println(s1);
			driver.findElement(By.cssSelector("#ca-edit > span > a")).click();
			driver.findElement(By.cssSelector("#n-featuredcontent > a")).click();
			
			WebElement block = driver.findElement(By.xpath("//*[@id='searchInput']"));
			block.sendKeys("england");
			Actions act = new Actions(driver);
			act.moveToElement(block).perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			WebDriverWait wait = new WebDriverWait(driver, 20L);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='suggestions']//div//a[3]//div"))).click();
			driver.findElement(By.xpath("//*[@id='n-mainpage-description']/a")).click();
			driver.findElement(By.xpath("//*[@id='ca-talk']/span/a")).click();
			System.out.println("finish1");
			
			driver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys("test");
			driver.findElement(By.xpath("//div[@class='suggestions']//div//a[3]//div")).click();
			System.out.println("finish2");
			
			
		}
		@AfterSuite
		public void end(){
			driver.quit();
			System.out.println("test complete");
		}
	

}

