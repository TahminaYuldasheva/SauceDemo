package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Description("Проверка наличия товара в корзине после добавления")
    @Test(testName = "Позитивный тест страницы Your Cart",
            description = "Проверка наличия товара в корзине после добавления")
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

    @Description("Проверка перехода со страницы Your Cart на страницу Checkout: Your Information")
    @Test(testName = "Позитивный тест страницы Your Cart",
            description = "Проверка перехода со страницы Your Cart на страницу Checkout: Your Information")
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

    @Description("Проверка перехода со страницы Your Cart на страницу Products при нажатии на кнопку Continue Shopping")
    @Test(testName = "Позитивный тест страницы Your Cart",
            description = "Проверка перехода со страницы Your Cart на страницу Products при нажатии на кнопку" +
                    "Continue Shopping")
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
