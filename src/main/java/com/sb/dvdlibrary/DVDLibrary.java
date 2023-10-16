/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sb.dvdlibrary;

/**
 *
 * @author sebas
 */
import com.sb.dvdlibrary.controller.DVDLibraryController;
import com.sb.dvdlibrary.dao.*;
import com.sb.dvdlibrary.ui.*;


/**
 *
 * @author bryas
 */
public class DVDLibrary {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}
