package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.awt.*;

public class ShopConfirmPurchase extends PageBaseStore{
    private final String TITLE_CART_PURCHASE = "#cart_title";
    private final String INPUT_EMAIL_ID = "email";
    private final String INPUT_PASSWORD_ID = "passwd";
    private final String BUTTON_SIGN_IN_ID = "SubmitLogin";
    private final String BUTTON_PROCEED_TO_CHECKOUT_CSS_SELECTOR = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium";
    private final String BUTTON_PROCEED_TO_CHECKOUT_2_CSS_SELECTOR = "#center_column > form > p > button";
    private final String BUTTON_PROCEED_TO_CHECKOUT_3_CSS_SELECTOR = "#form > p > button";
    private final String BUTTON_PROCEED_TO_CHECKOUT_4_CSS_SELECTOR = "#cart_navigation > button";
    private final String CHECK_BOX_TERMS_ID = "cgv";
    private final String BUTTON_PAY_FORM_CSS_SELECTOR = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a";
    private final String TITLE_ORDER_CONFIRMATION_CSS_SELECTOR = "#center_column > h1";

    public ShopConfirmPurchase(RemoteWebDriver driver) {
        super(driver);
        this.url = "/index.php?controller=order";
    }

    public void verifyShopConfirmPurchase(){
        waitForElementVisibility(By.cssSelector(TITLE_CART_PURCHASE));
        Assert.assertTrue(isElementVisible(By.cssSelector(TITLE_CART_PURCHASE)));
    }

    public void go(){
        navigateToCompleteURL();
    }

    public void clickProceedToCheckout(){
        clickElement(By.cssSelector(BUTTON_PROCEED_TO_CHECKOUT_CSS_SELECTOR));
    }

    public void logIn(String correo, String pass){
        completeField(By.id(INPUT_EMAIL_ID), correo);
        completeField(By.id(INPUT_PASSWORD_ID), pass);
        clickElement(By.id(BUTTON_SIGN_IN_ID));
    }

    public void clickProceedToCheckout2(){
        clickElement(By.cssSelector(BUTTON_PROCEED_TO_CHECKOUT_2_CSS_SELECTOR));
    }

    public void clickTerms(){
        //Checkbox terms = new Checkbox();
        //terms.action(clickElement(By.id(CHECK_BOX_TERMS_ID), By.id(CHECK_BOX_TERMS_ID));

        //IWebElement terms = driver.findElement(By.id(CHECK_BOX_TERMS_ID));
        //terms.Click();

        driver.findElement(By.id(CHECK_BOX_TERMS_ID)).click();
    }

    public void clickProceedToCheckout3(){
        clickElement(By.cssSelector(BUTTON_PROCEED_TO_CHECKOUT_3_CSS_SELECTOR));
    }

    public void clickButtonPayForm(){
        clickElement(By.cssSelector(BUTTON_PAY_FORM_CSS_SELECTOR));
    }

    public void clickProceedToCheckout4(){
        clickElement(By.cssSelector(BUTTON_PROCEED_TO_CHECKOUT_4_CSS_SELECTOR));
    }

    public void verifyShopProductFinalTittle(){
        waitForElementVisibility(By.cssSelector(TITLE_ORDER_CONFIRMATION_CSS_SELECTOR));
        Assert.assertTrue(isElementVisible(By.cssSelector(TITLE_ORDER_CONFIRMATION_CSS_SELECTOR)));
    }
}
