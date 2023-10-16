/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sb.dvdlibrary.dao;

import com.sb.dvdlibrary.dto.DVD;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author sebas
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
  private Map<String, DVD> dvds = new HashMap<>();
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDvd(String title, DVD dvd) throws DVDLibraryDaoException {
        loadLibrary();
        DVD prevDVD = dvds.put(title, dvd);
        writeLibrary();
        return prevDVD;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DVD> getAllDvds() throws DVDLibraryDaoException  {
        loadLibrary();
        return new ArrayList<>(dvds.values()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DVD getDvdInfo(String title) throws DVDLibraryDaoException   {
        loadLibrary();
        return dvds.get(title); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DVD removeDvd(String title) throws DVDLibraryDaoException   {
        loadLibrary();
        DVD removedDvd = dvds.remove(title);
        writeLibrary();
        return removedDvd; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




    @Override
    public List<DVD> getAllDvds(String title) throws DVDLibraryDaoException    {
        loadLibrary();
        List<DVD> tmpDvd = new ArrayList<>();
        for(String key : dvds.keySet())
        {
           if((key.toLowerCase()).contains(title.toLowerCase()))
               tmpDvd.add(dvds.get(key));
        }
        return tmpDvd;
    }
    
    private DVD unmarshallDvd(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        DVD dvdFromFile = new DVD(title);
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        dvdFromFile.setMpaaRating(dvdTokens[2]);

        dvdFromFile.setDirectorName(dvdTokens[3]);

        // We have now created a DVD! Return it!
        dvdFromFile.setStudio(dvdTokens[4]);
        
        dvdFromFile.setUserRateComment(dvdTokens[5]);


        return dvdFromFile;


    }
    
    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load DVD library data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent student unmarshalled
        DVD currentDvd;
        // Go through LIBRARY_FILE line by line, decoding each line into a 
        // DVD object by calling the unmarshallDvd method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();

            currentDvd = unmarshallDvd(currentLine);

            // We are going to use the title as the map key for our DVD object.
            // Put currentDvd into the map using title as the key
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }
    
    private String marshallDvd(DVD aDvd){
        String dvdAsText = aDvd.getTitle() + DELIMITER;

        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        dvdAsText += aDvd.getMpaaRating() + DELIMITER;

        dvdAsText += aDvd.getDirectorName() + DELIMITER;
        
        dvdAsText += aDvd.getStudio() + DELIMITER;
        
        dvdAsText += aDvd.getUserRateComment();

        // We have now turned a DVD to text! Return it!
        return dvdAsText;
    }
    
    private void writeLibrary() throws DVDLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save DVD data.", e);
        }


        String dvdAsText;
        List<DVD> dvdList = this.getAllDvds();
        for (DVD currentDvd : dvdList) {
            
            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        // Clean up
        out.close();
    }   
}
