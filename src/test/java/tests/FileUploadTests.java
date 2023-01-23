package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends SandboxTests {

    @BeforeClass
    public void textFileUploadPage() {
        fileUpload.clickFileUploadPage();
        assertEquals(fileUpload.getFileUploadPage(), "File Upload | automateNow", "The title in File Upload didn't match!");
    }

    @Test(description = "Test a file upload")
    public void testFileUpload() {
        fileUpload.uploadFile("C:/IdeaProjects/SeleniumQATest/src/main/resources/textFile.txt");
    }
}