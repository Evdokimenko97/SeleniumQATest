package pages;

import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class WindowOperationPage extends SandboxPage {
    private By buttonWindowOperations = By.xpath("//a[contains(text(),'Window Operations')]");
    private By newWindow = By.xpath("//button/b[text()='New Window']");

    public WindowOperationPage clickWindowOperationPage() {
        click(buttonWindowOperations);
        return new WindowOperationPage();
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public void clickNewWindowButton() {
        click(newWindow);
    }
}
