package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Description("Проверка перехода на страницу товаров и корректной работы кнопки Add to cart")
    @Test(testName = "Позитивный тест страницы Products",
            description = "Проверка перехода на страницу товаров и корректной работы кнопки Add to cart")
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

    @Description("Проверка перехода со страницы Products на страницу Your Cart")
    @Test(testName = "Позитивный тест страницы Products",
            description = "Проверка перехода со страницы Products на страницу Your Cart")
    public void checkShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Переход на страницу не выполнен!");

        productsPage.clickShoppingCart();
        assertEquals(cartPage.getTitle(),
                "Your Cart",
                "Переход на страницу не выполнен!");
    }
}

