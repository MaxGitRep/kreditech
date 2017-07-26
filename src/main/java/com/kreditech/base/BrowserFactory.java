package com.kreditech.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;

/**
 * Created by pc on 19.07.2017.
 * @author Max Pavlov.
 * BrowserFactory select system settings and properties for paticular browser.
 * @param browser got from BaseTest:SetUp method started @Before each test.
 * @param log append log message to scope LOG.
 *
 */
public class BrowserFactory {

    public static WebDriver getDriver(String browser, Logger log) {
        WebDriver driver;
        log.info("Starting " + browser + " driver");

        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/FFv0161/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/CHv229/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/FFv0161/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
