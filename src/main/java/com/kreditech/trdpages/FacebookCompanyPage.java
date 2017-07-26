package com.kreditech.trdpages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by pc on 20.07.2017.
 * @author Max Pavlov
 */
public class FacebookCompanyPage extends BasePage<FacebookCompanyPage> {

    private static final String COMPANY_PAGE_TITLE = "Kreditech - Home | Facebook";
    private By footerBlock = By.cssSelector("#pagelet_rhc_footer");

    public FacebookCompanyPage(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return COMPANY_PAGE_TITLE;
    }

    public FacebookCompanyPage waitPageLoaded() {
        waitForVisibilityOf(footerBlock);
        return this;
    }

    public void checkPageTitle(){
        assertEqualStrings(getTitle(), getPageTitle(), "Page title");
    }
}
