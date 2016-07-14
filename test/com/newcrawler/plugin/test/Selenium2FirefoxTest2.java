package com.newcrawler.plugin.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

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
 * 
 * https://developer.mozilla.org/en-US/docs/Mozilla/QA/Marionette/WebDriver
 * https://github.com/mozilla/geckodriver/releases
 * 
 * @author speed
 *
 */

public class Selenium2FirefoxTest2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		WebDriver driver = null;
		try {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);


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
