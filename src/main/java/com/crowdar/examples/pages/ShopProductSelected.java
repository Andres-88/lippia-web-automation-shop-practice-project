package com.crowdar.examples.pages;

import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShopProductSelected extends PageBaseStore{


    private final String MODELO_PRODUCTO_CSS_SELECTOR = "#short_description_content > p";
    private final String SELECT_CANTIDAD_ID = "quantity_wanted";
    private final String SELECT_TALLE_CSS_ID = "group_1";
    private final String SELECT_TALLE_CSS_SELECTOR = "#group_1 > option:nth-child(1)";
    private String SELECT_COLOR_ID;
    private final String BUTTON_ADD_TO_CART = "#add_to_cart > button";
    private final String TITLE_SUCCESS_CSS_SELECTOR = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a";
    private final String CLICK_FUERA_FOCO_CSS_SELECTOR = "#page > div.columns-container";

    public ShopProductSelected(RemoteWebDriver driver) {
        super(driver);
        this.url = "/index.php?id_product=2&controller=product&search_query=dress&results=7";
    }

    public void go(){

        navigateToCompleteURL();
    }

    public void selectCantidad(String cantidad){
        completeField(By.id(SELECT_CANTIDAD_ID), cantidad);
    }

    public void selectTalle(String talle){
        Select talleElegido = new Select(driver.findElement(By.id("group_1")));
        talleElegido.selectByVisibleText(talle);
    }

    public void selectColor(String color){

        if (color.equals("negro")){
            SELECT_COLOR_ID = "color_11";
            clickElement(By.id(SELECT_COLOR_ID));
        }

        if (color.equals("white")){
            SELECT_COLOR_ID = "color_8";
            clickElement(By.id(SELECT_COLOR_ID));
        }

    }

    public void clickAddToCart(){
        clickElement(By.cssSelector(BUTTON_ADD_TO_CART));
    }

    public void clickProceedToCheckOut(){

        clickElement(By.cssSelector(TITLE_SUCCESS_CSS_SELECTOR));
    }

    public void verifyShopProduct(){
        waitForElementVisibility(By.cssSelector(MODELO_PRODUCTO_CSS_SELECTOR));
        Assert.assertTrue(isElementVisible(By.cssSelector(MODELO_PRODUCTO_CSS_SELECTOR)));
    }
}
