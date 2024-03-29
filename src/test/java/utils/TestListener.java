package utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestListener extends BasePage implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        String methodName = iTestResult.getName();
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File file = screenshot.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(file, new File("./failed_tests/" + methodName + ".png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String methodName = iTestResult.getName();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            // Set output directory if not already set
            Path screenshotPath = Path.of("./failed_tests/");
            if (!Files.exists(screenshotPath)) {
                Assert.assertTrue(new File(String.valueOf(screenshotPath)).mkdirs(), "Unable to create output directory");
            }

            // Create a blank Word document
            XWPFDocument document = new XWPFDocument();

            // Add a paragraph to the document
            XWPFParagraph paragraph = document.createParagraph();

            // Add paragraph text
            XWPFRun run = paragraph.createRun();
            run.setText("Test name: " + methodName);
            run.addCarriageReturn();
            run.addCarriageReturn();

            // Create image file input stream
            File image = new File(String.valueOf(file));
            FileInputStream imageData = new FileInputStream(image);

            // Set image type and get image name
            int imageType = XWPFDocument.PICTURE_TYPE_JPEG;
            String imageFileName = image.getName();

            // Set image width/height
            int imageWidth = 500;
            int imageHeight = 250;

            // Set document name and destination
            FileOutputStream fos = new FileOutputStream(new File("./failed_tests/screenshot.docx"));

            // Add screenshot to document
            run.addPicture(imageData, imageType, imageFileName, Units.toEMU(imageWidth), Units.toEMU(imageHeight));
            document.write(fos);

            // Clean up
            fos.close();
            document.close();

        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
