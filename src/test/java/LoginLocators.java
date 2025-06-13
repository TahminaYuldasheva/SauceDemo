import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginLocators {

    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.partialLinkText("Labs Backpack"));
        driver.findElement(By.linkText("Logout"));

        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("password"));
        driver.findElement(By.className("login_logo"));
        driver.findElement(By.tagName("div"));

        driver.findElement(By.xpath("//button[@name='add-to-cart']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        driver.findElement(By.xpath("//button[contains(@name,'back-to-products')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Reset')]"));
        driver.findElement(By.xpath("//*[@class='header_label']//descendant::div[@class='app_logo']"));
        driver.findElement(By.xpath("//*[@target='_blank']/ancestor::ul[@class='social']"));
        driver.findElement(By.xpath("//*[@name='back-to-products']"));
        driver.findElement(By.xpath("//*[@class='inventory_list']" +
                "//following::div[@class='inventory_item']"));
        driver.findElement(By.xpath("//*[@class='inventory_item_price']/parent::div[@class='pricebar']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']" +
                "/preceding::span[text()='Products'][1]"));
        driver.findElement(By.xpath("//div[@class='inventory_item' and @data-test='inventory-item']"));

        driver.findElement(By.cssSelector(".btn_inventory"));
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.cssSelector("button.btn_primary"));
        driver.findElement(By.cssSelector("[id=add-to-cart-sauce-labs-backpack]"));
        driver.findElements(By.cssSelector("[id ~= inventory_item_price]"));
        driver.findElements(By.cssSelector("[data-test|=inventory-item]"));
        driver.findElements(By.cssSelector("[class^=inventory]"));
        driver.findElements(By.cssSelector("[id$=-desc]"));
        driver.findElements(By.cssSelector("[class*=item]"));
        driver.quit();
    }
}
