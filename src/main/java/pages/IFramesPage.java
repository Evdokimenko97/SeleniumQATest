package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IFramesPage extends BasePage {
    private By buttonIFrames = By.xpath("//a[text()='Iframes']");
    private By JS = By.xpath("//a[@title='JavaScript Tutorial']");
    private By iframeTutorial = By.xpath("//iframe[@title='W3Schools HTML Tutorial']");

    public IFramesPage clickIFramesPage() {
        clickWithScroll(buttonIFrames);
        return new IFramesPage();
    }

//    public String getTitle() {
//        return driver.getTitle();
//    }

    public void openIframe() {
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
    }

    public IFramesPage clickJS() {
        driver.findElement(JS).click();
        return this;
    }

    public WebElement frameTutorial() {
        return driver.findElement(iframeTutorial);
    }
}
