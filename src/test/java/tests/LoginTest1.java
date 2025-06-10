package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest1 extends BaseTest {

    @Description("Проверка логина с пустым полем Password")
    @Test(testName = "Негативный тест логина",
            description = "Проверка логина с пустым полем Password")
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не появилось!");
    }

    @Description("Проверка логина с неправильным паролем")
    @Test(testName = "Негативный тест логина",
            description = "Проверка логина с неправильным паролем")
    public void checkLoginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "1234567");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось!");
    }

    @Description("Проверка логина с валидными данными")
    @Test(testName = "Позитивный тест логина",
            description = "Проверка логина с валидными данными")
    public void checkLoginWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен!");
    }

    @Description("Проверка логина с пустым полем Username")
    @Test(testName = "Негативный тест логина",
            description = "Проверка логина с пустым полем Username")
    public void checkLoginWithEmptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось!");
    }

}
