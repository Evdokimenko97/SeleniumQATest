package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HoverTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToHoverPage() {
        hover.clickHoverPage();
        assertEquals(hover.getHoverPage(), "Hover | automateNow", "The title in Modals didn't match!");
    }

    @Test(description = "Test mouse over")
    public void testHovering() {
        hover.doHover();
        String hoverText = hover.getHoverText();
        assertEquals(hoverText, "You did it!");
    }
}