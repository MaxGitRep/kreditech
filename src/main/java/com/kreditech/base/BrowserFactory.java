package com.kreditech.base;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by pc on 19.07.2017.
 *
 * @author Max Pavlov.
 */

public class BrowserFactory {
    public static WebDriver driver;
    /**
     * BrowserFactory select system settings and properties for paticular browser.
     *
     * @param browser got from BaseTest:SetUp method started @Before each test.
     */
    public static WebDriver getDriver(String browser) {

        switch (browser) {
            case "firefox":
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            default:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
