package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void checkAddToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(),
                "Products",
                "Переход на страницу не выполнен!");

        productsPage.clickAddToCartButton();
        assertEquals(productsPage.getRemoveButtonTitle(),
                "Remove",
                "Продукт не был добавлен!");

    }

    @Test
    public void checkShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Переход на страницу не выполнен");

        productsPage.clickShoppingCart();
        assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Переход на страницу не выполнен!");
    }
}

