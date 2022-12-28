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

    public void switchToNewWindow() {
        // Get current window handle
        String currentWindow = getWindowHandle();

        // Get all window handles
        Set<String> handles = getWindowHandles();

        // Switch to a new window
        Iterator<String> iter = handles.iterator();
        String newWindow = null;
        while (iter.hasNext()) {
            newWindow = iter.next();
            if (!currentWindow.equals(newWindow)) {
                driver.switchTo().window(newWindow);
            }
        }
    }
}
