package com.kreditech.trdpages;

import com.kreditech.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by pc on 20.07.2017.
 * @author Max Pavlov
 * Linkedin Login in page header
 */
public class LinkedinLoginPage extends BasePage<LinkedinLoginPage> {

    private static final String LOGIN_URL = "https://www.linkedin.com/";
    private By emailField = By.cssSelector("#login-email");
    private By passField = By.cssSelector("#login-password");
    private By signInButton = By.cssSelector("#login-submit");

    public LinkedinLoginPage(WebDriver driver) {
        super(driver);
    }

    public LinkedinLoginPage openLoginPage(){
        getPage(LOGIN_URL);
        waitForVisibilityOf(signInButton);
        return this;
    }

    public LinkedinLoginPage fillUpEmailPass (String email, String pass){
        type(email, emailField);
        type(pass, passField);
        return this;
    }

    public LinkedinCompanyPage pushSignInButton(){
        click(signInButton);
        return new LinkedinCompanyPage(driver);
    }

}
