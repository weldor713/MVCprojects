/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryarch.controller;

import com.swcguild.dvdlibraryarch.dao.DvdListDao;
import com.swcguild.dvdlibraryarch.model.Dvd;
import java.util.List;
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
 * @author AGallagher
 */
@Controller
public class HomeController {

    private DvdListDao dao;

    @Inject
    public HomeController(DvdListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Dvd getDvd(@PathVariable("id") int id) {
// retrieve the Dvd associated with the given id and return it
        return dao.getDvdById(id);
    }

    @RequestMapping(value = "/dvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Dvd createDvd(@Valid @RequestBody Dvd dvd) {
        // persist the incoming dvd
        dao.addDvd(dvd);
// The addDvd call to the dao assigned a dvdId to the incoming // Dvd and set that value on the object. Now we return the updated // object to the caller.
        return dvd;
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDvd(@PathVariable("id") int id) {
// remove the Dvd associated with the given id from the data layer
        dao.removeDvd(id);
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putDvd(@PathVariable("id") int id, @RequestBody Dvd dvd) {
// set the value of the PathVariable id on the incoming Dvd object
// to ensure that a) the dvd id is set on the object and b) that
// the value of the PathVariable id and the Dvd object id are the
// same.
        dvd.setDvdId(id);
// update the dvd
        dao.updateDvd(dvd);
    }

    @RequestMapping(value = "/dvds", method = RequestMethod.GET)
    @ResponseBody
    public List<Dvd> getAllDvds() {
// get all of the Dvds from the data layer
        return dao.getAllDvds();
    }

    // This method will be invoked by Spring MVC when it sees a request for
// DVDLibraryArch/mainAjaxPage.
    @RequestMapping(value = {"/mainAjaxPage"}, method = RequestMethod.GET)
    public String displayMainAjaxPage() {
// This method does nothing except return the logical name of the
// view component (/jsp/home.jsp) that should be invoked in response
// to this request.
        return "mainAjaxPage";
    }

}
