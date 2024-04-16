//---------------------------------------------------------
// File: DirMes.java
// Author(s): Alyssa Chiego
// Class: CEN 4072 Y4S2 2024 : Software Testing
// Purpose: testing the account direct message feature
// Audit: 4.10.24
//---------------------------------------------------------

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

public class DirMes {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/christianlindo/Desktop/SoftwareTesting/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.instagram.com/");
        signIn("studentacc01", "instapassword"); // Replace with your credentials
    }

    private void signIn(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Save your login info?')]"))); // Adjust this locator
    }

    @Test(priority = 1)
    public void dmTab() {
        driver.findElement(By.linkText("Messages")).click();
    }

    @Test(priority = 2)
    public void createDM() throws InterruptedException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement closeit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[3]/button[2]\n")));
        closeit.click();
        WebElement createDM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[1]/div/div[1]/div[2]/div")));
        createDM.click();

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[1]/div/div[2]/div/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/input")));
        searchBox.sendKeys("belles.mccurdy");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div[1]/div/div[2]/div/div/div/div/div/div/div[1]/div/div[3]/div/div/div/div[1]/div/div/div[3]/div/label/div/input"))).click();
        WebElement chat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div[1]/div/div[2]/div/div/div/div/div/div/div[1]/div/div[4]/div")));
        chat.click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void sendDM() throws InterruptedException {
        WebElement messageBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[1]/p")));
        messageBox.sendKeys("Hi! (if you see me, I worked!)");
        Thread.sleep(1000);

        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/div/div[3]")));
        sendButton.click();
        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
