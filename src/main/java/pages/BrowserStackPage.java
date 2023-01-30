package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserStackPage extends BasePage {

    private static final By products = By.xpath("//nav[@id='product-nav']//button[@aria-label='Products']");
    private static final By liveInProducts = By.xpath("//nav[@id='product-nav']//div[@class='dropdown-link-heading'][text()=' Live ']");

    public void selectIntroToSeleniumWebDriver() {
        hoverOverElement(products);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(liveInProducts));
    }

    public BrowserStackPage screenshotProductsButton() {
        takeElementScreenshot(products);
        return this;
    }
}
