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
        clickWithScroll(buttonPopups);
        return new PopupsPage();
    }

    public String getPopupsPage() {
        return getDriver().getTitle();
    }

    public void clickAlertPopup() {
        clickWithScroll(buttonAlert);
    }

    public void clickConfirmPopup() {
        clickWithScroll(buttonConfirm);
    }

    public void clickPromptPopup() {
        clickWithScroll(buttonPrompt);
    }

    public String getConfirmPopupSelection() {
        return getText(confirmResult);
    }

    public void waitForPromptPopupResult(String expectedText) {
        waitForElementText(promptResult, expectedText);
    }
}
