package pages;

import org.openqa.selenium.By;

public class HoverPage extends SandboxPage {
    private By buttonHover = By.xpath("//a[text()='Hover']");
    private By hover = By.xpath("//h3[@id='mouse_over']");

    public HoverPage clickHoverPage() {
        clickWithScroll(buttonHover);
        return new HoverPage();
    }

    public String getHoverPage() {
        return driver.getTitle();
    }

    public HoverPage doHover() {
        hoverOverElement(hover);
        return this;
    }

    public String getHoverText() {
        return getText(hover);
    }
}
