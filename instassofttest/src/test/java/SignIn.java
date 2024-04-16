//---------------------------------------------------------
// File: SignIn.java
// Author(s): Alyssa Chiego, Christian Lindo ,
//            Richarson Jacques
// Class: CEN 4072 Y4S2 2024 : Software Testing
// Purpose: testing the sign in capabilities of the
//          instagram homepage
// Audit: 4.4.24 / 4.10.24
//---------------------------------------------------------


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignIn {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/christianlindo/Desktop/SoftwareTesting/chromedriver");

        WebDriver driver = new ChromeDriver(); // This opens a new browser window
        driver.manage().window().maximize(); // maximizes chrome browser window

        webpage(driver);
        username(driver);
        password(driver);
        login(driver);
    }

    public static void webpage(WebDriver driver) throws InterruptedException {

        // Navigate to the webpage
        String Instagram = "https://www.instagram.com/";
        driver.get(Instagram);

    }

    public static void username(WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // adds a wait variable
        WebElement UsernameTB = wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))); //wait until username box is found
        UsernameTB.sendKeys("studentacc01"); //enters in email
        Thread.sleep(1000); // time buffer

    }

    public static void password(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // adds a wait variable
        WebElement PasswrdTB = wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))); //wait until password box is found
        PasswrdTB.sendKeys("instapassword"); //enters in password
        Thread.sleep(1000); // time buffer

    }

    public static void login(WebDriver driver) throws InterruptedException {

        WebElement LoginBtn = driver.findElement(By.xpath("/html/body/div[2]/d" +
                "iv/div/div[2]/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/for" +
                "m/div/div[3]/button")); // finds login button
        LoginBtn.click(); //selects login button
        Thread.sleep(15000); // 15 second buffer to allow to show login page

        // Close the browser
        driver.quit();

    }
}


