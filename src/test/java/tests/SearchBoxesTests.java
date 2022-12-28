package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchBoxesTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToSearchBoxesPage() {
        searchBoxes.clickSearchPage();
    }

    @Test(priority = 1)
    public void testTitle() {
        String title = searchBoxes.getTitlePage();
        assertEquals(title, "Search Boxes | automateNow", "The title is not correct!");
    }

    @Test(priority = 2)
    public void testSearch() {
        boolean search;
        search = searchBoxes.search("aaa");
        assertFalse(search, "Did not expect to find a search result!");

        search = searchBoxes.search("jmeter");
        assertTrue(search, "Expected to find a search result!");
    }
}