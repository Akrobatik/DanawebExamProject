package Implementations;

import Interfaces.FileInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


// @author Lasse
 
public class FileInterfaceIMPL implements FileInterface{

    public FileInterfaceIMPL() {
        System.out.println("COME ON!!");
    }
    

    @Override
    public void openFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeToFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readFrom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createFile(String path, String name, String extension) {
        
        File file = new File(path + name + extension);
        boolean fileCreated = false;
        
        try {
            fileCreated = file.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error while creating empty file: " + ex);
        }
        
        if (fileCreated) {
            System.out.println("Created empty file: " + file.getPath());
        } else {
            System.out.println("Failed to create empty file: " + file.getPath());
        }

        
    }

}
