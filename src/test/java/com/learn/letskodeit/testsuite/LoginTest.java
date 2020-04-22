package com.learn.letskodeit.testsuite;

import com.learn.letskodeit.pages.HomePage;
import com.learn.letskodeit.pages.LoginPage;
import com.learn.letskodeit.pages.MyCoursesPage;
import com.learn.letskodeit.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {
    HomePage homePage ;
    LoginPage loginPage;
    MyCoursesPage myCoursesPage;
    SoftAssert sa = new SoftAssert();

    String email = "Roger@gmail.com";
    String password = "Password123";
    String wrongPassword = "Password_1273";

    @BeforeMethod(groups = {"smoke", "sanity", "regression"})
    public void setUPMethod (){
        homePage = new HomePage();
        loginPage = new LoginPage();
         myCoursesPage = new MyCoursesPage();



    }

    @Test(priority = 0, groups = {"sanity", "smoke"})
    public void verifyThatLoginPageWelcomeTextisDisplayed() {
        homePage.clickOnLoginLink();
        loginPage.LoginPageTextIsDisplayed();
    }

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void verifyThatUserIsAbleToLogInSuccessfully() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailField(email);
        loginPage.enterPasswordField(password);
        loginPage.clickOnLoginButton();
    //    myCoursesPage.myCourseTextIsDisplayed();
        sa.assertEquals(myCoursesPage.getMyCourseText(), "My Courses");
        sa.assertAll();
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void verifyThatUserShouldNotToLogWithInvalidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailField(email);
        loginPage.enterPasswordField(wrongPassword);
        loginPage.clickOnLoginButton();
        loginPage.getLoginErrorAlert();
        sa.assertTrue(loginPage.getLoginErrorAlert().contains("Invalid email or password."));
        sa.assertAll();

    }
}
