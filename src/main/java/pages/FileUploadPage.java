package pages;

import org.openqa.selenium.By;

public class FileUploadPage extends BasePage {
    private By buttonFileUpload = By.xpath("//a[text()='File Upload']");
    private By chooseFileBtn = By.xpath("//input[@id='file_upload']");
    private By uploadBtn = By.xpath("//input[@value='Upload It!']");
    private By uploadStatus = By.xpath("//div[@class='wpcf7-response-output']");

    public FileUploadPage clickFileUploadPage() {
        clickWithScroll(buttonFileUpload);
        return new FileUploadPage();
    }

    public String getFileUploadPage() {
        return driver.getTitle();
    }

    public FileUploadPage uploadFile(String filePath) {
        driver.findElement(chooseFileBtn).sendKeys(filePath);
        clickWithScroll(uploadBtn);
        waitForElementText(uploadStatus, "File upload complete");
        return this;
    }
}
