package pages;

import org.openqa.selenium.By;

public class GesturesPage extends SandboxPage {
    private By buttonGestures = By.xpath("//a[contains(text(),'Gestures')]");
    private By mapbox = By.xpath("//canvas[@class='mapboxgl-canvas']");

    public GesturesPage clickGesturesPage() {
        click(buttonGestures);
        return new GesturesPage();
    }

    public void dragMap(int x, int y) {
        dragAndDropByOffset(mapbox, x, y);
    }
}
