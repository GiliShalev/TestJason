import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ObjectsIdentification {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        // Replace 2nd parameter with your own path
        System.setProperty("webdriver.chrome.driver", "F:\\Google Drive\\Work\\Selenium\\My Selenium Course\\Selenium WD\\FINAL VERSION\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @BeforeMethod
    public void beforeMethod(){

    }

    @Test
    public void test1(){

        try {

            // https://saucelabs.com/resources/articles/selenium-tips-css-selectors
            driver.get("http://www.777.com");

            WebElement home = driver.findElement(By.xpath("//div[@class='logoContainer large-2 column show-for-large-up']"));
            home = driver.findElement(By.cssSelector("div.logoContainer"));
            home.click();

            WebElement liveCasino = driver.findElement(By.xpath("//a[text()='Live Casino']"));
            liveCasino = driver.findElement(By.xpath("//ul[@class='pctopmenuContainr']/li[6]/a"));
            liveCasino = driver.findElement(By.linkText("Live Casino"));
            liveCasino = driver.findElement(By.cssSelector("ul.pctopmenuContainr>li:nth-child(5)>a"));
            liveCasino.click();

            Thread.sleep(3000);

        }
        catch(Exception e){
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }

    }

    @Test
    public void test2(){

        try {

            // https://saucelabs.com/resources/articles/selenium-tips-css-selectors
            driver.get("http://www.888casino.com");
            WebElement logIn = driver.findElement(By.xpath("//a[@class='brand-bttn round secondary-strok']"));
            logIn = driver.findElement(By.cssSelector("a.brand-bttn.round.secondary-strok"));
            logIn = driver.findElement(By.linkText("LOG IN"));
            logIn = driver.findElement(By.cssSelector("default-button.login-button>a"));
            logIn.click();

            Thread.sleep(10000);

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
