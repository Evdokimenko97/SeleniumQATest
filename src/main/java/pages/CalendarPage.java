package pages;

import org.openqa.selenium.By;

public class CalendarPage extends SandboxPage {
    private By buttonCalendars = By.xpath("//a[text()='Calendars']");
    private By calendarMonth = By.xpath("//span[@class='ui-datepicker-month']");
    private By calendarYear = By.xpath("//span[@class='ui-datepicker-year']");
    private By calendarField = By.xpath("//input[@id[contains(.,'selectorenteradate')]]");
    private By calendarArrowRight = By.xpath("//a[@title='Next']");
    private By calendarArrowLeft = By.xpath("//a[@title='Previous']");

    public CalendarPage clickCalendarPage() {
        clickWithScroll(buttonCalendars);
        return new CalendarPage();
    }

    public String getCalendarPage() {
        return getDriver().getTitle();
    }

    public CalendarPage selectDate(String month, String day, String year) {
        getDriver().findElement(calendarField).click();

        while (true) {
            String currentMonth = getText(calendarMonth);
            String currentYear = getText(calendarYear);
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            if (!currentMonth.equals("January") || Integer.parseInt(year) <= Integer.parseInt(currentYear)) {
                getDriver().findElement(calendarArrowLeft).click();
            } else {
                getDriver().findElement(calendarArrowRight).click();
            }
        }

        getDriver().findElement(By.xpath("//table//td/a[text()='" + day + "']")).click();
        return this;
    }

    public String getDate() {
        return getText(calendarField);
    }
}
