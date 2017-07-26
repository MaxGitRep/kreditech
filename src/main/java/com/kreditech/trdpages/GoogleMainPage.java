package com.kreditech.trdpages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 * @author Max Pavlov
 */
public class GoogleMainPage extends BasePage<GoogleMainPage> {

    private static final String URL = "https://www.google.com";

    private By searchField = By.xpath("//input[@name='q']");
    private By searchButton = By.xpath("//input[@name='btnK']");

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @param key - keyword or fraze for searching in google.com.
     * after type key pressed 'Enter' button
     */
    public GoogleResultsPage searchByKey(String key){
        getPage(URL);
        waitForVisibilityOf(searchButton);
        type(key, searchField);
        type(Keys.ENTER, searchField);
        return new GoogleResultsPage(driver);
    }
}
