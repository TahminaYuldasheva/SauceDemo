package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By SHOPPING_CART = By.xpath("//*[@data-test='shopping-cart-link']");
    private static final By ADD_TO_CART = By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']");
    private final By REMOVE_BUTTON = By.xpath("//*[@data-test='remove-sauce-labs-backpack']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        String title = driver.findElement(TITLE).getText();
        log.info("Getting title text: {}", title);
        return title;
    }

    @Step("Добавление товара в корзину")
    public void clickAddToCartButton() {
        log.info("Attempting to add product to cart");
        driver.findElement(ADD_TO_CART).click();
    }

    public String getRemoveButtonTitle() {
        String removeButtonText = driver.findElement(REMOVE_BUTTON).getText();
        log.info("Verified 'Remove' button appeared with text: {}", removeButtonText);
        return removeButtonText;
    }

    @Step("Переход на страницу корзины")
    public void clickShoppingCart() {
        log.info("Navigating to shopping cart");
        driver.findElement(SHOPPING_CART).click();
    }
}
