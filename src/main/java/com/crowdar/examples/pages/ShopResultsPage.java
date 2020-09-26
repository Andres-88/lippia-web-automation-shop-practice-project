package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShopResultsPage extends PageBaseStore{

    private final String PRODUCTO_CSS_SELECTOR = "#center_column > ul > li > div > div.left-block > div > a.product_img_link";
    private final String PRODUCTO_SELECCIONADO_CSS_SELECTOR = "#center_column > ul > li:nth-child(7) > div";
    private final String BOTON_MORE_CSS_SELECTOR = "#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default";
    private final String INPUT_SEARCH_ID = "search_query_top";
    private final String BUTTON_SEARCH_CSS_SELECTOR = "#searchbox > button";

    public ShopResultsPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "/index.php?controller=search&orderby=position&orderway=desc&search_query=&submit_search=";
    }

    public void go(){
        navigateToCompleteURL();
    }

    public void selectProduct(String producto){
        completeField(By.id(INPUT_SEARCH_ID), producto);
        clickElement(By.cssSelector(BUTTON_SEARCH_CSS_SELECTOR));

        clickElement(By.cssSelector(PRODUCTO_SELECCIONADO_CSS_SELECTOR));
        //waitForElementVisibility(By.cssSelector(BOTON_MORE_CSS_SELECTOR));
        //clickElement(By.cssSelector(BOTON_MORE_CSS_SELECTOR));
        driver.findElement(By.cssSelector(BOTON_MORE_CSS_SELECTOR)).click();
    }

    public void verifyShopResultsPage(){
        waitForElementVisibility(By.cssSelector(PRODUCTO_CSS_SELECTOR));
        Assert.assertTrue(isElementVisible(By.cssSelector(PRODUCTO_CSS_SELECTOR)));
    }

}
