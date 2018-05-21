package InterfaceSolution;

import org.openqa.selenium.WebDriver;




// @author Lasse
 
public class ScrapeMain {
    
    public static StartInterface SI;

   
    public ScrapeMain(StartInterface SI)
    {
        this.SI = SI;
    }
    
    public static void main(String[] args)
    {
       new ScrapeMain(new testIMPL()); //Change this to change implementation
       
       SI.setDriver(1, "/Users/Lasse/Documents/Java/DanawebExamProject/chromedriver");
       SI.setUrl("https://www.bt.dk/");
       SI.searchPhrase("span bt-link");
       SI.searchType(2);
    }
    

}
