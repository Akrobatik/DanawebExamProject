package InterfaceSolution;


// @author Lasse

public interface StartInterface {
    
    public void setUrl(String Url);
    public void setDriver(int Driv, String Path); //Set Driv to 1 for Chrome, 2 for Firefox
    public void searchPhrase(String phrase);
    public void searchType(int type); 

}
