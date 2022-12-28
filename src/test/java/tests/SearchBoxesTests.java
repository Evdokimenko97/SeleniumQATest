package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchBoxesTests extends SandboxTests {

    @BeforeClass
    public void clickNavigateToSearchBoxesPage() {
        searchBoxes.clickSearchPage();
        assertEquals(searchBoxes.getTitlePage(), "Search Boxes | automateNow", "The title is not correct!");
    }

    @Test
    public void testSearch() {
        boolean search;
        search = searchBoxes.search("aaa");
        assertFalse(search, "Did not expect to find a search result!");

        search = searchBoxes.search("jmeter");
        assertTrue(search, "Expected to find a search result!");
    }
}