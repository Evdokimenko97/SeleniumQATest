package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchBoxesPage extends SandboxPage {
    private By buttonSearchBoxesPage = By.xpath("//a[contains(text(),'Search Boxes')]");
    private By searchBox = By.xpath("//input[@id='wp-block-search__input-1']");
    private By buttonSearch = By.xpath("//button[text()='Search']");
    private By noSearchResults = By.xpath("//div/h4[text()='Nothing Found']");

    public SearchBoxesPage clickSearchPage() {
        click(buttonSearchBoxesPage);
        return new SearchBoxesPage();
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public boolean search(String text) {
        setText(searchBox, text);
        click(buttonSearch);

        if(driver.findElements(noSearchResults).size() > 0) {
            goBack();
            return false;
        }
        return true;
    }
}
