package pages;

import org.openqa.selenium.By;

public class ModalsPage extends SandboxPage {
    private By buttonModals = By.xpath("//a[text()='Modals']");
    private By formModal = By.xpath("//button[@id='formModal']");
    private By nameFormModal = By.xpath("//input[@id='g1051-name']");
    private By emailFormModal = By.xpath("//input[@id='g1051-email']");
    private By messageFormModal = By.xpath("//textarea[@name='g1051-message']");
    private By submitFormModal = By.xpath("//button[@class='pushbutton-wide']");

    public ModalsPage clickModalsPage() {
        clickWithScroll(buttonModals);
        return new ModalsPage();
    }

    public String getModalsPage() {
        return getDriver().getTitle();
    }

    public void clickFormModal() {
        clickWithScroll(formModal);
    }

    public ModalsPage modalSendMessage(String name, String email, String message) {
        setText(nameFormModal, name);
        setText(emailFormModal, email);
        setText(messageFormModal, message);
        clickWithScroll(submitFormModal);
        return this;
    }
}
