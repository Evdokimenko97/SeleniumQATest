package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ModalsTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToModalsPage() {
        modals.clickModalsPage();
        assertEquals(modals.getModalsPage(), "Modals | automateNow", "The title in Modals didn't match!");
    }

    @Test(description = "Test form modal windows")
    public void testModals() {
        String name = "Andrew";
        String email = "info@automatenow.io";
        String message = "test message";

        modals.clickFormModal();
        modals.modalSendMessage(name, email, message);
    }
}