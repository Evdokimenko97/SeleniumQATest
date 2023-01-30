package tests;

import org.testng.annotations.Test;

public class BrowserStackTest extends BaseTest {

    @Test(description = "Tests selection a submenu")
    public void testSelectSubmenu() {
        getDriver().get("https://www.browserstack.com/guide/mouse-hover-in-selenium");
        browserStack.selectIntroToSeleniumWebDriver();
    }

    @Test(description = "Takes a page screenshot")
    public void testPageScreenshot() {
        getDriver().get("https://www.browserstack.com/guide/mouse-hover-in-selenium");
        browserStack.selectIntroToSeleniumWebDriver();

        takeScreenshot();
    }

    @Test(description = "Takes an element screenshot")
    public void testElementScreenshot() {
        getDriver().get("https://www.browserstack.com/guide/mouse-hover-in-selenium");
        browserStack.selectIntroToSeleniumWebDriver();

        browserStack.screenshotProductsButton();
    }
}
