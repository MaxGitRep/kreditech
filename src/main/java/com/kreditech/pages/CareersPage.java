package com.kreditech.pages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 */
public class CareersPage extends BasePage<CareersPage> {

    private static final String WORK_PAGE_TITLE = "Kreditech Career Opportunities – Hamburg and worldwide";
    private static final String WORK_PAGE_URL = "https://www.kreditech.com/careers/";

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return WORK_PAGE_TITLE;
    }

    private static String getPageUrl() {
        return WORK_PAGE_URL;
    }

    public CareersPage waitPageLoaded(){
        waitForVisibilityOf(getMenuFooter());
        checkPageTitle(getPageTitle());
        checkPageUrl(getPageUrl());
        return this;
    }
}
