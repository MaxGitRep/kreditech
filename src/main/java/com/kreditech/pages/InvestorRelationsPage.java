package com.kreditech.pages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 */
public class InvestorRelationsPage extends BasePage<InvestorRelationsPage> {

    private static final String INVEST_PAGE_TITLE = "Investor Relations Website";// – Kreditech Group Hamburg";
    private static final String INVEST_PAGE_URL = "https://www.kreditech.com/investor-relations/";

    public InvestorRelationsPage(WebDriver driver) {
        super(driver);
    }

    private static String getPageTitle() {
        return INVEST_PAGE_TITLE;
    }

    private static String getPageUrl() {
        return INVEST_PAGE_URL;
    }

    public InvestorRelationsPage waitPageLoaded(){
        waitForVisibilityOf(getMenuFooter());
        return this;
    }

    public InvestorRelationsPage checkPageTitle() {
        assertContainsString(getTitle(), getPageTitle(), "Page title");
        return this;
    }

    public InvestorRelationsPage checkPageUrl(){
        assertEqualStrings(getCurrentUrl(), getPageUrl(), "Page URL");
        return this;
    }
}
