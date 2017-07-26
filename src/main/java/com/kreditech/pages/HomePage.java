package com.kreditech.pages;

import com.kreditech.base.BasePage;
import com.kreditech.trdpages.FacebookCompanyPage;
import com.kreditech.trdpages.LinkedinCompanyPage;
import com.kreditech.trdpages.TwitterCompanyPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by pc on 19.07.2017.
 * @author Max Pavlov
 * Main company page
 */
public class HomePage extends BasePage<HomePage> {

    private static final String HOME_PAGE_TITLE = "Kreditech - Financial Freedom for the Underbanked";
    private static final String HOME_PAGE_URL = "https://www.kreditech.com/";
    //footer
    private By socialLinkedin = By.cssSelector("div.social.linkedin");
    private By socialFacebook = By.cssSelector("div.social.facebook");
    private By socialTwitter = By.cssSelector("div.social.twitter");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static String getHomePageTitle() {
        return HOME_PAGE_TITLE;
    }

    private static String getHomePageUrl() {
        return HOME_PAGE_URL;
    }

    public LinkedinCompanyPage clickOnLinkedinLink() {
        click(socialLinkedin);
        return new LinkedinCompanyPage(driver);
    }

    public FacebookCompanyPage clickOnFacebookLink() {
        click(socialFacebook);
        return new FacebookCompanyPage(driver);
    }

    public TwitterCompanyPage clickOnTwitterLink() {
        click(socialTwitter);
        return new TwitterCompanyPage(driver);
    }
    public HomePage openHomePage(){
        getPage(HOME_PAGE_URL);
        waitHomePageLoaded();
        return this;
    }

    public HomePage waitHomePageLoaded (){
        waitForVisibilityOf(getMenuFooter());
        checkPageTitle(getHomePageTitle());
        checkPageUrl(getHomePageUrl());
        return this;
    }
}
