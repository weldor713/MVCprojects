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
public class ByZip {
    @RequestMapping(value={"/byzip"}, method = RequestMethod.GET)
    public String displayByZipPage() {
        return "byzip";
    }
    
}
