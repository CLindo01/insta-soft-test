import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Sign_Out {

    @Test
    public static void Sign_Out() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\rjacq\\OneDrive - Florida Gulf Coast University\\2024_Spring\\CEN 4072 Software Testing\\ChromeDriver\\chromedriver.exe");

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();

        // Navigate to the webpage
        String Instagram = "https://www.instagram.com/";
        driver1.get(Instagram);


        //Sign in to IG Account
        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
        WebElement UsernameTB = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        UsernameTB.sendKeys("bubba8441"); //enters in email
        Thread.sleep(1000); // time buffer

        WebElement PasswrdTB = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        PasswrdTB.sendKeys("bubba84411"); //enters in password
        Thread.sleep(1000); // time buffer

        WebElement LoginBtn = driver1.findElement(By.xpath("/html/body/div[2]/d" +
                "iv/div/div[2]/div/div/div[1]/section/main/article/div[2]/div[1]/div[2]/for" +
                "m/div/div[3]/button")); // finds login button
        LoginBtn.click(); //selects login button
        Thread.sleep(15000); // 15 second buffer to allow to show login page

        //Select More Tab
        driver1.findElement(By.linkText("More")).click();
        Thread.sleep(5000);

        //Select Log out
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[1]/div/div[8]/div[1]")));
        logout.click();
        Thread.sleep(20000);


        driver1.quit();


    }

}
