package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Description("Проверка регистрации с валидными данными на странице Checkout: Your Information")
    @Test(testName = "Позитивный тест страницы Checkout: Your Information",
            description = "Проверка регистрации с валидными данными на странице Checkout: Your Information")
    public void isPersonalInfoValid() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.fillPersonalInfo("Tahmina", "Yuldasheva", "043678");
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Overview",
                "Переход на страницу не выполнен!");
    }
@Epic("Заполнение информации о покупателе")
@Feature("Форма покупателя")
@Story("Ввод пустого имени в форме")
@Severity(SeverityLevel.MINOR)
@Owner("Tahachka")
@TmsLink("SD-01")
@Issue("SD-BUG-01")
@Link(name = "Документация", url = "https://github.com/borodicht/AllureReportingGoogle")
@Flaky

    @Description("Проверка регистрации на странице Checkout: Your Information с пустым полем First Name")
    @Test(testName = "Негативный тест страницы Checkout: Your Information",
            description = "Проверка регистрации на странице Checkout: Your Information с пустым полем First Name")
    public void checkEmptyFirstNameField() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.fillPersonalInfo("", "Yuldasheva", "04368");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение об ошибке не появилось!");
    }

    @Description("Проверка регистрации на странице Checkout: Your Information с пустым полем Last Name")
    @Test(testName = "Негативный тест страницы Checkout: Your Information",
            description = "Проверка регистрации на странице Checkout: Your Information с пустым полем Last Name")
    public void checkEmptyLastNameField() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.fillPersonalInfo("Tahmina", "", "04368");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Сообщение об ошибке не появилось!");
    }

    @Description("Проверка регистрации на странице Checkout: Your Information с пустым полем Postal Code")
    @Test(testName = "Негативный тест страницы Checkout: Your Information",
            description = "Проверка регистрации на странице Checkout: Your Information с пустым полем Postal Code")
    public void checkEmptyPostalCodeField() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.fillPersonalInfo("Tahmina", "Yuldasheva", "");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение об ошибке не появилось!");
    }
}
