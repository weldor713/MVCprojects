/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryarch.dao;

import com.swcguild.dvdlibraryarch.model.Dvd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DvdListDaoInMemImpl implements DvdListDao {
// holds all of our Dvd objects - simulates the database

    private Map<Integer, Dvd> dvdMap = new HashMap<>();
// used to assign ids to Dvds - simulates the auto increment
// primary key for Dvds in a database
    private static int dvdIdCounter = 0;

    @Override
    public Dvd addDvd(Dvd dvd) {
// assign the current counter values as the dvdid
        dvd.setDvdId(dvdIdCounter);
// increment the counter so it is ready for use for the next dvd
        dvdIdCounter++;
        dvdMap.put(dvd.getDvdId(), dvd);
        return dvd;
    }

    @Override
    public void removeDvd(int dvdId) {
        dvdMap.remove(dvdId);
    }

    @Override
    public void updateDvd(Dvd dvd) {
        dvdMap.put(dvd.getDvdId(), dvd);
    }

    @Override
    public List<Dvd> getAllDvds() {
        Collection<Dvd> c = dvdMap.values();
        return new ArrayList(c);
    }

    @Override
    public Dvd getDvdById(int dvdId) {
        return dvdMap.get(dvdId);
    }

    @Override
    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria) {
// Get all the search terms from the map
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String releasedateCriteria = criteria.get(SearchTerm.RELEASEDATE);
        String mpaaratingCriteria = criteria.get(SearchTerm.MPAARATING);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);

// Declare all the predicate conditions
        Predicate<Dvd> titleMatches;
        Predicate<Dvd> directorMatches;
        Predicate<Dvd> releasedateMatches;
        Predicate<Dvd> mpaaratingMatches;
        Predicate<Dvd> studioMatches;

// Placeholder predicate - always returns true. Used for search terms
// that are empty
        Predicate<Dvd> truePredicate = (c) -> {
            return true;
        };
// Assign values to predicates. If a given search term is empty, just
// assign the default truePredicate, otherwise assign the predicate that
// properly filters for the given term.
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getTitle().equals(titleCriteria);
        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getDirector().equals(directorCriteria);
        releasedateMatches = (releasedateCriteria == null || releasedateCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getReleasedate().equals(releasedateCriteria);
        mpaaratingMatches = (mpaaratingCriteria == null || mpaaratingCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getMpaarating().equals(mpaaratingCriteria);
        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getStudio().equals(studioCriteria);
// Return the list of Dvds that match the given criteria. To do this we
// just AND all the predicates together in a filter operation.
        return dvdMap.values().stream()
                .filter(titleMatches
                        .and(directorMatches)
                        .and(releasedateMatches)
                        .and(mpaaratingMatches)
                        .and(studioMatches))
                .collect(Collectors.toList());
    }
}
