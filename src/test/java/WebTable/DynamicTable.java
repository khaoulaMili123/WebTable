package WebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://blazedemo.com/");
		
        // Select Departure and Destination Cities
		WebElement DepCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select select1 = new Select(DepCity);
		select1.selectByVisibleText("Boston");
		
		WebElement DesCity = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select select2 = new Select(DesCity);
		select2.selectByVisibleText("Rome");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
        // Find the cheapest flight
        List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table']//tr//td[6]"));
        
        double minPrice = Double.MAX_VALUE;
        int minPriceIndex = -1;

        for (int i = 0; i < priceElements.size(); i++) {
            // Extraction du texte de chaque élément de prix et suppression du symbole $
            String priceText = priceElements.get(i).getText().replace("$", "");
            double price = Double.parseDouble(priceText); // Conversion du texte en double

            if (price < minPrice) {
                minPrice = price;
                minPriceIndex = i + 1; // Stocker l'index de la ligne (i+1 car XPath commence à 1)
            }
        }

        if (minPriceIndex != -1) {
            driver.findElement(By.xpath("//table[@class='table']//tr[" + minPriceIndex + "]//td[1]/input")).click();
            System.out.println("Le vol avec le prix le plus bas à $" + minPrice + " a été sélectionné.");
        }
	
        //Fill in the booking details       
        driver.findElement(By.id("inputName")).sendKeys("John");
        driver.findElement(By.id("city")).sendKeys("Boston");
        WebElement CardType = driver.findElement(By.id("cardType"));
		Select select3 = new Select(CardType);
		select3.selectByVisibleText("Visa");
        driver.findElement(By.id("creditCardNumber")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        
        //Verify the confirmation message
        WebElement confMSG=driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']"));
        String message =confMSG.getText();
        if(message.contains("Thank you")) {
        	System.out.println("your reservation is confirmed");
        }
	}

}
