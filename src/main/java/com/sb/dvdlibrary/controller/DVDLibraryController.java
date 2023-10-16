/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sb.dvdlibrary.controller;

import com.sb.dvdlibrary.dao.DVDLibraryDao;
import com.sb.dvdlibrary.dao.DVDLibraryDaoException;
import com.sb.dvdlibrary.dto.DVD;
import com.sb.dvdlibrary.ui.DVDLibraryView;
import java.util.List;
/**
 *
 * @author sebas
 */
public class DVDLibraryController {
    private DVDLibraryView view;
    private DVDLibraryDao dao;
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view)
    {
        this.dao = dao;
        this.view = view;
    }
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1 -> listDvds();
                    case 2 -> createDvd();
                    case 3 -> deleteDvd();
                    case 4 -> changeDvd();
                    case 5 -> viewDvd();
                    case 6 -> searchDvd();
                    case 7 -> keepGoing = false;
                    default -> unknownCommand();
                }

            }
            exitMessage();
        }catch(DVDLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
 
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void createDvd() throws DVDLibraryDaoException  {
        boolean keepGoing = true;
        do{
            view.displayCreateDvdBanner();
            DVD newDVD = view.getNewDvdInfo();
            dao.addDvd(newDVD.getTitle(), newDVD);
            view.displayCreateSuccessBanner();
            keepGoing = view.askToContinue("add a DVD");
        }while(keepGoing);
    }
    
    private void listDvds() throws DVDLibraryDaoException  {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }
    
    private void viewDvd() throws DVDLibraryDaoException  {
        view.displayDisplayDvdBanner();
        String title = view.getDvdChoice();
        DVD dvd = dao.getDvdInfo(title);
        view.displayDvd(dvd);

    }
    
    private void searchDvd() throws DVDLibraryDaoException {
        view.displaySearchDvdBanner();
        String title = view.getDvdChoice();
        List<DVD> foundDvds = dao.getAllDvds(title);
        view.displayDvdList(foundDvds);
    }

    private void deleteDvd() throws DVDLibraryDaoException  {
        boolean keepGoing = true;
        do{
            view.displayRemoveDvdBanner();
            String title = view.getDvdChoice();
            DVD removedDvd = dao.removeDvd(title);
            view.displayRemoveResult(removedDvd); 
            keepGoing = view.askToContinue("delete a DVD");
        }while(keepGoing);
    }
    
    private void changeDvd() throws DVDLibraryDaoException {
        boolean keepGoing = true;
        do{
            view.displayUpdateDvdBanner();
            String title = view.getDvdChoice();
            DVD prevDvd = dao.getDvdInfo(title);
            view.updateDvdInfo(prevDvd);
            keepGoing = view.askToContinue("update a DVD");
        }while(keepGoing);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
