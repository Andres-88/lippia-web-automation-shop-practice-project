package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.ShopConfirmPurchase;
import com.crowdar.examples.pages.ShopProductSelected;
import com.crowdar.examples.pages.ShopResultsPage;
import com.crowdar.examples.pages.StoreHomePage;
import cucumber.api.java8.En;
import io.cucumber.java.en.*;

public class ShoppingSteps extends PageSteps {
    @Given("el cliente hace foco en el buscador de productos")
    public void elClienteHaceFocoEnElBuscadorDeProductos(){
        Injector._page(StoreHomePage.class).go();
    }

    @When("el cliente ingresa (.*) en el buscador")
    public void elClienteIngresaProductoEnElBuscador(String busqueda) {
        Injector._page(StoreHomePage.class).enterSearch(busqueda);
    }

    @Then("el cliente es redirigido a la pantallas de resultados")
    public void elClienteEsRedirigidoALaPantallasDeResultados() {
        Injector._page(ShopResultsPage.class).verifyShopResultsPage();
    }
    //----------------------------------------------------------------------------------------------------------------------

    @Given("el cliente se encuentra en la pagina de resultados")
    public void elClienteSeEncuentraEnLaPaginaDeResultados() {
        Injector._page(ShopResultsPage.class).go();
    }

    @When("el cliente elige un (.*)")
    public void elClienteEligeUnProducto(String producto) {
        Injector._page(ShopResultsPage.class).selectProduct(producto);
    }

    @Then("el cliente es redirigido al producto que selecciono")
    public void elClienteEsRedirigidoAlProductoQueSelecciono() {
        Injector._page(ShopProductSelected.class).verifyShopProduct();
    }

    //----------------------------------------------------------------------------------------------------------------------

    @Given("el cliente se encuentra en la pagina del producto seleccionado")
    public void elClienteSeEncuentraEnLaPaginaDelProductoSeleccionado() {
        Injector._page(ShopProductSelected.class).go();
    }

    @When("el ingresa una (.*)")
    public void elIngresaUnaCantidad(String cantidad) {
        Injector._page(ShopProductSelected.class).selectCantidad(cantidad);
    }

    @And("selecciona un (.*)")
    public void seleccionaUnTalle(String talle)
    {
        Injector._page(ShopProductSelected.class).selectTalle(talle);
    }

    @And("elige un (.*)")
    public void eligeUnColor(String color) {

        Injector._page(ShopProductSelected.class).selectColor(color);
    }

    @And("hace click en el botón Add To Cart")
    public void haceClickEnElBotonAddToCart() {
        Injector._page(ShopProductSelected.class).clickAddToCart();
    }

    @And("clickea el botón Proceed to Checkout")
    public void clickeaElBotonProceedToCheckout() {
        Injector._page(ShopProductSelected.class).clickProceedToCheckOut();
    }

    @Then("el cliente es redireccionado al carrito de compra")
    public void elClienteEsRedireccionadoAlCarritoDeCompra() {
        Injector._page(ShopConfirmPurchase.class).verifyShopConfirmPurchase();
    }

    //----------------------------------------------------------------------------------------------------------------------

    @Given("el cliente se encuentra en el carrito de compras y está registrado")
    public void elClienteSeEncuentraEnElCarritoDeCompras() {
        Injector._page(ShopProductSelected.class).go();
        Injector._page(ShopProductSelected.class).selectCantidad("1");
        Injector._page(ShopProductSelected.class).selectTalle("S");
        Injector._page(ShopProductSelected.class).selectColor("negro");
        Injector._page(ShopProductSelected.class).clickAddToCart();
        Injector._page(ShopProductSelected.class).clickProceedToCheckOut();
        Injector._page(ShopConfirmPurchase.class).verifyShopConfirmPurchase();
    }

    @When("el cliente hace click en {string}")
    public void elClienteHaceClickEn(String arg0) {
        Injector._page(ShopConfirmPurchase.class).clickProceedToCheckout();
    }

    @And("el cliente se loggea y hace click en el botón {string}")
    public void elClienteSeLoggeaHaciendoClickEnElBotón(String arg0) {
        Injector._page(ShopConfirmPurchase.class).logIn("andres_themaster@hotmail.com", "123654");
    }

    @And("el cliente corfirma la dirección haciendo click en {string}")
    public void elClienteCorfirmaLaDireccionHaciendoClickEn(String arg0) {
        Injector._page(ShopConfirmPurchase.class).clickProceedToCheckout2();
    }

    @And("el cliente acepta los terminos de servicios haciendo click en el checkbox y clickea en {string}")
    public void elClienteAceptaLosTerminosDeServiciosHaciendoClickEnElCheckboxYClickeaEn(String arg0) {
        Injector._page(ShopConfirmPurchase.class).clickTerms();
        Injector._page(ShopConfirmPurchase.class).clickProceedToCheckout3();
    }

    @And("el cliente elige la opcion de pago")
    public void elClienteEligeLaOpcionDePago() {
        Injector._page(ShopConfirmPurchase.class).clickButtonPayForm();
    }

    @And("el cliente hace click en el boton de {string}")
    public void elClienteHaceClickEnElBotonDe(String arg0) {
        Injector._page(ShopConfirmPurchase.class).clickProceedToCheckout4();
    }

    @Then("el cliente es redireccionado a la pantalla de {string}")
    public void elClienteEsRedireccionadoALaPantallaDe(String arg0) {
        Injector._page(ShopConfirmPurchase.class).verifyShopProductFinalTittle();
    }

}
