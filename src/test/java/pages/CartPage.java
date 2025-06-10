package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private final By CHECKOUT_ID = By.id("checkout");
    private final By CONTINUE_SHOPPING = By.id("continue-shopping");
    private final By CART_ITEM = By.xpath("//*[@data-test='inventory-item']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        String title = driver.findElement(TITLE).getText();
        log.info("Getting title text: {}", title);
        return title;
    }

    @Step("Нажатие на кнопку Checkout")
    public void clickCheckoutButton() {
        log.info("Clicking on Checkout button");
        driver.findElement(CHECKOUT_ID).click();
    }

    public boolean isCartNotEmpty() {
        log.info("Checking if cart is not empty");
        return driver.findElement(CART_ITEM).isDisplayed();
    }

    @Step("Нажатие на кнопку Continue Shopping")
    public void clickContinueShoppingButton() {
        log.info("Clicking Continue Shopping button");
        driver.findElement(CONTINUE_SHOPPING).click();
    }
}
