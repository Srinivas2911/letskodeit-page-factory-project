package com.learn.letskodeit.testbase;

import com.learn.letskodeit.basepage.BasePage;
import com.learn.letskodeit.browserselector.BrowserSelector;
import com.learn.letskodeit.loadproperty.LoadProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase extends BasePage {
// Object for Browser Selector class and Load property class
    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperty loadProperty = new LoadProperty();

    // Defining browser & baseUrl as String variable to call from load properties which depends on config.propeties
    String browser = loadProperty.getProperty("browser");
    String baseUrl = loadProperty.getProperty("baseUrl");

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void openBrowser() {

        browserSelector.selectBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterMethod(groups = {"sanity", "smoke", "regression"})
    public void tearDown() {
        driver.quit();
    }

}
