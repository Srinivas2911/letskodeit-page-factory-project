package com.learn.letskodeit.pages;

import com.learn.letskodeit.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    //Log the webelements and methods into Log4j reports
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

//Using selenium @Findby and initElement methods
// using _ help separate from variable

//      By welcomeText = By.className("headline");
//    By practiceLink = By.partialLinkText("Practi");
//    By loginLink = By.partialLinkText("Login");
//    By signUpLink = By.xpath("//a[@id='header-sign-up-btn']");

    @FindBy(className = "headline")
    WebElement _welcomeText;

    @FindBy(partialLinkText = "Practi")
    WebElement _practiceLink;

    @FindBy(partialLinkText = "Login")
    WebElement _loginLink;

    @FindBy(xpath = "//a[@id='header-sign-up-btn']")
    WebElement _signUpLink;

    public void practiceLinkisDisplayed() {
        Reporter.log("Displaying Practice Link " + _practiceLink.toString() + "<br>");
        verifyThatElementIsDisplayed(_practiceLink);
        log.info("Displaying Practice link : " + _loginLink.toString());
    }

    public void loginLinkIsDisplayed() {
        Reporter.log("Displaying Login link : " + _loginLink.toString() + "<br>");
        verifyThatElementIsDisplayed(_loginLink);
        log.info("Displaying Login link : " + _loginLink.toString());
    }

    public void signUpLinkIsDisplayed() {
        Reporter.log("Displaying Sign Up Link : " + _signUpLink.toString() + "<br>");
        verifyThatElementIsDisplayed(_signUpLink);
        log.info("Displaying Sign Up link : " + _signUpLink.toString());

    }

    public void clickOnPracticeLink() {
        Reporter.log("Clicking on Practice Link : " + _practiceLink.toString() + "<br>");
        clickOnElement(_practiceLink);
        log.info("Clicking on Practice Link : " + _practiceLink.toString());
    }

    public void clickOnLoginLink() {
        Reporter.log(" Clicking on Login Link : " + _loginLink.toString() + "<br>");
        clickOnElement(_loginLink);
        log.info("Clicking on Login Link : " + _loginLink.toString());

    }

    public void clickOnSignUplink() {
        Reporter.log("Clicking on Sign Up link : " + _signUpLink.toString() + "<br>");
        clickOnElement(_signUpLink);
        log.info("Clicking on Sign Up link : " + _signUpLink.toString());

    }

}
