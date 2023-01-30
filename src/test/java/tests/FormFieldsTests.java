package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.DataUtil;
import utils.TestListener;

import java.util.HashMap;

import static org.testng.Assert.*;

@Listeners(TestListener.class)
public class FormFieldsTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToFormFields() {
        formFields.clickFormFields();
        assertEquals(formFields.getTitlePage(), "Form Fields | automateNow", "The title in Form Fields didn't match!");
    }

    @Test(description = "Enters text in an input field")
    public void testEnterText() {
        String myText = "Hello!";
        formFields.setInputFieldText(myText);
        String displayedText = formFields.getInputFieldText();
        assertEquals(displayedText, myText, "Unable to verify entered text");
    }

    @Test(description = "Check a checkbox")
    public void testCheckbox() {
        formFields.selectCheckbox("Water");
        assertTrue(formFields.checkboxIsSelected("Water"), "Checkbox isn't selected!");
        assertFalse(formFields.checkboxIsSelected("Milk"), "Checkbox is selected!");
    }

    @Test(description = "Selects from a drop-down")
    public void testSelectDropdown() {
        String myOption = "Yes";
        formFields.selectDropdown(myOption);
        assertEquals(formFields.getDropDownText(), myOption, "Dropdown option is not selected!");
    }

    @Test(description = "Selects a radio button")
    public void testSelectRadioButton() {
        String radioBtn1 = "Red";
        String radioBtn2 = "Blue";

        formFields.selectRadioButton(radioBtn1);
        assertTrue(formFields.radioButtonIsSelected(radioBtn1), "White radio button is not selected!");

        formFields.selectRadioButton(radioBtn2);
        assertTrue(formFields.radioButtonIsSelected(radioBtn2), "Blue radio button is not selected!");
        assertFalse(formFields.radioButtonIsSelected(radioBtn1), "White radio button is selected!");
    }

    @Test(description = "Submit a form", dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void testSubmitForm(HashMap<String, String> hashMap) {
        formFields.setInputFieldText(hashMap.get("Input Field"))
                .selectCheckbox(hashMap.get("Checkbox"))
                .selectRadioButton(hashMap.get("Radio Button"))
                .setEmail(hashMap.get("Email"))
                .setMessage(hashMap.get("Message"))
                .clickSubmit();

        String confirmationMsg = formFields.getConfirmationMessage();
        assertTrue(confirmationMsg.contains("Your message has been sent"), "Form not submitted successfully");
    }

    @Test(description = "Submit a form", dataProviderClass = DataUtil.class, dataProvider = "dataProvider2")
    public void testSubmitForm2(String data) {
        String[] formInfo = data.split(",");
        formFields.setInputFieldText(formInfo[0])
                .selectCheckbox(formInfo[1])
                .selectRadioButton(formInfo[2])
                .setEmail(formInfo[3])
                .setMessage(formInfo[4])
                .clickSubmit();

        String confirmationMsg = formFields.getConfirmationMessage();
        assertTrue(confirmationMsg.contains("Your message has been sent"), "Form not submitted successfully");

        formFields.goBack();
        formFields.goBack();
        textNavigateToFormFields();

        formFields.setInputFieldText(formInfo[0])
                .selectCheckbox(formInfo[1])
                .selectRadioButton(formInfo[2])
                .setEmail(formInfo[3])
                .setMessage(formInfo[4])
                .clickSubmit();

        confirmationMsg = formFields.getConfirmationMessage();
        assertTrue(confirmationMsg.contains("Your message has been sent"), "Form not submitted successfully");
    }
}