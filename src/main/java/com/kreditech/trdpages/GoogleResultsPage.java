package com.kreditech.trdpages;

import com.kreditech.base.BasePage;
import com.kreditech.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 * @author Max Pavlov
 */
public class GoogleResultsPage extends BasePage<GoogleResultsPage> {

    private By resultsList = By.cssSelector("div.g");

    public GoogleResultsPage (WebDriver driver){
        super(driver);
    }

    /**
     * @param key - company url to find and select needed link in google results.
     * @return new company main page.
     */
    public HomePage clickRelevantResultByKey (String key){
        waitForVisibilityOf(resultsList);
        By resultItem = By.cssSelector("a[href*='" + key + "']");
        click(resultsList, resultItem);
        return new HomePage(driver);
    }

}
