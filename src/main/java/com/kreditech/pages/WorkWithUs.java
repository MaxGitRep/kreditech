package com.kreditech.pages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 */
public class WorkWithUs extends BasePage<WorkWithUs> {

    private static final String JOIN_PAGE_TITLE = "Work with Kreditech in Hamburg, Data Science, Engineering, Finance";
    private static final String JOIN_PAGE_URL = "https://www.kreditech.com/work-with-us/";

    public WorkWithUs(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return JOIN_PAGE_TITLE;
    }

    private static String getPageUrl() {
        return JOIN_PAGE_URL;
    }

    public WorkWithUs waitPageLoaded(){
        waitForVisibilityOf(getMenuFooter());
        checkPageTitle(getPageTitle());
        checkPageUrl(getPageUrl());
        return this;
    }
}
