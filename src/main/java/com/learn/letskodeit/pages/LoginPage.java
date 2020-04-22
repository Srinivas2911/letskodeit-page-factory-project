package com.learn.letskodeit.pages;

import com.learn.letskodeit.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class LoginPage extends Utility {

    //Log the webelements and methods into Log4j reports
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

//Using selenium @Findby and initElement methods
// using _ help separate from variable

    @FindBy(className="text-center")
    WebElement _loginPageWelcomeText;

    @FindBy(id ="user_email")
    WebElement _emailField;

@FindBy(id = "user_password")
WebElement _passwordField;

@FindBy(name ="commit")
WebElement _loginButton;

@FindBy(xpath = "//div[@class='alert alert-danger']")
WebElement _alertMessage;

//        By loginPageWelcomeText = By.className("text-center");
//    By emailField = By.id("user_email");
//    By passwordField = By.id("user_password");
//    By loginButton = By.name("commit");
//    By alertMessage = By.xpath("//div[@class='alert alert-danger']");

    public void LoginPageTextIsDisplayed(){
        Reporter.log("Verifying the LogIn Text : " + _loginPageWelcomeText.toString() + "<br>");
        verifyThatTextIsDisplayed((By) _loginPageWelcomeText,  "    Log In to Let's Kode It");
        log.info("Verifying the LogIn Text : " + _loginPageWelcomeText.toString());
    }

    public void enterEmailField (String email){
        Reporter.log("Entering Email  : "+email + _emailField.toString() + "<br>");
        sendTextToElement(_emailField, email);
        log.info("Entering Email : " + _emailField.toString());
    }

    public void enterPasswordField (String password){
        Reporter.log("Entering Password : "+password + _passwordField.toString() + "<br>");
        sendTextToElement(_passwordField, password);
        log.info("Entering Password : " + _passwordField.toString());

    }

public void clickOnLoginButton (){
    Reporter.log("Clicking on Login Button : " + _loginButton.toString() + "<br>");
    clickOnElement(_loginButton);
    log.info("Clicking on Login Button: " + _loginButton.toString());

}

public String getLoginErrorAlert (){
    Reporter.log("Getting the Alert Message : " + _alertMessage.toString() + "<br>");
    log.info("Getting the Alert Message : "+getLoginErrorAlert() + _alertMessage.toString());
    return getTextFromElement(_alertMessage);
}
}
