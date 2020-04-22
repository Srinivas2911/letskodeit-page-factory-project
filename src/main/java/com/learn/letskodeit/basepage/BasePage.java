package com.learn.letskodeit.basepage;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    /*
    * Webdriver placed in thee Basepage and extended to all the classes
    */

    public static WebDriver driver;
     /*
     * Constructor created for this class
     * And initialise and WebElements for PageFactory thru the driver.
     * Configure the path for log4j properties for logging the records for the init elements
     * configuring for Log4j reports
     */
    public BasePage() {

            PageFactory.initElements(driver, this);
            PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/java/com/learn/letskodeit/resources/propertiesfile/log4j.properties");
    }
}
