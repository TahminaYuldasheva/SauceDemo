package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Log4j2
public class CheckoutPage extends BasePage {
    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By FIRST_NAME = By.xpath("//*[@data-test='firstName']");
    private static final By LAST_NAME = By.xpath("//*[@data-test='lastName']");
    private static final By POSTAL_CODE = By.xpath("//*[@data-test='postalCode']");
    private static final By CONTINUE = By.xpath("//*[@data-test='continue']");
    private static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Test
    public String getTitle() {
        String title = driver.findElement(TITLE).getText();
        log.info("Getting title text: {}", title);
        return title;
    }

    @Step("Заполнение формы покупателя именем: {firstName}, фамилией: {lastName} и индексом: {postalCode}")
    public void fillPersonalInfo(String firstName, String lastName, String postalCode) {
        log.info("Filling out the buyer form with first name: {}, last name: {} and postal code: {}",
                firstName, lastName, postalCode);
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
        driver.findElement(CONTINUE).click();
    }

    public String getErrorMessage() {
        String errorText = driver.findElement(ERROR_MESSAGE).getText();
        log.info("Getting error message: {}", errorText);
        return errorText;
    }
}
