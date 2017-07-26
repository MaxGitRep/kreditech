package com.kreditech.pages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 */
public class WhatWeDoPage extends BasePage<WhatWeDoPage> {

    private static final String WHAT_PAGE_TITLE = "Kreditech – Providing access to credit for the underbanked";
    private static final String WHAT_PAGE_URL = "https://www.kreditech.com/what-we-do/";

    public WhatWeDoPage(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return WHAT_PAGE_TITLE;
    }

    private static String getPageUrl() {
        return WHAT_PAGE_URL;
    }

    public WhatWeDoPage waitPageLoaded(){
        waitForVisibilityOf(getMenuFooter());
        return this;
    }

    public WhatWeDoPage checkPageTitle() {
        assertEqualStrings(getTitle(), getPageTitle(), "Page title");
        return this;
    }

    public WhatWeDoPage checkPageUrl(){
        assertEqualStrings(getCurrentUrl(), getPageUrl(), "Page URL");
        return this;
    }

}
