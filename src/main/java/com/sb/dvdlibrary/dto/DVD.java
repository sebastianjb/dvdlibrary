/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sb.dvdlibrary.dto;

/**
 *
 * @author sebas
 */
public class DVD {
    String title;
    String releaseDate;
    String mpaaRating;
    String directorName;
    String studio;
    String userRateComment;

    public DVD(String title) {
        this.title = title; 
    }

    public String getTitle() {
        return title;
    }



    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRateComment() {
        return userRateComment;
    }

    public void setUserRateComment(String userRateComment) {
        this.userRateComment = userRateComment;
    }
    
}
