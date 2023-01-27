package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

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
        assertTrue(formFields.radioButtonIsSelected(radioBtn1 + "1"), "White radio button is not selected!");

        formFields.selectRadioButton(radioBtn2);
        assertTrue(formFields.radioButtonIsSelected(radioBtn2), "Blue radio button is not selected!");
        assertFalse(formFields.radioButtonIsSelected(radioBtn1), "White radio button is selected!");
    }
}