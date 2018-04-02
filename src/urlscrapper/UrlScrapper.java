package urlscrapper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlScrapper {
public static void main(String[] args) throws InterruptedException {
		
	
	String exePath = "D:\\Workshop\\Eclipse\\chromedriver_win32\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", exePath);
	
		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();
		
        //Launch the Online Store Website
		driver.get("http://nationalgeographic.com/animals/index");
 
        // Print a Log In message to the screen
        System.out.println("Successfully opened the website http://nationalgeographic.com/animals/index");
        
        List<String> urls = new ArrayList<String>();
		
		for (int i = 26; i < 702; ++i) {
	       
			driver.findElement(By.cssSelector("input[type='search']")).sendKeys(str(i));
			
			Thread.sleep(5000);
			
			List<WebElement> results = driver.findElements(By.cssSelector(".search-component__results-block__result"));
			System.out.println(results.size());
			for(WebElement result : results) {
				//System.out.println(result.findElement(By.className("div-link")).toString());
				urls.add(result.findElement(By.className("div-link")).getAttribute("href"));
			}
			
			for(String url : urls) {
				System.out.println("URL: "+url);
			}
			driver.findElement(By.cssSelector("input[type='search']")).clear();
			
	    }
		
		
		
        // Close the driver
        driver.quit();
    }
static String str(int i) {
    return i < 0 ? "" : str((i / 26) - 1) + (char)(65 + i % 26);
}
}
