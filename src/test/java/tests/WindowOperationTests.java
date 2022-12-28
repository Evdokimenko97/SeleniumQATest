package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WindowOperationTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToTablesPage() {
        winOper.clickWindowOperationPage();
        assertEquals(winOper.getTitlePage(), "Window Operations | automateNow", "The title in Tables didn't match!");
    }

    @Test(description = "Working with multiple open windows")
    public void testMultipleOpenWindows() {
        winOper.clickNewWindowButton();
        winOper.switchToNewWindow();
        assertTrue(winOper.getPageTitle().contains("Google"),  "The new window's title does not match!");
    }
    @Test(description = "Working with multiple close windows")
    public void testMultipleCloseWindows() {
        winOper.switchToNewWindow();
        winOper.clickNewWindowButton();
        winOper.switchToNewWindow();
        assertTrue(winOper.getPageTitle().contains("Google"),  "The new window's title does not match!");

        closeWindow();
        int numberOfOpenWindows = getNumberOfOpenWindows();
        assertEquals(numberOfOpenWindows, 1, "Found more than one open window");
    }

    @Test(description = "Working with multiple tabs")
    public void testMultipleTabs() {
        openNewTab();
        winOper.switchToNewWindow();
        goToUrl("https://www.nasa.gov");
        String pageTitle = getPageTitle();
        assertEquals(pageTitle, "NASA", "The page title for the new window did not match!");
        closeWindow();
        int numberOfOpenWindows = getNumberOfOpenWindows();
        assertEquals(numberOfOpenWindows, 1, "Found more than one open window");
    }
}