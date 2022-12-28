package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchBoxesTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToSearchBoxesPage() {
        searchBoxes.clickSearchPage();
    }

//    @BeforeGroups("Tables")
//    public void testTitleTables() {
//        String pageTitle = table.getTitlePage();
//        assertEquals(pageTitle, "Tables | automateNow", "The title in Tables didn't match!");
//    }

//    @Test(priority = 1)
//    public void testInputSearchField() {
//        String text = "aaa";
//        searchBoxes.setInputSearchText(text);
//        assertEquals(searchBoxes.getInputSearchText(),"aaa", "The text is incorrect in search field!");
//    }
//
//    @Test(priority = 2)
//    public void testClickSearchField() {
//        searchBoxes.clickSearchButton();
//    }

    @Test(priority = 3)
    public void testSearch() {
        boolean search;
        search = searchBoxes.search("aaa");
        assertFalse(search, "Did not expect to find a search result!");

        search = searchBoxes.search("jmeter");
        assertTrue(search, "Expected to find a search result!");
    }
}
