package Control;

import Implementations.FileInterfaceIMPL;
import Implementations.StartInterfaceIMPL;
import Interfaces.FileInterface;
import Interfaces.StartInterface;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;




// @author Lasse
 
public class ScrapeMain {
    
    public static StartInterface SI;
    public static FileInterface FI;
   
    public ScrapeMain(StartInterface SI, FileInterface FI)
    {
        this.SI = SI;
        this.FI = FI;
    }
    
    
    public static void main(String[] args) throws InterruptedException
    {
        
      new ScrapeMain(new StartInterfaceIMPL(), new FileInterfaceIMPL()); //Change this to change implementation
       
       SI.setDriver(1, "./chromedriver");
       SI.setUrl("https://www.komplett.dk/");
       SI.searchPhrase("cell");
       SI.searchType(2);
       //SI.result();
        System.out.println(SI.result());
//       SI.setUrl("https://www.bt.dk/");
//       SI.clickModal("//*[@id=\"CybotCookiebotDialogBodyButtonAccept\"]");
//       Thread.sleep(3000);
//       SI.searchPhrase("main-navigation-desktop");
//       SI.searchType(2);
       
       FI.createFile("./", "BackThenIDidntKnowWhy", ".csv");
    }
    

}
