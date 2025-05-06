package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void checkCartIsNotEmpty() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton();
        productsPage.clickShoppingCart();
        assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Переход на страницу не выполнен!");
        assertTrue(cartPage.isCartNotEmpty(), "Корзина пуста!");
    }

    @Test
    public void checkCheckoutButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton();
        productsPage.clickShoppingCart();
        assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Переход на страницу не выполнен!");

        cartPage.clickCheckoutButton();

        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Переход на страницу не был выполнен!");
    }

    @Test
    public void checkContinueShoppingButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton();
        productsPage.clickShoppingCart();

        assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Переход на страницу не выполнен!");

        cartPage.clickContinueShoppingButton();

        assertEquals(productsPage.getTitle(),
                "Products",
                "Переход на страницу не выполнен!");
    }
}
