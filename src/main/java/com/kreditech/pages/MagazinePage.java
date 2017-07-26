package com.kreditech.pages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 */
public class MagazinePage extends BasePage<MagazinePage> {

    private static final String MAGAZ_PAGE_TITLE = "Magazine - Kreditech";
    private static final String MAGAZ_PAGE_URL = "https://www.kreditech.com/magazine/";

    public MagazinePage(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return MAGAZ_PAGE_TITLE;
    }

    private static String getPageUrl() {
        return MAGAZ_PAGE_URL;
    }

    public MagazinePage waitPageLoaded(){
        waitForVisibilityOf(getMenuFooter());
        checkPageTitle();
        checkPageUrl();
        return this;
    }

    public MagazinePage checkPageTitle() {
        assertEqualStrings(getTitle(), getPageTitle(), "Page title");
        return this;
    }

    public MagazinePage checkPageUrl(){
        assertEqualStrings(getCurrentUrl(), getPageUrl(), "Page URL");
        return this;
    }
}
