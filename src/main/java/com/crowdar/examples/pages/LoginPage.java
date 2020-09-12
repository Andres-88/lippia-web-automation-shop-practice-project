package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class LoginPage extends PageBaseStore {

    public LoginPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    private final String PASS_INPUT_CSS_SELECTOR = "#passwd";
    private final String EMAIL_INPUT_CSS_SELECTOR = "#email";


    public void setPassword(String pass){

        completeField(By.cssSelector(PASS_INPUT_CSS_SELECTOR), pass);
    }

    public void setEmail(String email){

        completeField(By.cssSelector(EMAIL_INPUT_CSS_SELECTOR), email);
    }


}
