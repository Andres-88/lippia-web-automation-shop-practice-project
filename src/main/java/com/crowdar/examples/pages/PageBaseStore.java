package com.crowdar.examples.pages;
import com.crowdar.core.pageObjects.PageBaseWeb;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageBaseStore extends PageBaseWeb {

    public PageBaseStore(RemoteWebDriver driver) {
        super(driver);
        BASE_URL = "http://automationpractice.com";
    }

}