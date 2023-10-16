/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sb.dvdlibrary.ui;

/**
 *
 * @author sebas
 */
import com.sb.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author bryas
 */
public class DVDLibraryView {
    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List All DVDs");
        io.print("2. Add a DVD");
        io.print("3. Remove a DVD");
        io.print("4. Update DVD information");
        io.print("5. Display DVD information");
        io.print("6. Find DVD by title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    public DVD getNewDvdInfo(){
        String title = io.readString("Please enter the DVD title");
        String releaseDate = io.readString("Please enter the DVD release date");
        String mpaaRating = io.readString("Please enter the MPAA rating of the DVD");
        String directorName = io.readString("Please enter the director's name");
        String studio = io.readString("Please enter the studio of the movie");
        String userRateComment = io.readString("Please enter your rating and review of the DVD");
        DVD currentDVD = new DVD(title);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setUserRateComment(userRateComment);
        return currentDVD;
        
    }
    
        
    public void displayCreateSuccessBanner() {
       io.readString(
            "DVD successfully added.  Please hit enter to continue");
    }
    
    public void displayCreateDvdBanner() {
        io.print("=== Add DVD ===");
    }
    
    public void displayDvdList(List<DVD> dvdList) {
        for (DVD currentDvd : dvdList) {
            String dvdInfo = String.format("#%s : %s",
                  currentDvd.getTitle(),
                  currentDvd.getReleaseDate());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDisplayDvdBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDvdChoice() {
        return io.readString("Please enter the DVD title to retrieve all info.");
    }

    public void displayDvd(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getUserRateComment());                                  
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displaySearchDvdBanner() {
        io.print("=== Search DVDs  by Title===");    
    }
    
    public void displayRemoveDvdBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvdRecord) {
        if(dvdRecord != null){
          io.print("DVD successfully removed.");
        }else{
          io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayUpdateDvdBanner() {
        io.print("=== Update DVD ===");
    }

    public void updateDvdInfo(DVD prevDvd) {
        boolean keepGoing = true;
        int choice = 0;
        io.print(prevDvd.getTitle());
        while(keepGoing){    
            choice = printUpdateMenuAndGetSelection();
            switch (choice) {
                case 1:
                    prevDvd.setReleaseDate(getNewValue("release date"));
                    break;
                case 2:
                    prevDvd.setDirectorName(getNewValue("director's name"));
                    break;
                case 3:
                    prevDvd.setMpaaRating(getNewValue("MPAA rating"));
                    break;
                case 4:
                    prevDvd.setStudio(getNewValue("studio"));
                    break;
                case 5:
                    prevDvd.setUserRateComment(getNewValue("user rating and comments"));
                    break;
                case 6:
                    keepGoing = false;
                    break;                    
                default:
                    io.print("UNKNOWN COMMAND");
            }
            
        }
    }
    private int printUpdateMenuAndGetSelection(){
        io.print("Update Menu");
        io.print("1. Update release date");
        io.print("2. Update director's name");
        io.print("3. Update MPAA rating");
        io.print("4. Update studio");
        io.print("5. Update user rating and comments");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices.", 1, 7);

    }
    private String getNewValue(String choice){
        return io.readString("What would you like to change the " +choice+ " to?");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public boolean askToContinue(String type){
        boolean notDone = false;
        int choice = io.readInt("Would you like to "+ type + " again. Enter 1 for yes and 2 for no");
        switch(choice){
            case 1:
                notDone = true;
                break;
            case 2:
            default:
                break;
                
        }
        return notDone;
    }   
}
