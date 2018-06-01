package Implementations;

import Interfaces.StartInterface;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


// @author Lasse
 
public class testIMPL implements StartInterface{
    
    private static WebDriver driver = null;
    List<WebElement> els;
    String searchPhrase = "";

    public testIMPL()
    {
        searchPhrase = "No phrase specified";
        System.out.println("ny IMPL created");
    }

    @Override
    public void setUrl(String url)
    {
       driver.get(url);
    }

    @Override
    public void setDriver(int Driv, String Path)
    {
        switch (Driv)
        {
            case 1:
                System.out.println("heyhey1");
                System.setProperty("webdriver.chrome.driver", Path);
                System.out.println(Path);
                System.out.println("heyhey2");
                driver = new ChromeDriver();
                break;
            case 2:
                System.setProperty("webdriver.firefox.driver", Path);
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Choose either 1 or 2 as driver input");
                break;
        }
    }

    @Override
    public void searchType(int type)
    {
        
        if(searchPhrase.isEmpty() || searchPhrase == null){
            //Evt throw error hvis vil vaere cool, for now dog kun sout error hehehehe
            System.out.println("SearchPhrase must be set before SearchType");
        }
        System.out.println("tesytesytesy");
       switch(type)
       {
            case 1:
                System.out.println("Du har valgt CssSelector");
                els = driver.findElements(By.cssSelector(searchPhrase));
                break;
            case 2:
                System.out.println("Du har valgt ClassName");
                els = driver.findElements(By.className(searchPhrase));
                break;
            case 3:
                System.out.println("Du har valgt Id");
                els = driver.findElements(By.id(searchPhrase));
                break;
            case 4:  
                System.out.println("LinkText");
                els = driver.findElements(By.linkText(searchPhrase));
                break;
            case 5: 
                System.out.println("Du har valgt Name");
                els = driver.findElements(By.name(searchPhrase));
                break;
            case 6:
                System.out.println("Du har valgt PartialLinkText");
                els = driver.findElements(By.partialLinkText(searchPhrase));
                break;
            case 7:
                System.out.println("Du har valgt TagName");
                els = driver.findElements(By.tagName(searchPhrase));
                break;
            case 8:
                System.out.println("Du har valgt xPath");
                els = driver.findElements(By.xpath(searchPhrase));
                break;
       }

        for (WebElement el : els)
        {
            System.out.println(el.getText());
        }
    }

    @Override
    public void searchPhrase(String phrase)
    {
       searchPhrase = phrase;
    }

    @Override
    public void quit()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   



}
