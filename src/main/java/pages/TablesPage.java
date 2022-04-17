package pages;

import org.openqa.selenium.By;

public class TablesPage extends SandboxPage {
    private By buttonTables = By.xpath("//a[contains(text(),'Tables')]");

    public TablesPage clickTables() {
        driver.findElement(buttonTables).click();
        return new TablesPage();
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public String getItemPrice(String item) {
        return driver.findElement(By.xpath("//td[text()='" + item + "']/following-sibling::td")).getText();
    }
}
