package pages;

import org.openqa.selenium.By;

public class FileDownloadPage extends BasePage {
    private By buttonFileDownload = By.xpath("//a[text()='File Download']");
    private By pdfDownloadBtn = By.xpath("//a[@class='wpdm-download-link download-on-click btn btn-primary ']");

    public FileDownloadPage clickFileDownloadPage() {
        click(buttonFileDownload);
        return new FileDownloadPage();
    }

    public String getFileDownloadPage() {
        return driver.getTitle();
    }

    public FileDownloadPage downloadPage() {
        click(pdfDownloadBtn);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
