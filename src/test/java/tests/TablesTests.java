package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pages.SandboxPage;

import static org.testng.Assert.assertEquals;

public class TablesTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToTablesPage() {
        table.clickTables();
    }

//    @BeforeGroups("Tables")
//    public void testTitleTables() {
//        String pageTitle = table.getTitlePage();
//        assertEquals(pageTitle, "Tables | automateNow", "The title in Tables didn't match!");
//    }

    @Test(groups = "Tables", description = "Check price by item")
    public void testTable() {
        String laptopPrice = table.getItemPrice("Laptop");
        assertEquals(laptopPrice,"$1200.00", "The price on the laptop is not correct!");

        String orangePrice = table.getItemPrice("Oranges");
        assertEquals(orangePrice, "$3.99", "The price on the orange is not correct!");
    }
}
