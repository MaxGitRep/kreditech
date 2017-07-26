package com.kreditech.searchInGoogleTest;

import com.kreditech.base.BaseTest;
import com.kreditech.trdpages.GoogleMainPage;
import com.kreditech.trdpages.GoogleResultsPage;
import org.testng.annotations.Test;


/**
 * Created by pc on 19.07.2017.
 * @author Max Pavlov
 *
 * Test checks if 'kreditech.com' can be found in google.com.
 * Steps:
 * 1 Open google.com and search by key 'kreditech'.
 * 2 Click on result with link 'www.kreditech.com'.
 * 3 Check if correct home page loaded.
 *
 */
public class SearchKreditechTest extends BaseTest {

    private static final String KEY = "kreditech";
    private static final String URL = "www.kreditech.com";

    @Test
    public void testCanSearchInGoogle() {
        LOG.info("search company site in google.com by " + KEY);
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        GoogleResultsPage resultsPage = mainPage.searchByKey(KEY);
        LOG.info("open company site from searching results");
        resultsPage.clickRelevantResultByKey(URL)
                .waitHomePageLoaded()
                .checkPageTitle()
                .checkPageUrl();
    }
}
