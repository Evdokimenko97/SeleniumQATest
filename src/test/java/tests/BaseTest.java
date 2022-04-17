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

    @BeforeSuite
    public void setUp() {
        Assert.assertTrue("An error occurred while navigating to the homepage!", goToHomePage());

        navBar = new NavigationBar();
        homepage = new HomePage();
        sandbox = new SandboxPage();
        formFields = new FormFieldsPage();
        table = new TablesPage();
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
