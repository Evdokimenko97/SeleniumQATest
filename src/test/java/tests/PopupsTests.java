package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PopupsTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToPopupsPage() {
        popups.clickPopupsPage();
        assertEquals(calendar.getCalendarPage(), "Popups | automateNow", "The title in Popups didn't match!");
    }

    @Test(description = "Test popup windows")
    public void testPopups() {
        popups.clickAlertPopup();
        popups.dismissPopup();

        popups.clickConfirmPopup();
        popups.acceptPopup();
        assertEquals(popups.getConfirmPopupSelection(), "OK it is!", "The popup selection result does not match!");

        popups.clickPromptPopup();
        String text = "Andrew";
        popups.enterTextInPopup(text);
        popups.acceptPopup();
        assertEquals(popups.getPromptPopupSelection(), "Nice to meet you, " + text + "!", "The prompt popup selection result does not match!");

        popups.clickPromptPopup();
        popups.enterTextInPopup(text);
        popups.dismissPopup();
        assertEquals(popups.getPromptPopupSelection(), "Fine, be that way...", "The prompt popup selection result does not match!");
    }
}