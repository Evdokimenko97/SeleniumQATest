package tests;

import org.testng.annotations.Test;

public class BrowserStackTest extends BaseTest {

    @Test(description = "Tests selection a submenu")
    public void testSelectSubmenu() {
        driver.get("https://www.browserstack.com/guide/mouse-hover-in-selenium");
        browserStack.selectIntroToSeleniumWebDriver();
    }

    @Test(description = "Takes a page screenshot")
    public void testPageScreenshot() {
        driver.get("https://www.browserstack.com/guide/mouse-hover-in-selenium");
        browserStack.selectIntroToSeleniumWebDriver();

        takeScreenshot();
    }
}
