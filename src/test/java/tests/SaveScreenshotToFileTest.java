package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)
public class SaveScreenshotToFileTest extends BaseTest {

    @Test
    public void testSaveScreenshotToWordDoc() {
        String pageTitle = homepage.getPageTitle();
        assertEquals("The title home page is invalid", "automateNows | Automation Made Easy", pageTitle);
    }
}
