import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleElements {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        // Replace 2nd parameter with your own path
        System.setProperty("webdriver.chrome.driver", "F:\\Google Drive\\Work\\Selenium\\My Selenium Course\\Selenium WD\\FINAL VERSION\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//kkk
    }

    @BeforeMethod
    public void beforeMethod(){

    }

    @Test
    public void test1(){

        try {

            // https://saucelabs.com/resources/articles/selenium-tips-css-selectors
            driver.get("https://www.888poker.com");

            WebDriverWait wait = new WebDriverWait (driver, 15);;
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#popup-offer > button")));
            WebElement close = driver.findElement(By.cssSelector("div#popup-offer > button"));
            close.click();

            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            System.out.println("Total: " + allLinks.size());

            int notDisplayed = 0;
            int noText = 0;
            for(int i = 0; i < allLinks.size(); i++){
                if(!allLinks.get(i).isDisplayed())
                    notDisplayed++;
                if(allLinks.get(i).getText().equals(""))
                    noText++;
            }

            System.out.println("Hidden: " + notDisplayed);
            System.out.println("NoText: " + noText);

            notDisplayed = 0;
            noText = 0;
            for(WebElement element : allLinks){
                if(!element.isDisplayed())
                    notDisplayed++;
                if(element.getText().equals(""))
                    noText++;
            }

            System.out.println("Hidden: " + notDisplayed);
            System.out.println("NoText: " + noText);

            Thread.sleep(5000);

        }
        catch(Exception e){
            System.out.println("Message: " + e.getMessage());
        }
    }

    @Test
    public void test2(){

        try {

            // https://saucelabs.com/resources/articles/selenium-tips-css-selectors
            driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
            driver.switchTo().frame(0);
            Select select = new Select(driver.findElement(By.tagName("select")));
            select.selectByVisibleText("Opel");

            Thread.sleep(5000);

        }
        catch(Exception e){
            System.out.println("Message: " + e.getMessage());
        }
    }

    @Test
    public void test3(){

        try {

            // https://saucelabs.com/resources/articles/selenium-tips-css-selectors
            driver.get("http://www.w3schools.com/html/html_tables.asp");
            WebElement table = driver.findElement(By.cssSelector("table#customers"));
            String country = getTableCellText(table, 1, "Ernst Handel", 3);
            System.out.println(country);

            boolean isTextOk = verifyTableCellText(table, 1, "Ernst Handel", 3, "Austria");
            System.out.println(isTextOk);

            country = getTableCellTextByXpath(table, 1, "Ernst Handel", 3);
            System.out.println(country);

            Thread.sleep(1000);

        }
        catch(Exception e){
            System.out.println("Message: " + e.getMessage());
        }
    }

    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) throws InterruptedException {

        try {

            List<WebElement> rows = table.findElements(By.tagName("tr"));
            rows = table.findElements(By.xpath(".//tbody/tr"));
            for(int i = 2; i <= rows.size(); i++){
                if(table.findElement(By.xpath("./tbody/tr[" + i + "]/td[" + searchColumn + "]")).getText().equals(searchText))
                    return table.findElement(By.xpath("./tbody/tr[" + i + "]/td[" + returnColumnText + "]")).getText();
            }

            return "";
        }
        catch(Exception e){
            throw e;
        }
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) throws InterruptedException {

        try {

            String actualText = getTableCellText(table, 1, "Ernst Handel", 3);
            if(actualText.equals(expectedText))
                return true;
            else
                return false;
        }
        catch(Exception e){
            throw e;
        }
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) throws InterruptedException {

        try {

            WebElement cell = table.findElement(By.xpath(".//tr[./td[text()='" + searchText + "']]/td[" + returnColumnText + "]"));
            return cell.getText();
        }
        catch(Exception e){
            throw e;
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
