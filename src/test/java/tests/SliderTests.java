package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToSliderPage() {
        slider.clickSlidersPage();
        assertEquals(slider.getSliderPage(), "Slider | automateNow", "The title in Sliders didn't match!");
    }

    @Test(description = "Takes a screenshot for every soft assertion failure")
    public void testClickByOffset() {
        slider.clickSlider(250, 0);
    }
}