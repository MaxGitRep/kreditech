package com.kreditech.socialLinksTest;

import com.kreditech.base.BaseTest;
import com.kreditech.pages.HomePage;
import com.kreditech.trdpages.FacebookCompanyPage;
import com.kreditech.trdpages.LinkedinLoginPage;
import com.kreditech.trdpages.LinkedinCompanyPage;
import com.kreditech.trdpages.TwitterCompanyPage;
import org.testng.annotations.Test;


/**
 * Created by pc on 20.07.2017.
 * @author Max Pavlov
 *
 * Test checks each social sources buttons and ensure that opened pages are related to Kreditech.
 * Steps:
 * 1 Open Linkedin and login as user (content available only for logined users).
 * 2 Open main company page ('Home') and save tab anchor for returning.
 * 3 Open Linkedin company page in new tab, check and close tab.
 * 4 Open Fasebook company page in new tab, check and close tab.
 * 5 Open Twetter company page in new tab, check and close tab.
 *
 */
public class SocialLinksVisitTest extends BaseTest {

    @Test
    public void testCanOpenSocialCompanyProfiles() {
        LOG.info("login to Linkedin");
        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);
        loginPage.openLoginPage()
                .fillUpEmailPass("raj.bigtheory@gmail.com", "Dza94t2017");
        LinkedinCompanyPage profilePage = loginPage.pushSignInButton();
        profilePage.waitPageLoaded();

        LOG.info("open company site");
        HomePage homePage = new HomePage(driver).openHomePage();

        //get home page tab
        String parentHandle = driver.getWindowHandle();

        LOG.info("link to social Linkedin company profile, check and close tab");
        LinkedinCompanyPage companyLinkPage = homePage.clickOnLinkedinLink();
        companyLinkPage.switchFocusToNewTab();
        companyLinkPage.waitPageLoaded().checkPageTitle();
        companyLinkPage.closeNewTab(parentHandle);

        LOG.info("link to social Facebook company profile, check and close tab");
        FacebookCompanyPage companyFacePage = homePage.clickOnFacebookLink();
        companyFacePage.switchFocusToNewTab();
        companyFacePage.waitPageLoaded().checkPageTitle();
        companyFacePage.closeNewTab(parentHandle);

        LOG.info("link to social Twitter company profile, check and close tab");
        TwitterCompanyPage companyTwitPage = homePage.clickOnTwitterLink();
        companyTwitPage.switchFocusToNewTab();
        companyTwitPage.waitPageLoaded().checkPageTitle();
        companyTwitPage.closeNewTab(parentHandle);
    }
}

