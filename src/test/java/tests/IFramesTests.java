package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IFramesPage;

import static org.testng.Assert.assertEquals;

public class IFramesTests extends SandboxTests {

//    @BeforeClass
//    public void textIFramesPage() {
//        iframe.clickIFramesPage();
//        assertEquals(iframe.getIFramesPage(), "Iframes | automateNow", "The title in Iframes didn't match!");
//    }

    @Test(description = "Works with iframes")
    public void testIFrames() {
        IFramesPage iframe = new IFramesPage();
        iframe.openIframe();
        driver.switchTo().frame(iframe.frameTutorial());
        iframe.clickJS();
        iframe.switchToDefaultFrame();
        assertEquals(iframe.getPageTitle(), "HTML Iframes", "The title in page didn't match!");
    }
}