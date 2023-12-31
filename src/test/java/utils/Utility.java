package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	 WebDriver driver;
	 
	 public Utility(WebDriver driver) {
		 this.driver = driver;
	 }
	
	public  void selectFilter(String filtertype, String... args)  {
		String filter = "//legend[normalize-space(text())='"+filtertype+"']";
		driver.findElement(By.xpath(filter)).click();
		if (args.length != 0 && (!args[0].equalsIgnoreCase("all"))) {
			for (String str : args) {
				
				WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+str+"') and @class='filter-display-name']"));
				By checkbox = RelativeLocator.with(By.xpath("//input[@type='checkbox']/parent::span")).toLeftOf(ele);
				new WebDriverWait(driver, Duration.ofSeconds(45)).until(ExpectedConditions.elementToBeClickable(checkbox)).click();
				
				
			}
		}
		else if (args.length==1 && args[0].equalsIgnoreCase("all")) {
			List<WebElement> elements = driver.findElements(By.xpath("//span[@class='filter-display-name']"));
			for (WebElement e : elements) {
				e.click();
			}
		}
		else {
			System.out.println("No filter passed");
		}
	}

}
