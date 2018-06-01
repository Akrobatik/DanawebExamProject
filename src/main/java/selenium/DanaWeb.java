/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Rasmussen
 */
public class DanaWeb {
    
     private static WebDriver driver = null;
    
    public static void main(String[] args) throws InterruptedException, IOException {
        
        System.setProperty("webdriver.chrome.driver", "/Users/Lasse/Documents/Java/DanawebExamProject/chromedriver");
        driver = new ChromeDriver();
        
        //DanaWeb
        driver.get("https://www.google.dk/search?ei=iG-qWve0CMzX6AS9gaTYBg&q=Created+and+hosted+by+danaweb&oq=Created+and+hosted+by+danaweb&gs_l=psy-ab.3..0i22i30k1l2.16426704.16430880.0.16431109.29.24.0.5.5.0.155.1845.21j3.24.0....0...1c.1.64.psy-ab..0.29.1854...0j0i67k1j0i131k1j0i131i67k1j0i10k1j0i22i10i30k1j0i13i30k1j33i22i29i30k1.0.MtSDa1Uza8o" );
        //Hest
        //driver.get("https://www.google.dk/search?q=hest&oq=hest&aqs=chrome.0.69i59j0j69i60l2j0l2.854j0j7&sourceid=chrome&ie=UTF-8");
        //6 pages 
        //driver.get("https://www.google.dk/search?q=Emil+Malmgaard+Rasmussen&oq=Emil+Malmgaard+Rasmussen&aqs=chrome..69i57j69i61l3.3245j0j7&sourceid=chrome&ie=UTF-8");
        
        int pageNumber = 1;
        boolean nextPage = true;
        List<WebElement> links;
                
        String filePath = "file.csv";
        
        try (OutputStream fileStream = new BufferedOutputStream(new FileOutputStream(filePath));
                Writer outStreamWriter = new OutputStreamWriter(fileStream, StandardCharsets.UTF_8);
                BufferedWriter buffWriter = new BufferedWriter(outStreamWriter)) {
        
        while(nextPage)
        {
            links = driver.findElements(By.cssSelector("#search h3.r a"));
            System.out.println("PageNumber: " + pageNumber++);
            System.out.println("NumberOfLinks: " + links.size());
            
            for(WebElement link : links)
            {
                System.out.println("Link: " + link.getText());
                
                System.out.println("Href: " + link.getAttribute("href"));
                buffWriter.append(link.getAttribute("href"));
                buffWriter.newLine();
                buffWriter.flush();
                
                ((JavascriptExecutor)driver).executeScript("window.open('" + link.getAttribute("href") + "', '_blank');");

                //Open new page
                driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
                
                System.out.println("Title: " + driver.getTitle());
                
                //Close new page
                driver.close();
                
                //Switch old page
                driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));            
            
                System.out.println("-----");
            }
            
            nextPage = !driver.findElements(By.cssSelector("#pnnext")).isEmpty();
            if(nextPage)
            {
                driver.findElements(By.cssSelector("#pnnext")).get(0).click();
            }
            
            System.out.println("----------");
        }
        }//buff
    }
}
