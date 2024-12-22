import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Map;


import pages.RegistrationPage;
import util.JsonManager;
import util.DriverFactory;


public class RegistrationPageTests {

    private WebDriver driver;
    private JsonManager jsonManager;

    @BeforeAll
    public static void setupClass() {
        // Setup static resources if needed.
    }

    @BeforeEach
    public void setup() throws IOException {
        // Create the WebDriver using DriverFactory
        driver = DriverFactory.createDriver();
        jsonManager = new JsonManager("src/test/resources/registrationPage_data.json");
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
        // Cleanup any static resources if needed.
    }

    @Test
    public void testSuccessSubmission() {
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
    public void testEmptyFormSubmission() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.navigateToRegistrationPage();

        // Submit an empty form
        registrationPage.submitForm();

        // Check if the error message appears
        Assertions.assertTrue(registrationPage.checkErrorMessageAppear(), "No validation error message found after submitting empty form");
    }



}

