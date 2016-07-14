package com.newcrawler.plugin.test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Selenium2FirefoxRemoteDriverTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(
                    new URL("http://XXXXXXXX/wd/hub"), 
                    DesiredCapabilities.firefox());

			driver.navigate().to("http://www.newcrawler.com/header");

			String content = driver.getPageSource();
			System.out.println("Page source: " + content);
			
			driver.navigate().to("http://119.254.209.77");
			
			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('_ctl0__ctl0_Content_MenuHyperLink14').click();");

			content = driver.getPageSource();

			FileUtils.writeStringToFile(new File("d:/js/html/test.html"), content);
			// Check the title of the page
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
