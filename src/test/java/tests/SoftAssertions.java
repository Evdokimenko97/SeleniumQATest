package tests;

import org.testng.annotations.Test;
import utils.CustomSoftAssert;

public class SoftAssertions extends BaseTest {
    public static CustomSoftAssert softAssert = new CustomSoftAssert();

    @Test
    public void testSoftAssert() {
        String pageTitle = homepage.getPageTitle();
        softAssert.assertEquals(pageTitle, "automateNows | Automation Made Easy", "The title home page is invalid");

        String firstVideo = homepage.nameFirstVideo();
        softAssert.assertTrue(firstVideo.contains("Cypresss"));

        softAssert.assertAll();
    }
}
