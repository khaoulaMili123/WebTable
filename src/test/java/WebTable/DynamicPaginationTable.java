package WebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicPaginationTable {

    public static void main(String[] args) throws Throwable {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

          	driver.get("https://demo-opencart.com/admin/index.php");
          	
          	//Login
    		WebElement username = driver.findElement(By.id("input-username"));
            username.clear();
            username.sendKeys("demo");
            WebElement password = driver.findElement(By.id("input-password"));
            password.clear();
            password.sendKeys("demo");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
            
    		//close window if it is available
            WebElement BTNclose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-close']")));
            if (BTNclose.isDisplayed()) {
                BTNclose.click();
            }

    		//customers main menu
            driver.findElement(By.id("menu-customer")).click();
            driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
            
    		//Total Pages
            String pagesText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Pages')]"))).getText();
            int totalPages = Integer.parseInt(pagesText.substring(pagesText.indexOf("(") + 1, pagesText.indexOf("Pages") - 1));
            System.out.println("Total Pages: " + totalPages);

    		//repeating pages
            for (int p = 1; p <= totalPages; p++) {
                if (p > 1) {
                    WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='" + p + "']"));
                    // Scroll to the element before clicking
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activePage);
                    Thread.sleep(5000); 
                    activePage.click();
                    Thread.sleep(5000); 
                }
                //reading data from the page
            int NumOfRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            
            for(int r=1;r<=NumOfRows;r++) {
            	
            String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
            String Email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
            String dateadded = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();

            System.out.println(customerName+"\t"+Email+"\t"+dateadded);
            }
            }
    }
}
