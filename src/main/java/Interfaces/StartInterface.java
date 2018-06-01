package Interfaces;

import java.util.ArrayList;


// @author Lasse

public interface StartInterface {
    
    public void setUrl(String Url);
    public void setDriver(int Driv, String Path); //Set Driver to 1 for Chrome, 2 for Firefox
    public void searchPhrase(String phrase);
    public void searchType(int type); 
    public void quit();
    public void clickModal(String xpath);
    public ArrayList<String> setResult ( String some);
    public ArrayList<String> getResult ();


}
