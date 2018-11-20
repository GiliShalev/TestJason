import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Synchronization {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        // Replace 2nd parameter with your own path
        System.setProperty("webdriver.chrome.driver", "F:\\Google Drive\\Work\\Selenium\\My Selenium Course\\Selenium WD\\FINAL VERSION\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void beforeMethod(){

    }

    @Test
    public void test1(){

        try {

            // https://saucelabs.com/resources/articles/selenium-tips-css-selectors
            driver.get("http://www.888casino.com");
            WebElement logIn = driver.findElement(By.xpath("//a[@class='brand-bttn round secondary-strok']"));
            logIn = driver.findElement(By.cssSelector("a.brand-bttn.round.secondary-strok"));
            logIn = driver.findElement(By.linkText("LOG IN"));
            logIn = driver.findElement(By.cssSelector("default-button.login-button>a"));
            logIn.click();

            WebDriverWait wait = new WebDriverWait (driver, 15);;
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#rlLoginCloseButton>div.rllogin-close-button")));

            WebElement close = driver.findElement(By.cssSelector("a#rlLoginCloseButton>div.rllogin-close-button"));
            wait.until(ExpectedConditions.elementToBeClickable(close));
            close.click();

            Thread.sleep(2000);

        }
        catch(Exception e){
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }

    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
