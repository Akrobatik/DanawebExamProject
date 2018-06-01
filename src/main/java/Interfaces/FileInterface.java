package Interfaces;


// @author Lasse

public interface FileInterface {
    
    public void createFile(String path, String name, String extension);
    public void openFile();
    public void writeToFile();
    public void closeFile();
    public void readFrom();
    
}
