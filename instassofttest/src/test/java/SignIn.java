//---------------------------------------------------------
// File: SignIn.java
// Author(s): Alyssa Chiego, Christian Lindo ,
//            Richarson Jacques
// Class: CEN 4072 Y4S2 2024 : Software Testing
// Purpose: testing the sign in capabilities of the
//          instagram homepage
// Audit: 4.4.24
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

        // Navigate to the webpage
        String Instagram = "https://www.instagram.com/";
        driver.get(Instagram);


        //Sign in to IG Account
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement UsernameTB = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        UsernameTB.sendKeys("FinalProjCEN4072"); //enters in email
        Thread.sleep(1000); // time buffer

        WebElement PasswrdTB = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        PasswrdTB.sendKeys("instapassword"); //enters in password
        Thread.sleep(1000); // time buffer

        WebElement LoginBtn = driver.findElement(By.xpath("/html/body/div[2]/d" +
                "iv/div/div[2]/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/for" +
                "m/div/div[3]/button")); // finds login button
        LoginBtn.click(); //selects login button
        Thread.sleep(15000); // 15 second buffer to allow to show login page

        // Close the browser
        driver.quit();
         }

    }
