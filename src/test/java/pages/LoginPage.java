package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private static final By USERNAME_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы LoginPage")
    public void open() {
        log.info("Opening Login Page");
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Вход в систему с именем пользователя: {user} и паролем: {password}")
    public void login(String user, String password) {
        log.info("Login with username: {} and password: {}", user, password);
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        String errorText = driver.findElement(ERROR_MESSAGE).getText();
        log.info("Getting error message: {}", errorText);
        return errorText;
    }
}

