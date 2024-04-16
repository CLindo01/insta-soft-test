//---------------------------------------------------------
// File: AccountInteraction.java
// Author(s): Alyssa Chiego
// Class: CEN 4072 Y4S2 2024 : Software Testing
// Purpose: Testing the account search & follow feature on Instagram
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

public class AccountInteraction {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/christianlindo/Desktop/SoftwareTesting/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com/");
        signIn("studentacc01", "instapassword"); // Replace with real credentials
    }

    private void signIn(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Adjust this wait to the specific element that indicates a successful login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Save your login info?')]")));
    }

    @Test(priority = 1)
    public void searchTab() throws InterruptedException {
        // Assuming the XPath is correct, but this is very fragile. Consider using more stable selectors.
        driver.findElement(By.linkText("Search")).click();
        Thread.sleep(1000); // Consider using WebDriverWait instead of Thread.sleep
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/input"))).click();
    }

    @Test(priority = 2)
    public void searchAndFollowAccount() throws InterruptedException {
        searchAcc();
        follow();
    }

    private void searchAcc() throws InterruptedException {
        // Assumes finding the search input and entering a search term
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/input"));
        searchBar.sendKeys("instagram");
        Thread.sleep(2000); // Consider using WebDriverWait instead of Thread.sleep

        WebElement account = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/a[1]/div[1]/div/div/div[2]/div/div"));
        account.click();
        Thread.sleep(2000); // Consider using WebDriverWait instead of Thread.sleep
    }

    private void follow() throws InterruptedException {
        WebElement followBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/section/main/div/header/section/div[1]/div[2]/div/div[1]/button/div/div"));
        followBtn.click(); // Follow the account
        Thread.sleep(3000); // Consider using WebDriverWait instead of Thread.sleep
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
