/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sb.dvdlibrary.dao;

/**
 *
 * @author sebas
 */
public class DVDLibraryDaoException extends Exception{
    public DVDLibraryDaoException(String message) {
        super(message);
    }
    
    public DVDLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    } 
}
