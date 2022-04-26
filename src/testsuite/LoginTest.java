package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.utility;

public class LoginTest extends utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    public void clickOnElement(By by) {
        clickOnElement(By.name("username"));
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        clickOnElement(By.name("username"));
        //sending field valid username
        sendTextToElement(By.name("usernaeme"), "tomsmith");

        // Find the valid password field element
        clickOnElement(By.name("password"));
        //     Sending valid Password to password field element
        sendTextToElement(By.name("password"), "SuperSecretPassword!");
        //Find the login button and click on it
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        //This is from requirement
        String expectedMessage = "Secure Area";
        //find the secure Area text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//body[1]/div[2]"));
        //validate actual and expected message

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter invalid username
        clickOnElement(By.id("username"));
        //sending field valid username
        sendTextToElement(By.id("username"), "tomsmith1");
        // Find the valid password field element
        clickOnElement(By.name("password"));
        //     Sending valid Password to password field element
        sendTextToElement(By.name("password"), "SuperSecretPassword!");
        //Find the login button and click on it
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        //This is from requirement
        String expectedMessage = " Your username is invalid!";
        // verify the error message your username is invalid
        String actualMessage = getTextFromElement(By.xpath("//body[1]/div[1]/div[1]/div[1]"));
        //validate actual and expected message
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter valid username
        clickOnElement(By.id("username"));
        //sending field valid username
        sendTextToElement(By.id("tomsmith"),"");
        // Find the invalid password field element
        clickOnElement(By.name("password"));
        //     Sending invalid Password to password field element
        sendTextToElement(By.name("password"), "SuperSecretPassword!");
        //Find the login button and click on it
        WebElement loginButton = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/button[1]/i[1]"));
        loginButton.click();
        //This is from requirement
        String expectedMessage = "Your password is invalid!";
        // verify the error message your username is invalid
        String actualMessage = getTextFromElement(By.xpath("//body"));
        //validate actual and expected message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = getTextFromElement(By.className("button"));
        // Validate actual and expected message
        org.junit.Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
