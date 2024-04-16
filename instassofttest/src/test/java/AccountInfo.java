//---------------------------------------------------------
// File: AccountInfo.java
// Author(s): Christian Lindo
// Class: CEN 4072 Y4S2 2024 : Software Testing
// Purpose: testing the ability to edit account info & bio
//          feature
// Audit: 4.10.24
//---------------------------------------------------------

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AccountInfo {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/christianlindo/Desktop/SoftwareTesting/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com/");
        signIn("studentacc01", "instapassword"); // Use real credentials here
    }

    private void signIn(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Adjust this wait to the specific element that indicates a successful login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Save your login info?')]")));
    }

    @Test(priority = 1)
    public void navigateToEditPage() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div/div/div[2]/div[8]/div/span/div/a/div/div[1]/div/div")).click();   // Adjust the URL to your profile
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/section/main/div/header/section/div[1]/div[2]/div[1]/div[1]/a"))).click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/section/main/div/div[3]/div/div[1]/div/div/span"))).isDisplayed(), "Edit profile form is not displayed.");
    }

    @Test(priority = 2)
    public void updateBio() {
        // Assuming navigating to the bio field is part of the edit profile page
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/section/main/div[1]/div/div[1]/div/div/svg\n"))).click();

        WebElement bioField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/section/main/div/div[3]/div/div/form/div[1]/div/textarea"))); // This locator will likely need adjustment
        bioField.clear();
        bioField.sendKeys("This is a test bio.");

        // Placeholder for an assertion to verify the bio field is updated as expected
    }

    @Test(priority = 3)
    public void submitChanges() throws InterruptedException {
        // This assumes the button to submit changes is visible and clickable on the edit profile page
        WebElement submitButton = driver.findElement(By.xpath("//*[@role='button'][contains(text(), 'Submit')]"));
        submitButton.click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
