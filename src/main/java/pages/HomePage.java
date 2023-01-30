package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public static final By firstVideo = By.xpath("//h2/a[@rel='bookmark']");

    public String getTitleHomePage() {
        return getDriver().getTitle();
    }

    public String nameFirstVideo() {
        return getDriver().findElement(firstVideo).getText();
    }
}
