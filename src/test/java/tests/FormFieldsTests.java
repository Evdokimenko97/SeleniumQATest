package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FormFieldsTests extends SandboxTests {

    @BeforeClass
    public void textNavigateToFormFields() {
        formFields.clickFormFields();
    }

    @BeforeGroups("FormFields")
    public void testTitleFormFieldsPage() {
        String pageTitle = formFields.getTitlePage();
        assertEquals(pageTitle, "Form Fields | automateNow", "The title in Form Fields didn't match!");
    }

    @Test(groups = "FormFields", description = "Enters text in an input field")
    public void testEnterText() {
        String myText = "Hello!";
        formFields.setInputFieldText(myText);
        String displayedText = formFields.getInputFieldText();
        assertEquals(displayedText, myText, "Unable to verify entered text");
    }

    @Test(groups = "FormFields", description = "Check a checkbox")
    public void testCheckbox() {
        formFields.selectCheckbox("1");
        assertTrue(formFields.checkboxIsSelected("1"), "Checkbox isn't selected!");
        assertFalse(formFields.checkboxIsSelected("2"), "Checkbox is selected!");
    }

    @Test(groups = "FormFields", description = "Selects from a drop-down")
    public void testSelectDropdown() {
        String myOption = "Binary";
        formFields.selectDropdown(myOption);
        assertEquals(formFields.getDropDownText(), myOption, "Dropdown option is not selected!");
    }

    @Test(groups = "FormFields", description = "Selects a radio button")
    public void testSelectRadioButton() {
        String radioBtn1 = "White";
        String radioBtn2 = "Blue";

        formFields.selectRadioButton(radioBtn1);
        assertTrue(formFields.radioButtonIsSelected(radioBtn1), "White radio button is not selected!");

        formFields.selectRadioButton(radioBtn2);
        assertTrue(formFields.radioButtonIsSelected(radioBtn2), "Blue radio button is not selected!");
        assertFalse(formFields.radioButtonIsSelected(radioBtn1), "White radio button is selected!");
    }
}