package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {

        openBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

        // Find the emailField and type the Admin to username field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("tomsmith");

        // Find the password field and type the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // Find the login button element and click
        driver.findElement(By.xpath("//i[contains(@class,'fa')]")).click();

        // find the text element in the re-directed page to verify successfully login
        String actualText = driver.findElement(By.xpath("//h2[contains(text(), ' Secure Area' )]")).getText();

        String expectedText = "Secure Area";  // expected text

        Assert.assertEquals(expectedText, actualText);  // verify expected and actual text
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // Find the emailField and type the Email to username field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("tomsmith1");

        // Find the password field and type the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // Find the login button element and click
        driver.findElement(By.xpath("//i[contains(@class,'fa')]")).click();


        String expectedText = "Your username is invalid!\n×";

        // Verify the error message “Your username is invalid!”
        String actualText = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Find the emailField and type the Email to username field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("tomsmith");

        // Find the password field and type the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword");

        // Find the login button element and click
        driver.findElement(By.xpath("//i[contains(@class,'fa')]")).click();

        String expectedText = "Your password is invalid!\n×";

        // Verify the error message “Your password is invalid!”
        String actualText = driver.findElement(By.xpath("//div[@id='flash-messages']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }


}






