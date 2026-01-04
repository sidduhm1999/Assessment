package test.java.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginTests {

    private WebDriver driver;
    private Properties props;

    @BeforeClass
    public void loadProperties() throws IOException {
        props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);
    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver(props.getProperty("browser"));
        driver.get(props.getProperty("url"));
    }

    @Test(priority = 1)
    public void validLoginAndLogoutTest() throws InterruptedException {

        driver.findElement(By.id("username"))
                .sendKeys(props.getProperty("Valid.username"));
        driver.findElement(By.id("password"))
                .sendKeys(props.getProperty("Valid.password"));
        driver.findElement(By.xpath("//button[contains(text(),'Login to QKart')]"))
                .click();
    Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Logout')]")).click();
        System.out.println("Logout successful");
    }





    @Test(priority = 2)
public void invalidLoginTest() {
    driver.findElement(By.id("username")).sendKeys(props.getProperty("Invalid.username"));
    driver.findElement(By.id("password")).sendKeys(props.getProperty("Invalid.password"));
    driver.findElement(By.xpath("//button[contains(text(),'Login to QKart')]")).click();

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    boolean loginSucceeded = driver.findElements(By.id("notistack-snackbar")).stream()
            .anyMatch(e -> e.getText().contains("Username does not exist"));

    Assert.assertTrue(loginSucceeded, "Login succeeded when it should have failed");
}


    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
        System.out.println("Teardown completed");
    }
}
