package pages;

import org.openqa.selenium.By;

public class PopupsPage extends SandboxPage {
    private By buttonPopups = By.xpath("//a[text()='Popups']");
    private By buttonAlert = By.xpath("//button[@id='alert']");
    private By buttonConfirm = By.xpath("//button[@id='confirm']");
    private By buttonPrompt = By.xpath("//button[@id='prompt']");
    private By confirmResult = By.xpath("//p[@id='confirmResult']");
    private By promptResult = By.xpath("//p[@id='promptResult']");

    public PopupsPage clickPopupsPage() {
        click(buttonPopups);
        return new PopupsPage();
    }

    public String getPopupsPage() {
        return driver.getTitle();
    }

    public void clickAlertPopup() {
        click(buttonAlert);
    }

    public void clickConfirmPopup() {
        click(buttonConfirm);
    }

    public void clickPromptPopup() {
        click(buttonPrompt);
    }

    public String getConfirmPopupSelection() {
        return getText(confirmResult);
    }

    public void waitForPromptPopupResult(String expectedText) {
        waitForElementText(promptResult, expectedText);
    }
}
