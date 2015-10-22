/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryarch.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Dvd {

    private int dvdId;
    private String title;
    private String director;
    private String releasedate;
    private String mpaarating;
    private String studio;


    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getMpaarating() {
        return mpaarating;
    }

    public void setMpaarating(String mpaarating) {
        this.mpaarating = mpaarating;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.dvdId;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.director);
        hash = 37 * hash + Objects.hashCode(this.releasedate);
        hash = 37 * hash + Objects.hashCode(this.mpaarating);
        hash = 37 * hash + Objects.hashCode(this.studio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (this.dvdId != other.dvdId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.releasedate, other.releasedate)) {
            return false;
        }
        if (!Objects.equals(this.mpaarating, other.mpaarating)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        return true;
    }
}