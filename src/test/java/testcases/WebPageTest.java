package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.Utility;

public class WebPageTest {
	
	@Test
	public void AppTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get("https://www.t-mobile.com/tablets");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Actions action = new Actions(driver);
		try {
		action.scrollToElement(driver.findElement(By.xpath("//*[normalize-space(text())='Operating System']"))).perform();
		}
		catch(StaleElementReferenceException e) {
			action.scrollToElement(driver.findElement(By.xpath("//*[normalize-space(text())='Operating System']"))).perform();
		}
		Utility utill = new Utility(driver);
		utill.selectFilter("Deals", "New", "Special offer");
		//utill.selectFilter("Deals", "all");
		//utill.selectFilter("Brands", "all");
		utill.selectFilter("Brands", "Apple", "Samsung");
		utill.selectFilter("Operating System", "Android", "iPadOS", "Other");
		//utill.selectFilter("Operating System", "all");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
