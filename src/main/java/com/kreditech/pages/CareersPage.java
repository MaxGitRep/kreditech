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
        return this;
    }

    public CareersPage checkPageTitle() {
        assertEqualStrings(getTitle(), getPageTitle(), "Page title");
        return this;
    }

    public CareersPage checkPageUrl(){
        assertEqualStrings(getCurrentUrl(), getPageUrl(), "Page URL");
        return this;
    }
}
