package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TablesPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TablesTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToTablesPage() {
        table.clickTables();
        assertEquals(table.getTitlePage(), "Tables | automateNow", "The title in Tables didn't match!");
    }

    @Test
    public void testTable() {
        String laptopPrice = table.getItemPrice("Laptop");
        assertEquals(laptopPrice,"$1200.00", "The price on the laptop is not correct!");

        String orangePrice = table.getItemPrice("Oranges");
        assertEquals(orangePrice, "$3.99", "The price on the orange is not correct!");
    }

    @Test(description = "Tests table pagination")
    public void testTablePagination() {
        TablesPage tablesPage = new TablesPage();
        tablesPage.sortByCountry();
        String populationUK = tablesPage.getPopulation("United Kingdom");
        assertNotEquals(populationUK, "-1", "The country was not found on the list!");
        System.out.println("The population in the United Kingdom is " + populationUK + " million.");
    }
}
