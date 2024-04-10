//This class if for testing the account search feature and the following feature

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DirMes{

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Initialize the WebDriver and sign into the account
        System.setProperty("webdriver.chrome.driver", "/Users/christianlindo/Desktop/SoftwareTesting/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com/");

        // Sign-in process
        signIn("student3885", "instapassword"); // Replace with your credentials
    }

    private void signIn(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Username
        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        usernameInput.sendKeys(username);

        // Password
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        passwordInput.sendKeys(password);

        // Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for navigation to profile or home page as a sign of successful login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Save your login info?')]"))); // Adjust this locator
    }

    @Test(priority = 1)
    public static void webpage(WebDriver driver) {

        // Navigate to the webpage
        String Instagram = "https://www.instagram.com/";
        driver.get(Instagram);

    }

    @Test (priority = 2)
    public static void dmTab(WebDriver driver) throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // adds a wait variable
        WebElement dmBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[5]/div/div/div/span/div/a/div/div/div/div/svg/path[1]")));

        dmBtn.click(); //selects dm button
        Thread.sleep(5000); // 5 second buffer to allow to show dm page

    }

    @Test (priority = 3)
    public static void sendDM(WebDriver driver) throws InterruptedException{

        WebElement createDM = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[2]/div/div/div/div[4]/div"));
        createDM.click();
        Thread.sleep(2000); // 2 second buffer to show results

        WebElement Account = driver.findElement(By.xpath(""));
        Account.click();
        Thread.sleep(2000); // 2 second buffer to show account

    }

    @Test (priority = 4)
    public static void deleteDM(WebDriver driver) throws InterruptedException{

        WebElement followBtn = driver.findElement(By.linkText("Follow"));
        followBtn.click();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
