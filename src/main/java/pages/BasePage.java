package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class BasePage {
    protected static WebDriver driver;

    public String browser;
    public String baseUrl;
    public Properties properties;
    public JavascriptExecutor js;

    public void loadProperties() {
        FileInputStream fis = null;

        try {
            properties = new Properties();
            fis = new FileInputStream("C:\\IdeaProjects\\SeleniumQATest\\src\\main\\java\\config\\config.properties");
            properties.load(fis);

            browser = properties.getProperty("browser");
            baseUrl = properties.getProperty("baseUrl");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void openBrowser() {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
//            WebDriverManager.chromedriver().driverVersion("88.0.0.1").setup();

//            WebDriverManager.firefoxdriver().setup();

//            // Run in headless mode
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless", "--window-size=1920,1080");
//            driver = new ChromeDriver(options);

//            // Change download default directory
//            ChromeOptions options = new ChromeOptions();
//            Map<String, Object> prefs = new HashMap<>();
//            prefs.put("download.default_directory", "C:\\Work\\Temp");
//            options.setExperimentalOption("prefs", prefs);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");

            // Disable message 'Chrome is being controlled by automated test software'
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("disable-infobars");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    private BasePage closeCookie() {
        driver.findElement(By.cssSelector("a#cookie_action_close_header")).click();
        return this;
    }

    public void scrollingPage(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void closeWindow() {
        driver.close();
    }

    public Boolean goToHomePage() {
        try {
            loadProperties();
            openBrowser();
            driver.get(baseUrl);
            closeCookie();
        } catch (Exception ex) {
            System.out.println("Unable to navigate to the homepage");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public void setText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        tab(locator);
    }

    public void tab(By locator) {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public String getText(By locator) {
        String displayedText = driver.findElement(locator).getText();
        if (displayedText.isEmpty()) {
            return driver.findElement(locator).getAttribute("value");
        } else {
            return displayedText;
        }
    }

    public void clickWithScroll(By locator) {
        WebElement webElement = driver.findElement(locator);
        scrollingPage(webElement);
        webElement.click();
    }

    public void click(By locator) {
        WebElement webElement = driver.findElement(locator);
        webElement.click();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public int getNumberOfOpenWindows() {
        return driver.getWindowHandles().size();
    }

    public void switchToNewWindow() {
        // Get current window handle
        String currentWindow = getWindowHandle();

        // Get all window handles
        Set<String> handles = getWindowHandles();

        // Switch to a new window
        Iterator<String> iter = handles.iterator();
        String newWindow = null;
        while (iter.hasNext()) {
            newWindow = iter.next();
            if (!currentWindow.equals(newWindow)) {
                driver.switchTo().window(newWindow);
            }
        }
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void dragAndDropByOffset(By locator, int x, int y) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        scrollingPage(element);
        actions.dragAndDropBy(element, x, y).perform();
    }

    public void dismissPopup() {
        driver.switchTo().alert().dismiss();
    }

    public void acceptPopup() {
        driver.switchTo().alert().accept();
    }

    public void setAlertText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void waitForElementText(By locator, String text) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.textToBe(locator, text));

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void takeElementScreenshot(By locator) {
        WebElement element = driver.findElement(locator);
        File file = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchFrames(WebElement frame) {
        driver.switchTo().frame(frame);
        System.out.println(driver.getTitle());
    }

    public void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }
}
