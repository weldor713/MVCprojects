/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryarch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author AGallagher
 */
@Controller
public class SearchController {
    @RequestMapping(value="/search",method=RequestMethod.GET)
    public String displaySearchPage () {
        return "search";
    }
    
}