package bootstrap;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Map;
import pages.RegistrationPage;
import util.DriverFactory;
import util.JsonManager;

public class RegistrationPageTests {

    private static WebDriver driver;
    private JsonManager jsonManager  = new JsonManager("src/test/resources/registrationPage_data.json");

    public RegistrationPageTests() throws IOException {
    }


    @BeforeAll
    public static void setupClass() throws IOException {
        driver = DriverFactory.createDriver();
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            // Refresh the page after each test
            driver.navigate().refresh();
        }
    }

    @AfterAll
    public static void tearDownClass() {
        driver.quit();
    }

    @Test
     void testSuccessSubmission() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.navigateToRegistrationPage();

        // Retrieve test data from JSON
        Map<String, String> data = jsonManager.getValue("success_submission");
        int initialRows = registrationPage.getNumberOfRowsInTable();
        registrationPage.fillForm(data);
        registrationPage.submitForm();

        Assertions.assertTrue(registrationPage.checkSuccessMessageAppear(), "Success message did not appear after form submission");

        int updatedRows = registrationPage.getNumberOfRowsInTable();
        Assertions.assertEquals(initialRows + 1, updatedRows, "Expected " + (initialRows + 1) + " rows, but found " + updatedRows + " rows.");
    }

    @Test
     void testEmptyFormSubmission() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.navigateToRegistrationPage();
        // Submit an empty form
        registrationPage.submitForm();
        // Check if the error message appears
        Assertions.assertTrue(registrationPage.checkErrorMessageAppear(), "No validation error message found after submitting empty form");
    }



}

