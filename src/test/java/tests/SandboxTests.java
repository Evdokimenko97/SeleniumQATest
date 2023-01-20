package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public abstract class SandboxTests extends BaseTest {

    @BeforeClass
    public void testNavigateToSandboxPage() {
        navBar.selectSandBox();
        assertEquals(sandbox.getPageTitle(), "Automation Testing Practice Website | automateNow |", "The title didn't match!");
    }
}