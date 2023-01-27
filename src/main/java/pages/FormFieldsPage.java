package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormFieldsPage extends BasePage {
    private By inputField = By.cssSelector("input#g1103-name");
    private By dropDown = By.cssSelector("select#g1103-doyouhaveanysiblings");
    private By buttonFormFields = By.xpath("//a[contains(text(),'Form Fields')]");
    private By emailField = By.xpath("//input[@id='email']");
    private By messageField = By.xpath("//textarea[@name='message']");
    private By submitBtn = By.xpath("//button[@class='pushbutton-wide']");
    private By sentMessage = By.xpath("//h4[@id='contact-form-success-header']");

    public SandboxPage clickFormFields() {
        driver.findElement(buttonFormFields).click();
        return new SandboxPage();
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public FormFieldsPage setInputFieldText(String text) {
        setText(inputField, text);
        return this;
    }

    public String getInputFieldText() {
        return getText(inputField);
    }

    /**
     * Select a checkbox
     * @param option Range is 1 to 3
     */
    public FormFieldsPage selectCheckbox(String option) {
        driver.findElement(By.cssSelector("input[value='" + option + "']")).click();
        return this;
    }

    public boolean checkboxIsSelected(String option) {
        return driver.findElement(By.cssSelector("input[value='" + option + "']")).isSelected();
    }

    /**
     * @param option Displayed text
     */
    public FormFieldsPage selectDropdown(String option) {
        Select dDown = new Select(driver.findElement(dropDown));
        dDown.selectByVisibleText(option);
        return this;
    }

    /**
     * @return The option that is currently selected
     */
    public String getDropDownText() {
        Select dDown = new Select(driver.findElement(dropDown));
        return dDown.getFirstSelectedOption().getText();
    }

    /**
     * Select a radio button
     * @param option Case sensitive value
     */
    public FormFieldsPage selectRadioButton(String option) {
        WebElement radioButton = driver.findElement(By.cssSelector("input[value='" + option + "']"));
        scrollingPage(radioButton);
        radioButton.click();
        return this;
    }

    /**
     * @param option Radio button
     * @return Check that radio button is selected
     */
    public boolean radioButtonIsSelected(String option) {
        return driver.findElement(By.cssSelector("input[value='" + option + "']")).isSelected();
    }

    public FormFieldsPage setEmail(String text) {
        setText(emailField, text);
        return this;
    }

    public FormFieldsPage setMessage(String text) {
        setText(messageField, text);
        return this;
    }

    public FormFieldsPage clickSubmit() {
        driver.findElement(submitBtn).submit();
        return new FormFieldsPage();
    }

    public String getConfirmationMessage() {
        return driver.findElement(sentMessage).getText();
    }
}
