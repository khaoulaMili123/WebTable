package WebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-search-engine-choice-screen");
	    WebDriver driver = new ChromeDriver(options);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    driver.manage().window().maximize();

	    driver.get("https://testautomationpractice.blogspot.com/");
	    
	    //1)find total number of rows(lignes) (balise tr)
	    int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
	   	    
	    System.out.println("Number of rows:"+rows); 
	    
	    //2)find total number of columns in a table
	    int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
	    System.out.println("Number of columns:"+cols);
	    
	    //3)Read data from specific row and column (td=table data)
	    String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
	    System.out.println(bookName);
	
	    //4) read data from all the rows colums
//	    System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"");
//
//	    
//	    for(int r=2;r<=rows;r++)
//	    {
//	    	for(int c=1;c<=cols;c++)
//	    	{
//	    		String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();	    		    		
//	    		System.out.print(value+"\t");
//	    	}
//	    	System.out.println();
//	    	}
	    //5) Print book names whose author is Mukesh
	    for (int r=2;r<=rows;r++)
	    {
	    	String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
	    	if (authorName.equals("Mukesh"))
	    	{
		    	String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
		    	System.out.println(bookname+"\t"+authorName);
	    	}
	    }

	    //6) Find total price of all the books
	    int total = 0;
	    for (int r=2;r<=rows;r++) 
	    {
    	String Price =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
		total= total+Integer.parseInt(Price);	    
		}
	    System.out.println("Total Price of the books:"+total);
	}
	}
