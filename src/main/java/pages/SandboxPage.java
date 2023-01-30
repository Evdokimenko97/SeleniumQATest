package pages;

public class SandboxPage extends BasePage {

    public String getPageTitle() {
        return getDriver().getTitle();
    }
}
