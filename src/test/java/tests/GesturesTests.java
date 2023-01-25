package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GesturesTests extends SandboxTests {

    @BeforeClass
    public void navigateToGesturesPage() {
        gestures.clickGesturesPage();
        assertEquals(winOper.getTitlePage(), "Gestures | automateNow", "The title in Gestures didn't match!");
    }

    @Test
    public void testClickAndDrag() {
        int x_coordinate = -300;
        int y_coordinate = -300;

        gestures.dragMap(x_coordinate, y_coordinate);
    }
}