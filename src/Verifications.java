import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Verifications {

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
            driver.get("http://www.888casino.com");
            String title = driver.getTitle();

            // Assert.assertEquals(title, "888", "Verify Page Title 1");
            Assert.assertNotEquals(title, "888", "Verify Page Title 2");
            Assert.assertTrue(title.contains("888"));
            Assert.assertTrue(title.contains("888"), "Verify Page Title 3");
            // Assert.assertTrue(title.contains("777"), "Verify Page Title 4");
            Assert.assertEquals(title, "Online Casino | £88 No Deposit Bonus | 888 Casino", "Verify Page Title 1");

            Thread.sleep(3000);

        }
        catch(AssertionError e){
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
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
            String title = driver.getTitle();

            if(title.contains("888"))
                System.out.println("Good");
            else
                System.out.println("Bad");

            if(!title.contains("888"))
                System.out.println("Bad");
            else
                System.out.println("Good");

            if(title.contains("888") != true)
                System.out.println("Bad");
            else
                System.out.println("Good");

            if(title.equals("Online Casino | £88 No Deposit Bonus | 888 Casino"))
                System.out.println("Good");
            else
                System.out.println("Bad");

            Thread.sleep(3000);

        }
        catch(Exception e){
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }

    }

    @Test
    public void test3(){

        try {

            driver.get("http://www.888casino.com");
            WebElement casinoGames = driver.findElement(By.cssSelector("li.main-nav-menu-item.casino-games>a"));
            String text = casinoGames.getText();

            Assert.assertTrue(text.equals("Casino Games"), "Verify Casino Games Link Text");
            Assert.assertEquals(text, "Casino Games", "Verify Casino Games Link Text");

            Assert.assertTrue(casinoGames.isEnabled(), "Verify Casino Games Link Enabled Property");
            Assert.assertEquals(casinoGames.isEnabled(), true, "Verify Casino Games Link Enabled Property");

            Thread.sleep(3000);

        }
        catch(AssertionError e){
            System.out.println("Message: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Message: " + e.getMessage());
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
