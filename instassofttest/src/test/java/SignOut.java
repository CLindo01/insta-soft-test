import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignOut {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/christianlindo/Desktop/SoftwareTesting/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void signOut() throws InterruptedException {
        // Navigate to the webpage
        driver.get("https://www.instagram.com/");

        // Sign in to IG Account
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys("studentacc01");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("instapassword");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']")); // Adjusted for a more general approach
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("More"))); // Assumes "More" is visible after login

        // Select More Tab (Assuming this is part of the UI post-login)
        driver.findElement(By.linkText("More")).click();

        // Select Log out
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[1]/div/div[6]/div[1]/div/div/div[1]/div/div/span/span\n"))); // Example, adjust as needed
        logout.click();
        Thread.sleep(1000);

        // Wait for logout to complete if necessary
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
