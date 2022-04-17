package pages;

import org.openqa.selenium.By;

public class NavigationBar extends BasePage {
    private By sandbox = By.cssSelector("span[data-hover='Sandbox']");
    
    public SandboxPage selectSandBox() {
        driver.findElement(sandbox).click();
        return new SandboxPage();
    }
}
