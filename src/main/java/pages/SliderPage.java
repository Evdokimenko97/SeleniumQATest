package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SliderPage extends SandboxPage {
    private By buttonSliders = By.xpath("//a[text()='Sliders']");
    private By formSlider = By.xpath("//input[@id='slideMe']");

    public SliderPage clickSlidersPage() {
        clickWithScroll(buttonSliders);
        return new SliderPage();
    }

    public String getSliderPage() {
        return driver.getTitle();
    }

    public void clickSlider(int x, int y) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(formSlider), x, y).click().build().perform();
     }
}
