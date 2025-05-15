package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CheckoutTest extends BaseTest {

    @Test
    public void isPersonalInfoValid() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Страница не открылась");
        checkoutPage.fillPersonalInfo("Tahmina", "Yuldasheva", "04368");
    }
@Epic("Заполнение информации о покупателе")
@Feature("Форма покупателя")
@Story("Ввод пустого имени в форме")
@Description("Проверка регистрации покупателя с пустым полем для имени")
@Severity(SeverityLevel.MINOR)
@Owner("Tahachka")
@TmsLink("SD-01")
@Issue("SD-BUG-01")
@Link(name = "Документация", url = "https://github.com/borodicht/AllureReportingGoogle")
@Flaky

    @Test (testName = "Негативный тест формы покупателя")
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

    @Test
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

    @Test
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
