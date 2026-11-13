package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.Locators;
import utils.Base;

public class LoginPage {
    private WebDriver driver; // WebDriver instance for interacting with the browser
    private WebDriverWait wait; // WebDriverWait instance for explicit waits

    // Constructor to initialize WebDriver and WebDriverWait
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Set timeout for explicit wait
    }

    // Method to validate if the URL is correct after clicking the sign-in button
    public boolean validateURL() {
        driver.findElement(Locators.signin_button).click(); // Click the sign-in button
        String currURL = driver.getCurrentUrl(); // Get the current URL
        boolean actResult;

        if (currURL.equals("http://zero.webappsecurity.com/login.html")) { // Validate the expected URL
            actResult = true;
        } else {
            actResult = false;
        }
        return actResult;
    }

    // Method to validate login functionality with given username and password
    public boolean validateLogin(String uname, String pwd) {
        driver.findElement(Locators.user_name).sendKeys(uname); // Enter username
        Base.sleep(1000); // Wait for 1 second
        driver.findElement(Locators.user_password).sendKeys(pwd); // Enter password
        Base.sleep(1000); // Wait for 1 second

        driver.findElement(Locators.submit).click(); // Click submit button
        driver.navigate().back(); // Navigate back after submission

        boolean actResult = true;

        try {
            // Explicit wait for username text to appear as verification
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Home));
        } catch (TimeoutException te) {
            actResult = false; // If timeout occurs, login validation fails
        }

        return actResult;
    }

   
    // Method to validate an invalid login attempt by checking the error alert text
    public boolean validateInvalidLogin() {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(
                Locators.invalid_alert, "Login and/or password are wrong.")); // Verify error message
        } catch (TimeoutException e) {
            return false; // If timeout occurs, invalid login validation fails
        }
    }
}