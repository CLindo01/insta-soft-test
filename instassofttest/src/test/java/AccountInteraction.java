//This class if for testing the account search feature and the following feature

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountInteraction  {

    public static void AccountSearch() {
        System.setProperty("webdriver.chrome.driver", "/Users/christianlindo/Desktop/SoftwareTesting/chromedriver");

        WebDriver driver1 = new ChromeDriver(); // This opens a new browser window
        driver1.manage().window().maximize(); // maximizes chrome browser window

        // Navigate to the webpage
        String Instagram = "https://www.instagram.com/";
        driver1.get(Instagram);

        






    }







}
