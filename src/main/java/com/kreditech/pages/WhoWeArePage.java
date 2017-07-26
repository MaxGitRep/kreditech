package com.kreditech.pages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 */
public class WhoWeArePage extends BasePage<WhoWeArePage> {

    private static final String WHO_PAGE_TITLE = "Who we are - Kreditech";
    private static final String WHO_PAGE_URL = "https://www.kreditech.com/who-we-are/";

    public WhoWeArePage(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return WHO_PAGE_TITLE;
    }

    private static String getPageUrl() {
        return WHO_PAGE_URL;
    }

    public WhoWeArePage waitPageLoaded(){
        waitForVisibilityOf(getMenuFooter());
        checkPageTitle(getPageTitle());
        checkPageUrl(getPageUrl());
        return this;
    }
}
