import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.*;

public class TestTemplate {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        // Replace 2nd parameter with your own path
        System.setProperty("webdriver.chrome.driver", "F:\\Google Drive\\Work\\Selenium\\My Selenium Course\\Selenium WD\\FINAL VERSION\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();

        //IE
        //System.setProperty("webdriver.ie.driver", "F:\\Google Drive\\Work\\Selenium\\My Selenium Course\\Selenium WD\\FINAL VERSION\\Resources\\IEDriverServer.exe");
        //InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        //internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        //internetExplorerOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
        //driver = new InternetExplorerDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        // Or
        // driver.navigate().to("https://www.google.com/");
    }

    @BeforeMethod
    public void beforeMethod(){

    }

    @Test
    public void test1(){

        try {
            WebElement searchField = driver.findElement(By.id("lst-ib"));
            searchField.sendKeys("Gili");

            WebElement searchButon = driver.findElement(By.name("btnK"));
            searchButon.click();
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
