package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.TablesPage;

import static org.testng.Assert.assertEquals;

public class CalendarTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToTablesPage() {
        calendar.clickCalendarPage();
        assertEquals(calendar.getCalendarPage(), "Calendars | automateNow", "The title in Calendars didn't match!");
    }

    @Test(groups = "Calendar", description = "Check price by item")
    public void testCalendars() throws InterruptedException {
        calendar.selectDate("December", "30", "2021");
        String date = calendar.getDate();

        assertEquals(date, "December 30, 2021", "The day is not properly set ");
    }
}