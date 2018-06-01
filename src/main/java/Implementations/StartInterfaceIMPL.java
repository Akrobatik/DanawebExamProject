package Implementations;

import Interfaces.StartInterface;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


// @author Lasse
 
public class StartInterfaceIMPL implements StartInterface{
    
    private static WebDriver driver = null;
    List<WebElement> els;
    String searchPhrase = "";
    private ArrayList<String> res = new ArrayList();
    
    
    public StartInterfaceIMPL()
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
    public void searchType(int type) {
        
        if(searchPhrase.isEmpty() || searchPhrase == null){
            //Evt throw error hvis vil være cool, for now dog kun sout error hehehehe
            System.out.println("SearchPhrase must be set before SearchType");
        }

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
            //System.out.println(el.getText());
            setResult(el.getText());
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
    
   @Override
   
   /*
   clickModal(String xpath) 
   Provide the method with a xpath (Right click while inspecting the modal that is overlapping the website -> Copy -> Copy xPath)
   
   A lot of browsers are starting to implement cookiebotadds, they prevent the scraper for scraping the view,
   use this method to get rid of it.
   */
    public void clickModal(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    @Override
    public ArrayList<String> setResult(String some) {
        res.add(some);
        return null;
    }

    @Override
    public ArrayList<String> getResult() {
        return res;
    }
    
    

}
