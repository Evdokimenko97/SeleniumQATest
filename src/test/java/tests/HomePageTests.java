package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.*;

public class HomePageTests extends BaseTest {
    HomePage homePage = new HomePage();

//    @Test (description = "Verify page title")
//    public void testPageTitle() {
//        String pageTitle = homePage.getTitleHomePage();
//        assertEquals(pageTitle, "automateNow | Automation Made Easy");
//    }
//
//    @Test (description = "Verify page title")
//    public void testTitleSandboxPage() {
//        String pageTitle = homePage.getTitleHomePage();
//        assertTrue(pageTitle.contains("automateNow"));
//    }
}
