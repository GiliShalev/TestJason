import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BasicActions {

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

            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

            WebElement banking = driver.findElement(By.linkText("BANKING"));
            banking.click();

            WebElement bonusPolicy = driver.findElement(By.xpath("//a[@id='LeftMenuBouns' and text()='BonusPolicy']"));
            bonusPolicy = driver.findElement(By.xpath("//a[@id='LeftMenuBouns' and .='BonusPolicy']"));
            bonusPolicy = driver.findElement(By.xpath("//a[@id='LeftMenuBouns' and contains(., 'Bonus')]"));
            bonusPolicy.click();

            WebElement bullet = driver.findElement(By.xpath("//div[contains(@class, 'leftContent')]//ul/li[1]"));
            bullet = driver.findElement(By.xpath("//ul[li[contains(., 'The Welcome Bonus')]]"));
            bullet = driver.findElement(By.xpath("//ul/li[contains(., 'The Welcome Bonus')]"));
            bullet = driver.findElement(By.cssSelector("div.leftContent ul>li:nth-child(1)"));
            System.out.println(bullet.getText());




            Thread.sleep(3000);

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
