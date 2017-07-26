package com.kreditech.trdpages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by pc on 20.07.2017.
 * @author Max Pavlov
 * Social company page in Linkedin
 */
public class LinkedinCompanyPage extends BasePage<LinkedinCompanyPage> {

    private static final String COMPANY_PAGE_TITLE = "Kreditech Holding SSL GmbH: Overview | LinkedIn";
    private By navBar = By.cssSelector("#extended-nav");

    public LinkedinCompanyPage(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return COMPANY_PAGE_TITLE;
    }

    public LinkedinCompanyPage waitPageLoaded() {
        waitForVisibilityOf(navBar);
        return this;
    }

    public void checkPageTitle(){
        assertContainsString(getTitle(), getPageTitle(), "Page title");
        //assertEqualStrings(getTitle(), getPageTitle(), "Page title");
    }

}
