package tests;

import junit.framework.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.*;

public class BaseTest extends BasePage {
    protected NavigationBar navBar;
    protected HomePage homepage;
    protected SandboxPage sandbox;
    protected FormFieldsPage formFields;
    protected TablesPage table;
    protected CalendarPage calendar;
    protected SearchBoxesPage searchBoxes;
    protected WindowOperationPage winOper;
    protected GesturesPage gestures;
    protected PopupsPage popups;

    @BeforeSuite
    public void setUp() {
        Assert.assertTrue("An error occurred while navigating to the homepage!", goToHomePage());

        navBar = new NavigationBar();
        homepage = new HomePage();
        sandbox = new SandboxPage();
        formFields = new FormFieldsPage();
        table = new TablesPage();
        calendar = new CalendarPage();
        searchBoxes = new SearchBoxesPage();
        winOper = new WindowOperationPage();
        gestures = new GesturesPage();
        popups = new PopupsPage();
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
