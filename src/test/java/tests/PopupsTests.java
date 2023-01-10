package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PopupsTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToPopupsPage() {
        popups.clickPopupsPage();
        assertEquals(popups.getPopupsPage(), "Popups | automateNow", "The title in Popups didn't match!");
    }

    @Test(description = "Test popup windows")
    public void testPopups() {
        popups.clickAlertPopup();
        popups.dismissPopup();

        popups.clickConfirmPopup();
        popups.acceptPopup();
        assertEquals(popups.getConfirmPopupSelection(), "OK it is!", "The popup selection result does not match!");
    }

    @Test(description = "Tests a JS prompt box")
    public void testPromptPopup() {
        popups.clickPromptPopup();
        String text = "Andrew";
        popups.setAlertText(text);
        popups.acceptPopup();
        popups.waitForPromptPopupResult(String.format("Nice to meet you, %s!", text));

        popups.clickPromptPopup();
        popups.setAlertText(text);
        popups.dismissPopup();
        popups.waitForPromptPopupResult("Fine, be that way...");
    }
}