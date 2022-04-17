package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public abstract class SandboxTests extends BaseTest {

    @BeforeClass
    public void testNavigateToSandboxPage() {
        navBar.selectSandBox();
    }

    @BeforeGroups("Sandbox")
    @Test(description = "Verify page title")
    public void testTitleSandboxPage() {
        String pageTitle = sandbox.getTitleSandBoxPage();
        assertEquals(pageTitle, "Automation Testing Practice Website | automateNow |", "The title didn't match!");
    }
}