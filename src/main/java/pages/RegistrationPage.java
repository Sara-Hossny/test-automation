package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import pages_cfg.RegistrationPageCfg;
import util.ElementAction;

public class RegistrationPage {

    private WebDriver driver;
    private ElementAction elementAction;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;

        this.elementAction = new ElementAction(this.driver,RegistrationPageCfg.EXPLICT_TIME);
    }

    public void navigateToRegistrationPage() {
        driver.get(RegistrationPageCfg.REGISTRATION_URL);
    }

    public void fillFirstName(String firstName) {

        By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("first_name");
        elementAction.clear(locator);
        elementAction.sendKeys(locator, firstName);

    }

    public void fillLastName(String lastName) {
        By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("last_name");
        elementAction.clear(locator);
        elementAction.sendKeys(locator, lastName);
    }

    public void selectGender(String gender) {
        if (gender != null) {
            By maleLocator = RegistrationPageCfg.REGISTRATION_SCHEME.get("inline_radio_male");
            By femaleLocator = RegistrationPageCfg.REGISTRATION_SCHEME.get("inline_radio_female");
            if (gender.equalsIgnoreCase("male")) {
                elementAction.click(maleLocator);
            } else if (gender.equalsIgnoreCase("female")) {
                elementAction.click(femaleLocator);
            }
        }
    }

    public void selectHobby( String hobbyIndex) {
            By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("hobbies");
            elementAction.selectFromDropdown(locator, hobbyIndex);
        
    }

    public void selectDepartment(String department) {
        By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("department");
        elementAction.selectFromDropdown(locator, department);

    }

    public void fillUserName(String userName) {
        By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("user_name");
        elementAction.clear(locator);
        elementAction.sendKeys(locator, userName);
    }

    public void fillUserPassword(String userPassword) {
        By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("user_password");
        elementAction.clear(locator);
        elementAction.sendKeys(locator, userPassword);
    }

    public void fillConfirmPassword(String confirmPassword) {
            By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("confirm_password");
            elementAction.clear(locator);
            elementAction.sendKeys(locator, confirmPassword);
    }

    public void fillEmail(String email) {
            By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("email");
            elementAction.clear(locator);
            elementAction.sendKeys(locator, email);

    }

    public void fillContactNo(String contactNo) {
            By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("contact_no");
            elementAction.clear(locator);
            elementAction.sendKeys(locator, contactNo);

    }

    public void fillAdditionalInfo(String additionalInfo) {
            By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("additional_info");
            elementAction.clear(locator);
            elementAction.sendKeys(locator, additionalInfo);

    }

    public void fillForm(Map<String, String> data) {
        System.out.println(data);
        if (data.containsKey("first_name")) {
            fillFirstName(data.get("first_name"));
        }
        if (data.containsKey("last_name")) {

            fillLastName(data.get("last_name"));
        }
        if(data.containsKey("gender")){
            selectGender(data.get("gender"));
        }
        if (data.containsKey("hobby_index")) {
            selectHobby(data.get("hobby_index"));
        }
        if (data.containsKey("department_index")) {
            selectDepartment(data.get("department_index"));
        }
        if (data.containsKey("user_name")) {
            fillUserName(data.get("user_name"));
        }
        if (data.containsKey("user_password")) {
            fillUserPassword(data.get("user_password"));
        }
        if (data.containsKey("confirm_password")) {
            fillConfirmPassword(data.get("confirm_password"));
        }
        if (data.containsKey("email")) {
            fillEmail(data.get("email"));
        }
        if (data.containsKey("contact_no")) {
            fillContactNo(data.get("contact_no"));
        }
        if (data.containsKey("additional_info")) {
            fillAdditionalInfo(data.get("additional_info"));
        }


    }


    public void submitForm() {
        By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("submit_button");
        elementAction.click(locator);
    }


    public int getNumberOfRowsInTable() {
        By tableLocator = RegistrationPageCfg.REGISTRATION_SCHEME.get("data_table");
        System.out.println(tableLocator);

        WebElement dataTable = elementAction.findElement(tableLocator);
        return dataTable.findElements(By.tagName("tr")).size();
    }


    public boolean checkValidation(String key) {
        By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get(key);
        return elementAction.isElementDisplayed(locator);
    }

    public boolean checkSuccessMessageAppear() {
        return checkValidation("success_message");
    }

    public boolean checkErrorMessageAppear() {
        return checkValidation("error_message");
    }


    /**
     * Check if the 'stringLength' validation message for 'first_name' is displayed.
     * @return true if the validation message is displayed, false otherwise.
     */
    public boolean checkFirstNameStringLengthValidation() {
        By locator=RegistrationPageCfg.REGISTRATION_SCHEME.get("validate_first_name_stringLength");
        return elementAction.isElementDisplayed(locator);
    }

    /**
     * Check if the 'notEmpty' validation message for 'first_name' is displayed.
     * @return true if the validation message is displayed, false otherwise.
     */
    public boolean checkFirstNameNotEmptyValidation() {
        By locator=RegistrationPageCfg.REGISTRATION_SCHEME.get("validate_first_name_not_empty");
        return elementAction.isElementDisplayed(locator);
    }

    /**
     * Check if the 'stringLength' validation message for 'last_name' is displayed.
     * @return true if the validation message is displayed, false otherwise.
     */
    public boolean checkLastNameStringLengthValidation() {
        By locator=RegistrationPageCfg.REGISTRATION_SCHEME.get("validate_last_name_stringLength");
        return elementAction.isElementDisplayed(locator);
    }

    /**
     * Check if the 'notEmpty' validation message for 'last_name' is displayed.
     * @return true if the validation message is displayed, false otherwise.
     */
    public boolean checkLastNameNotEmptyValidation() {
        By locator=RegistrationPageCfg.REGISTRATION_SCHEME.get("validate_last_name_not_empty");
        return elementAction.isElementDisplayed(locator);
    }

    /**
     * Check if the 'notEmpty' validation message for 'gender' is displayed.
     * @return true if the validation message is displayed, false otherwise.
     */
    public boolean checkGenderNotEmptyValidation() {
        By locator=RegistrationPageCfg.REGISTRATION_SCHEME.get("validate_gender_not_empty");
        return elementAction.isElementDisplayed(locator);
    }

    /**
     * Check if the 'notEmpty' validation message for 'department' is displayed.
     * @return true if the validation message is displayed, false otherwise.
     */
    public boolean checkDepartmentNotEmptyValidation() {
        By locator=RegistrationPageCfg.REGISTRATION_SCHEME.get("validate_department_not_empty");
        return elementAction.isElementDisplayed(locator);
    }

    /**
     * Check if the 'notEmpty' validation message for the user name field is displayed.
     * @return true if the validation message is displayed, false otherwise.
     */
    public boolean checkUserNameNotEmptyValidation() {
        By locator=RegistrationPageCfg.REGISTRATION_SCHEME.get("validate_user_name_not_empty");
        return elementAction.isElementDisplayed(locator);
    }

    /**
     * Check if the 'stringLength' validation message for the user name field is displayed.
     * @return true if the validation message is displayed, false otherwise.
     */
    public boolean checkUserNameStringLengthValidation() {
        By locator=RegistrationPageCfg.REGISTRATION_SCHEME.get("validate_user_name_stringLength");
        return elementAction.isElementDisplayed(locator);
    }

    public boolean isPasswordValid() {
        return checkValidation("validate_password");
    }

    public boolean isConfirmPasswordValid() {
        return checkValidation("validate_confirm_password");
    }

    public boolean checkMatchPassword() {
        return checkValidation("validate_match_password");
    }

    public boolean isEmailErrorVisible() {
        return checkValidation("email_error");
    }

    public boolean isEmailEmptyErrorVisible() {
        return checkValidation("email_empty_error");
    }

    public boolean isEmailValid() {
        return checkValidation("email_success_icon");
    }

    public boolean isContactNumberEmptyErrorVisible() {
        return checkValidation("contact_no_empty_error");
    }

    public boolean isContactNumberErrorVisible() {
        return checkValidation("contact_no_error");
    }

    public boolean isContactNumberValid() {
        return checkValidation("contact_no_valid");
    }

    public void scrollToTopOfAdditionalInfo() {
        By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("additional_info");
        elementAction.scrollToTop(locator);
    }

    public boolean isAdditionalInfoScrolledToTop() {
        By locator = RegistrationPageCfg.REGISTRATION_SCHEME.get("additional_info");
        return elementAction.getElementAttribute(locator, "scrollTop").equals("0");
    }

}

