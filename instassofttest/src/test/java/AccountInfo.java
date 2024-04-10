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
        signIn("student3885", "instapassword"); // Use real credentials here
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
        driver.get("https://www.instagram.com/student3885/"); // Adjust the URL to your profile
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Edit profile')]"))).click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Edit profile')]"))).isDisplayed(), "Edit profile form is not displayed.");
    }

    @Test(priority = 2)
    public void updateBio() {
        // Assuming navigating to the bio field is part of the edit profile page
        WebElement bioField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("bio"))); // This locator will likely need adjustment
        bioField.clear();
        bioField.sendKeys("This is a test bio.");

        // Placeholder for an assertion to verify the bio field is updated as expected
    }

    @Test(priority = 3)
    public void submitChanges() {
        // This assumes the button to submit changes is visible and clickable on the edit profile page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]"))).click();

        // Verify changes are saved, adjust the xpath as needed to match the confirmation message or indicator
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Profile saved')]"))).isDisplayed(), "Profile changes were not saved.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
