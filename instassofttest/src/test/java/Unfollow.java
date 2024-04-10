import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Unfollow {

    @Test
    public static void Unfollow() throws InterruptedException {

        //Don't pay too much attention to this part I'm just using it as a placeholder to pull up the browser and sign in
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

        //get past the popup
        //WebElement LogPop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'mount_0_0_tF\']/div/div/div[2]/div/div/div[1]/div[1]/div[2]/section/main/div/div/div/div/div")));
        //LogPop.click();
        //Thread.sleep(10000);

        //Go to profile page
        driver1.findElement(By.linkText("Profile")).click();
        Thread.sleep(5000);


        //Select list of followed
        WebElement SelectFollowing = wait.until(ExpectedConditions.elementToBeClickable(By.name("following")));
        SelectFollowing.click();
        Thread.sleep(20000);

        //Select Follow button next to first account name
        driver1.findElement(By.xpath("//*[@id=\'mount_0_0_Hd\']/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/section/main/div/header/section/ul/li[3]/a")).click();
        Thread.sleep(5000);

        //Unfollow the account
        driver1.findElement(By.xpath("/html/body/div[7]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[4]/div[1]/div/div[1]/div/div/div/div[3]/div/button/div/div")).click();
        Thread.sleep(10000);

        // Close the browser
        driver1.quit();


    }


}
