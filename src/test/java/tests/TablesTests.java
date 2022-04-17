package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TablesTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToTablesPage() {
        table.clickTables();
    }

    @BeforeClass
    public void testTitleTables() {
        String pageTitle = table.getTitlePage();
        assertEquals(pageTitle, "Tables | automateNow", "The title in Tables didn't match!");
    }

    @Test
    public void testTable() {
        String laptopPrice = table.getItemPrice("Laptop");
        assertEquals("The price on the laptop is not correct!", laptopPrice, "$1200.00");
    }
}
