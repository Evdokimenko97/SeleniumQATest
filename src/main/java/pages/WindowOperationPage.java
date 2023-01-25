package pages;

import org.openqa.selenium.By;

public class WindowOperationPage extends SandboxPage {
    private By buttonWindowOperations = By.xpath("//a[contains(text(),'Window Operations')]");
    private By newWindow = By.xpath("//button/b[text()='New Window']");

    public WindowOperationPage clickWindowOperationPage() {
        clickWithScroll(buttonWindowOperations);
        return new WindowOperationPage();
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public void clickNewWindowButton() {
        clickWithScroll(newWindow);
    }
}
