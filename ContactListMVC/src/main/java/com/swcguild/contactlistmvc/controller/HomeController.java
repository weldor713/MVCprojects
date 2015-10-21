/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
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

    private ContactListDao dao;

    @Inject
    public HomeController(ContactListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)

    @ResponseBody
    public Contact getContact(@PathVariable("id") int id) {
// retrieve the Contact associated with the given id and return it
        return dao.getContactById(id);

    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Contact createContact(@Valid @RequestBody Contact contact) {
// persist the incoming contact
        dao.addContact(contact);
// The addContact call to the dao assigned a contactId to the incoming
// Contact and set that value on the object. Now we return the updated
// object to the caller.
        return contact;
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") int id) {
// remove the Contact associated with the given id from the data layer
        dao.removeContact(id);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putContact(@PathVariable("id") int id, @RequestBody Contact contact) {
// set the value of the PathVariable id on the incoming Contact object
// to ensure that a) the contact id is set on the object and b) that
// the value of the PathVariable id and the Contact object id are the
// same.
        contact.setContactId(id);
// update the contact
        dao.updateContact(contact);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getAllContacts() {
// get all of the Contacts from the data layer
        return dao.getAllContacts();
    }

}
