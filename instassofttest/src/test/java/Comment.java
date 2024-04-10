import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Comment {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/christianlindo/Desktop/SoftwareTesting/chromedriver");

        WebDriver driver = new ChromeDriver(); // creates variable for driver
        driver.manage().window().maximize(); // maximizes chrome browser window

        webpage(driver);
        searchTab(driver);
        searchAcc(driver);
        selectPost(driver);
        comment(driver);

    }
    public static void webpage(WebDriver driver) {

        // Navigate to the webpage
        String Instagram = "https://www.instagram.com/";
        driver.get(Instagram);

    }

    public static void searchTab(WebDriver driver) throws InterruptedException{

        WebElement SearchBtn = driver.findElement(By.linkText("Explore")); // finds login button
        SearchBtn.click(); //selects explore button
        Thread.sleep(5000); // 5 second buffer to allow to show explore page

    }

    public static void searchAcc(WebDriver driver) throws InterruptedException{

        WebElement SearchBar = driver.findElement(By.linkText("Search")); // finds login button
        SearchBar.sendKeys("microsoft");
        Thread.sleep(2000); // 2 second buffer to show results

        WebElement Account = driver.findElement(By.partialLinkText("Microsoft "));
        Account.click();
        Thread.sleep(2000); // 2 second buffer to show account

    }

    public static void selectPost(WebDriver driver) throws InterruptedException{

        WebElement pinPost = driver.findElement(By.xpath("/html/body/div[2]/div/" +
                "div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/section/main/div/div[4]/div/div[1]" +
                "/div[1]/a/div[1]/div[1]/img"));
        pinPost.click();
        Thread.sleep(1000); // 2 second buffer to show selected pinned post

    }

    public static void comment(WebDriver driver) throws InterruptedException{

        WebElement commentBtn = driver.findElement(By.linkText("Comment"));
        commentBtn.click();
        Thread.sleep(1000); // show comment section

        WebElement commentBar = driver.findElement(By.linkText("Add a comment..."));
        commentBar.sendKeys("Nice!");

        WebElement postComment = driver.findElement(By.linkText("Post"));
        postComment.click();
        Thread.sleep(5000); // show comment section for 5 seconds before allowing browser to close

        driver.quit(); //closes browser

    }

}
