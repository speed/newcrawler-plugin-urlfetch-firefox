package com.newcrawler.plugin.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * org/openqa/selenium/firefox/webdriver.xpi
 * 
 * org/openqa/selenium/firefox/webdriver/content/dommessenger.js
 * //doc.documentElement.setAttribute('webdriver', true);
 * 
 * org/openqa/selenium/firefox/webdriver/content/server.js
 * #search Object.defineProperty(window.navigator, 'webdriver'
 * //doc.documentElement.appendChild(script);
 * 
 * @author speed
 *
 */

public class Selenium2FirefoxTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		WebDriver driver = null;
		try {
			
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			
			/*File file = new File("E:\\Liao\\firefox\\firebug-2.0.17-fx.xpi");
			firefoxProfile.addExtension(file);
			firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0.17");
			*/
			
			driver = new FirefoxDriver(new FirefoxBinary(new File(
					"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")), firefoxProfile);																	// screen


			driver.navigate().to("http://119.254.209.77");
			
			WebElement link=driver.findElement(By.id("_ctl0__ctl0_Content_MenuHyperLink14"));
	        Actions actions=new Actions(driver);
	        actions.moveToElement(link).click(link).perform();
	          
			String content = driver.getPageSource();

			System.out.println("Page source: " + content);
			System.out.println("getCurrentUrl: " + driver.getCurrentUrl());
		} finally {
			// Close the browser
			if (driver != null) {
				driver.quit();
			}
		}
	}

}
