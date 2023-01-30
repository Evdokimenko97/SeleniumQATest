package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablesPage extends SandboxPage {
    private By buttonTables = By.xpath("//a[contains(text(),'Tables')]");
    private By countrySort = By.xpath("//th[@class='column-2 sorting']");
    private By nextBtn = By.xpath("//a[@class='paginate_button next']");
    private By nextBtnDisable = By.xpath("//a[@class='paginate_button next disabled']");

    public TablesPage clickTables() {
        getDriver().findElement(buttonTables).click();
        return new TablesPage();
    }

    public String getTitlePage() {
        return getDriver().getTitle();
    }

    public String getItemPrice(String item) {
        return getDriver().findElement(By.xpath("//td[text()='" + item + "']/following-sibling::td")).getText();
    }

    public void sortByCountry() {
        click(countrySort);
    }

    public String getPopulation(String country) {
        boolean foundCountry = false;

        while (!foundCountry) {
            List<WebElement> countryListOnCurrentPage = getDriver().findElements(By.xpath("//table[@id='tablepress-1']//td[normalize-space()='" + country + "']"));
            List<WebElement> disableNextBtn = getDriver().findElements(nextBtnDisable);

            if (countryListOnCurrentPage.size() > 0) {
                foundCountry = true;
            } else if (disableNextBtn.size() == 0) {
                clickWithScroll(nextBtn);
            } else {
                return "-1";
            }
        }
        return getText(By.xpath("//td[normalize-space()='" + country + "']/following-sibling::td"));
    }
}
