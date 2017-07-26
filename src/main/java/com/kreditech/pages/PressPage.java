package com.kreditech.pages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 */
public class PressPage extends BasePage<PressPage> {

    private static final String PRESS_PAGE_TITLE = "Media & Press | Kreditech Group Website";
    private static final String PRESS_PAGE_URL = "https://www.kreditech.com/press/";

    public PressPage(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return PRESS_PAGE_TITLE;
    }

    private static String getPageUrl() {
        return PRESS_PAGE_URL;
    }

    public PressPage waitPageLoaded(){
        waitForVisibilityOf(getMenuFooter());
        checkPageTitle(getPageTitle());
        checkPageUrl(getPageUrl());
        return this;
    }
}
