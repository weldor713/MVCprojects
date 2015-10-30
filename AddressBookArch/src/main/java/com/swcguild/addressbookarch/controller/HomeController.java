/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookarch.controller;

import com.swcguild.addressbookarch.dao.AddressBookDao;
import com.swcguild.addressbookarch.model.Address;
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

@Controller
/**
 *
 * @author apprentice
 */
public class HomeController {

    private AddressBookDao dao;

    @Inject
    public HomeController(AddressBookDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)

    @ResponseBody
    public Address getAddress(@PathVariable("id") int id) {
// retrieve the Address associated with the given id and return it
        return dao.getAddressById(id);

    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Address createAddress(@Valid @RequestBody Address address) {
// persist the incoming address
        dao.addAddress(address);
// The addAddress call to the dao assigned a addressId to the incoming
// Address and set that value on the object. Now we return the updated
// object to the caller.
        return address;
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable("id") int id) {
// remove the Address associated with the given id from the data layer
        dao.removeAddress(id);
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putAddress(@PathVariable("id") int id, @RequestBody Address address) {
// set the value of the PathVariable id on the incoming Address object
// to ensure that a) the address id is set on the object and b) that
// the value of the PathVariable id and the Address object id are the
// same.
        address.setAddressId(id);
// update the address
        dao.updateAddress(address);
    }

    @RequestMapping(value = "/addresss", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAllAddresss() {
// get all of the Addresss from the data layer
        return dao.getAllAddresss();
    }

    // This method will be invoked by Spring MVC when it sees a request for
// ContactListMVC/mainAjaxPage.
    @RequestMapping(value = {"/mainAjaxPage"}, method = RequestMethod.GET)
    public String displayMainAjaxPage() {
// This method does nothing except return the logical name of the
// view component (/jsp/home.jsp) that should be invoked in response
// to this request.
        return "mainAjaxPage";
    }

}
