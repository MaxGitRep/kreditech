package com.kreditech.trdpages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by pc on 20.07.2017.
 * @author Max Pavlov
 */
public class TwitterCompanyPage extends BasePage<TwitterCompanyPage> {

    private static final String COMPANY_PAGE_TITLE = "Kreditech (@Kreditech) | Twitter";
    private By footerBlock = By.cssSelector(".flex-module");

    public TwitterCompanyPage(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return COMPANY_PAGE_TITLE;
    }

    public TwitterCompanyPage waitPageLoaded() {
        waitForVisibilityOf(footerBlock);
        return this;
    }

    public void checkPageTitle(){
        assertEqualStrings(getTitle(), getPageTitle(), "Page title");
    }
}
