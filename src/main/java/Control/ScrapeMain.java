package Control;

import Implementations.testIMPL;
import Interfaces.FileInterface;
import Interfaces.StartInterface;
import org.openqa.selenium.WebDriver;




// @author Lasse
 
public class ScrapeMain {
    
    public static StartInterface SI;
    public static FileInterface FI;
   
    public ScrapeMain(StartInterface SI)
    {
        this.SI = SI;
    }
    
    public static void main(String[] args)
    {
       new ScrapeMain(new testIMPL()); //Change this to change implementation
       
       SI.setDriver(1, "/Users/Lasse/Documents/Java/DanawebExamProject/chromedriver");
       SI.setUrl("https://www.komplett.dk/");
       SI.searchPhrase("cell");
       SI.searchType(2);
       
       FI.openFile();
       
    }
    

}
