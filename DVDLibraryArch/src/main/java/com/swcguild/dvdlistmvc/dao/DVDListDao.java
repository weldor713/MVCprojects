/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlistmvc.dao;

import com.swcguild.dvdlistmvc.model.DVD;
import java.util.List;
import java.util.Map;
/**
 *
 * @author apprentice
 */
public interface DVDListDao {
// add the given DVD to the data store

    public DVD addDVD(DVD dvd);
// remove the DVD with the given id from the data store

    public void removeDVD(int contactId);
// update the given DVD in the data store

    public void updateDVD(DVD dvd);
// retrieve all DVDs from the data store

    public List<DVD> getAllDVD();
// retrieve the DVD with the given id from the data store

    public DVD getDVDById(int contactId);
// search for DVDs by the given search criteria values

    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria);
}
