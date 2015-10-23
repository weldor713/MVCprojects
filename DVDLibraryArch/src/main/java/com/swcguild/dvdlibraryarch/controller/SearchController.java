/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryarch.controller;

import com.swcguild.dvdlibraryarch.dao.DvdListDao;
import com.swcguild.dvdlibraryarch.dao.SearchTerm;
import com.swcguild.dvdlibraryarch.model.Dvd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author AGallagher
 */
@Controller
public class SearchController {
    private DvdListDao dao;

    @Inject
    public SearchController(DvdListDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/search",method=RequestMethod.GET)
    public String displaySearchPage () {
        return "search";
    }
    
     @RequestMapping(value = "search/dvds", method = RequestMethod.POST)
    @ResponseBody
    public List<Dvd> searchDvds(@RequestBody Map<String, String> searchMap) {
// Create the map of search criteria to send to the DAO
        Map<SearchTerm, String> criteriaMap = new HashMap<>();
// Determine which search terms have values, translate the String
// keys into SearchTerm enums, and set the corresponding values
// appropriately.
        String currentTerm = searchMap.get("title");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.TITLE, currentTerm);
        }
        currentTerm = searchMap.get("director");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.DIRECTOR, currentTerm);
        }
        currentTerm = searchMap.get("releasedate");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.RELEASEDATE, currentTerm);
        }
        currentTerm = searchMap.get("mpaarating");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.MPAARATING, currentTerm);
        }
        currentTerm = searchMap.get("studio");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STUDIO, currentTerm);
        }
        return dao.searchDvds(criteriaMap);
    }
    
}
   
    