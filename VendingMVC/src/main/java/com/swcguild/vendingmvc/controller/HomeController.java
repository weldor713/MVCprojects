/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmvc.controller;

import com.swcguild.vendingmvc.dao.VendDao;
import com.swcguild.vendingmvc.model.Item;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {

    private VendDao dao;

    @Inject
    public HomeController(VendDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping(value = "/vend/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item getItem(@PathVariable("id") int id) {
// retrieve the Item associated with the given id and return it
        return dao.getItemById(id);
    }

    @RequestMapping(value = "/vend", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Item createItem(@Valid @RequestBody Item item) {
        // persist the incoming item
        dao.addItem(item);
// The addItem call to the dao assigned a dvdId to the incoming // Item and set that value on the object. Now we return the updated // object to the caller.
        return item;
    }

    @RequestMapping(value = "/vend/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void vendItem(@PathVariable("id") int id) {
// remove the Item associated with the given id from the data layer
        dao.removeItem(id);
    }

//    @RequestMapping(value = "/vend/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void putDvd(@PathVariable("id") int id, @RequestBody Dvd dvd) {
//// set the value of the PathVariable id on the incoming Dvd object
//// to ensure that a) the dvd id is set on the object and b) that
//// the value of the PathVariable id and the Dvd object id are the
//// same.
//        dvd.setDvdId(id);
//// update the dvd
//        dao.updateDvd(dvd);
//    }

//    @RequestMapping(value = "/dvds", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Dvd> getAllDvds() {
//// get all of the Dvds from the data layer
//        return dao.getAllDvds();
//    }

}