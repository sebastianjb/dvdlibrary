/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sb.dvdlibrary.dao;

import com.sb.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author sebas
 */
public interface DVDLibraryDao {
    
    DVD addDvd(String title, DVD dvd) throws DVDLibraryDaoException ;
    
    List<DVD> getAllDvds() throws DVDLibraryDaoException;
    
    List<DVD> getAllDvds(String title) throws DVDLibraryDaoException;
    
    DVD getDvdInfo(String title) throws DVDLibraryDaoException;
    
    DVD removeDvd(String title) throws DVDLibraryDaoException;
       
}
