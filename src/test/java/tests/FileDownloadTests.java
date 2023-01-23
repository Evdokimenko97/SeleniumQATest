package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileDownloadTests extends SandboxTests {

    @BeforeClass
    public void textFileDownloadPage() {
        fileDownload.clickFileDownloadPage();
        assertEquals(fileDownload.getFileDownloadPage(), "File Download | automateNow", "The title in File Download didn't match!");
    }

    @Test(description = "Test a file download")
    public void testFileDownload() {
        fileDownload.downloadPage();
    }
}