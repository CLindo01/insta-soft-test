//---------------------------------------------------------
// File: Like.java
// Author(s): Alyssa Chiego
// Class: CEN 4072 Y4S2 2024: Software Testing
// Purpose: Testing the account search & like feature
// Audit: 4.10.24
//---------------------------------------------------------
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Like {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actionBuilder;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/christianlindo/Desktop/SoftwareTesting/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actionBuilder = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com/");
        signIn("studentacc01", "instapassword"); // Replace with actual credentials
    }

    private void signIn(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Save your login info?')]"))); // Adjust if necessary
    }

    @Test(priority = 1)
    public void searchTab() throws InterruptedException {
        // Assuming the XPath is correct, but this is very fragile. Consider using more stable selectors.
        driver.findElement(By.linkText("Search")).click();
        Thread.sleep(1000); // Consider using WebDriverWait instead of Thread.sleep
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/input"))).click();
    }

    @Test(priority = 2)
    public void searchAccount() throws InterruptedException {
        // Assumes finding the search input and entering a search term
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/input"));
        searchBar.sendKeys("microsoft");
        Thread.sleep(2000); // Consider using WebDriverWait instead of Thread.sleep

        WebElement account = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/a[1]/div[1]/div/div/div[2]/div/div"));
        account.click();
        Thread.sleep(2000); // Consider using WebDriverWait instead of Thread.sleep
    }

    @Test(priority = 3)
    public void selectPost() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstPost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/p/C5WKhPcMrNj/')]")));
        firstPost.click();
    }

    @Test(priority = 4)
    public void likeAndUnlike() throws InterruptedException {
        Thread.sleep(2000); // Pause for visibility
        // Press "L" to like the post
        actionBuilder.sendKeys("l").perform();
        Thread.sleep(2000); // Pause for visibility

        // Press "L" again to unlike
        actionBuilder.sendKeys("l").perform();
        Thread.sleep(2000); // Pause for visibility
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
