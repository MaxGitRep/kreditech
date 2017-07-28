package com.kreditech.navigationTest;

import com.kreditech.base.BaseTest;
import com.kreditech.pages.*;
import org.testng.annotations.Test;

/**
 * Created by pc on 21.07.2017.
 * @author Max Pavlov
 *
 * Test checks each navigation bar item in the Kreditech page's header.
 * Steps:
 * 1 Open main company page ('Home').
 * 2 Click on item 'What we do' and check if correct page loaded.
 * 3 Click on item 'Who we are' and check if correct page loaded.
 * 4 Click on item 'Work with us' and check if correct page loaded.
 * 5 Click on item 'Careers' and check if correct page loaded.
 * 6 Click on item 'Investor Relations' and check if correct page loaded.
 * 7 Click on item 'Press' and check if correct page loaded.
 * 8 Click on item 'Magazine' and check if correct page loaded.
 *
 */
public class NavigationBarTest extends BaseTest {

    @Test
    public void testCanOpenPagesFromNavBar() {
        log("Step 1. open company site");
        HomePage homePage = new HomePage(driver).openHomePage();

        log("Step 2. open What we do page");
        homePage.clickOnMainMenuItem("What we do");
        WhatWeDoPage whatPage = new WhatWeDoPage(driver).waitPageLoaded();

        log("Step 3. open Who we are page");
        whatPage.clickOnMainMenuItem("Who we are");
        WhoWeArePage whoPage = new WhoWeArePage(driver).waitPageLoaded();

        log("Step 4. open Work with us page");
        whoPage.clickOnMainMenuItem("Work with us");
        WorkWithUs joinPage = new WorkWithUs(driver).waitPageLoaded();

        log("Step 5. open Careers page");
        joinPage.clickOnMainMenuItem("Careers");
        CareersPage workPage = new CareersPage(driver).waitPageLoaded();

        log("Step 6. open Investor Relations page");
        workPage.clickOnMainMenuItem("Investor Relations");
        InvestorRelationsPage investPage = new InvestorRelationsPage(driver).waitPageLoaded();

        log("Step 7. open Press page");
        investPage.clickOnMainMenuItem("Press");
        PressPage pressPage = new PressPage(driver).waitPageLoaded();

        log("Step 8. open Magazine page");
        pressPage.clickOnMainMenuItem("Magazine");
        MagazinePage magazinePage = new MagazinePage(driver).waitPageLoaded();
    }
}
