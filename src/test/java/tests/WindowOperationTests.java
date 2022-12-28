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
        assertTrue(winOper.getPageTitle().contains("Google"), "The new window's title does not match!");
    }
}