/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookarch.controller;

import com.swcguild.addressbookarch.dao.AddressBookDao;
import com.swcguild.addressbookarch.dao.SearchTerm;
import com.swcguild.addressbookarch.model.Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

/**
 *
 * @author apprentice
 */
public class ByZip {
    
      private AddressBookDao dao;

    @Inject
    public ByZip(AddressBookDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value={"/byzip"}, method = RequestMethod.GET)
    public String displayByZipPage() {
        return "byzip";
    }
    
       @RequestMapping(value = "byzip/address", method = RequestMethod.POST)
    @ResponseBody
    public List<Address> searchInZip(@RequestBody Map<String, String> searchMap) {
// Create the map of search criteria to send to the DAO
        Map<SearchTerm, String> criteriaMap = new HashMap<>();
// Determine which search terms have values, translate the String
// keys into SearchTerm enums, and set the corresponding values
// appropriately.
        String currentTerm = searchMap.get("zip");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.ZIP, currentTerm);
        }
       
        return dao.searchByZip(criteriaMap);
    }
}
