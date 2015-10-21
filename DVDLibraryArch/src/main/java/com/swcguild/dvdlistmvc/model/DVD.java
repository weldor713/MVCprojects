/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlistmvc.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class DVD {

    private int contactId;
    private String title;
    private String director;
    private String releasedate;
    private String studio;
    private String mpaarating;

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
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

    public String getReleaseDate() {
        return releasedate;
    }

    public void setReleaseDate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getMpaaRating() {
        return mpaarating;
    }

    public void setMpaaRating(String mpaarating) {
        this.mpaarating = mpaarating;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.contactId;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.director);
        hash = 37 * hash + Objects.hashCode(this.releasedate);
        hash = 37 * hash + Objects.hashCode(this.studio);
        hash = 37 * hash + Objects.hashCode(this.mpaarating);
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
        final DVD other = (DVD) obj;
        if (this.contactId != other.contactId) {
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
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.mpaarating, other.mpaarating)) {
            return false;
        }
        return true;
    }
}