package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest1 extends BaseTest {

    @Test(testName = "Негативный тест логина",
            description = "Проверка логина в систему с пустым полем пароль",
    priority = 1)
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не появилось!");
    }

    @Test(priority = 2)
    public void checkLoginWithWrongPassword() {

        loginPage.open();
        loginPage.login("standard_user", "1234567");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось!");
    }


    @Test(priority = 3)
    public void checkLoginWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен!");
    }

    @Test(priority = 4)
    public void checkLoginWithEmptyUserName() {

        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не появилось!");
    }

}
