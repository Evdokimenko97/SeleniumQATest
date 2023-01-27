package utils;

import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import pages.BasePage;

public class CustomSoftAssert extends SoftAssert {

    @Override
    public void onAssertFailure(IAssert<?> var1, AssertionError var2) {
        new BasePage().takeScreenshot();
    }
}
