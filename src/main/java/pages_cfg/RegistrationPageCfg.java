package pages_cfg;
import org.openqa.selenium.By;
import java.util.Map;
import java.util.HashMap;

public class RegistrationPageCfg {
    public static final String REGISTRATION_URL = "https://mytestingthoughts.com/Sample/home.html";
    public static final int  EXPLICT_TIME=3 ;
    public static final Map<String, By> REGISTRATION_SCHEME = new HashMap<>();

    static {
        REGISTRATION_SCHEME.put("first_name", By.name("first_name"));
        REGISTRATION_SCHEME.put("last_name", By.name("last_name"));
        REGISTRATION_SCHEME.put("inline_radio_male", By.id("inlineRadioMale"));
        REGISTRATION_SCHEME.put("inline_radio_female", By.id("inlineRadioFemale"));
        REGISTRATION_SCHEME.put("hobbies", By.id("exampleFormControlSelect2"));
        REGISTRATION_SCHEME.put("department", By.name("department"));
        REGISTRATION_SCHEME.put("user_name", By.name("user_name"));
        REGISTRATION_SCHEME.put("user_password", By.name("user_password"));
        REGISTRATION_SCHEME.put("confirm_password", By.name("confirm_password"));
        REGISTRATION_SCHEME.put("email", By.name("email"));
        REGISTRATION_SCHEME.put("contact_no", By.name("contact_no"));
        REGISTRATION_SCHEME.put("additional_info", By.id("exampleFormControlTextarea1"));
        REGISTRATION_SCHEME.put("submit_button", By.cssSelector("button[type='submit'].btn.btn-warning"));
        REGISTRATION_SCHEME.put("success_message", By.id("success_message"));
        REGISTRATION_SCHEME.put("error_message", By.className("error-message"));
        REGISTRATION_SCHEME.put("validate_first_name_stringLength", By.cssSelector(
                "small[data-bv-validator='stringLength'][data-bv-validator-for='first_name']"));
        REGISTRATION_SCHEME.put("validate_first_name_not_empty", By.cssSelector(
                "small[data-bv-validator='notEmpty'][data-bv-validator-for='first_name']"));
        REGISTRATION_SCHEME.put("validate_last_name_stringLength", By.cssSelector(
                "small[data-bv-validator='stringLength'][data-bv-validator-for='last_name']"));
        REGISTRATION_SCHEME.put("validate_last_name_not_empty", By.cssSelector(
                "small[data-bv-validator='notEmpty'][data-bv-validator-for='last_name']"));
        REGISTRATION_SCHEME.put("validate_user_name_stringLength", By.cssSelector(
                "small[data-bv-validator='stringLength'][data-bv-validator-for='user_name']"));
        REGISTRATION_SCHEME.put("validate_user_name_not_empty", By.cssSelector(
                "small[data-bv-validator='notEmpty'][data-bv-validator-for='user_name']"));

        REGISTRATION_SCHEME.put("validate_gender_not_empty", By.cssSelector(
                "small[data-bv-validator='notEmpty'][data-bv-validator-for='gender']"));
        REGISTRATION_SCHEME.put("validate_department_not_empty", By.cssSelector(
                "small[data-bv-validator='notEmpty'][data-bv-validator-for='department']"));
        REGISTRATION_SCHEME.put("validate_password", By.cssSelector(
                "i.form-control-feedback.glyphicon.glyphicon-ok[data-bv-icon-for='user_password']"));
        REGISTRATION_SCHEME.put("validate_confirm_password", By.cssSelector(
                "i.form-control-feedback.glyphicon.glyphicon-ok[data-bv-icon-for='confirm_password']"));
        REGISTRATION_SCHEME.put("validate_match_password", By.cssSelector(
                "small[data-bv-validator-for='match_password']"));
        REGISTRATION_SCHEME.put("validate_email_address", By.cssSelector(
                "small[data-bv-validator='emailAddress']"));
        REGISTRATION_SCHEME.put("email_success_icon", By.cssSelector(
                "i.form-control-feedback.glyphicon.glyphicon-ok[data-bv-icon-for='email']"));
        REGISTRATION_SCHEME.put("email_empty_error", By.cssSelector(
                "small[data-bv-validator='notEmpty'][data-bv-validator-for='email']"));
        REGISTRATION_SCHEME.put("contact_no_empty_error", By.cssSelector(
                "small[data-bv-validator='notEmpty'][data-bv-validator-for='contact_no']"));
        REGISTRATION_SCHEME.put("contact_no_error", By.cssSelector(
                ".form-control-feedback.glyphicon.glyphicon-remove[data-bv-icon-for='contact_no']"));
        REGISTRATION_SCHEME.put("contact_no_valid", By.cssSelector(
                "i.form-control-feedback.glyphicon.glyphicon-ok[data-bv-icon-for='contact_no']"));
        REGISTRATION_SCHEME.put("data_table", By.id("mytable"));
    }

}

