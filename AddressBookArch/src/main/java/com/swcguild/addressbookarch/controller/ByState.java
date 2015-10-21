/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookarch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

/**
 *
 * @author apprentice
 */
public class ByState {
    @RequestMapping(value={"/bystate"}, method = RequestMethod.GET)
    public String displayByStatePage() {
        return "bystate";
    }
    
}
