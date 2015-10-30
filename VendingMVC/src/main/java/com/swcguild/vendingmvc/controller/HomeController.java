/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmvc.controller;

import com.swcguild.vendingmvc.dao.VendDao;
import com.swcguild.vendingmvc.model.Item;
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

    @RequestMapping(value = "/check/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item checkItem(@PathVariable("id") int id) {
// retrieve the Item associated with the given id and return it
        Item vItem = dao.getItemById(id);
        return vItem;
    }
    
    @RequestMapping(value = "/vend/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item vendItem(@PathVariable("id") int id) {
        Item vItem = dao.getItemById(id);
        int qty = vItem.getQty();
        qty = qty-1;
        vItem.setQty(qty);
        dao.updateItem(vItem);
        return dao.getItemById(id);
    }

    @RequestMapping(value = "/vend", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Item createItem(@Valid @RequestBody Item item) {
        // persist the incoming item
        dao.addItem(item);
// The addItem call to the dao assigned a itemId to the incoming // Item and set that value on the object. Now we return the updated // object to the caller.
        return item;
    }

//    @RequestMapping(value = "/vend/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void vendItem(@PathVariable("id") int id) {
//// remove the Item associated with the given id from the data layer
//        dao.updateItem(id);
//    }

//    @RequestMapping(value = "/vend/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void putItem(@PathVariable("id") int id, @RequestBody Item item) {
//// set the value of the PathVariable id on the incoming Dvd object
//// to ensure that a) the item id is set on the object and b) that
//// the value of the PathVariable id and the Dvd object id are the
//// same.
//        item.setItemId(id);
//// update the item
//        dao.updateItem(item);
//    }

    @RequestMapping(value = "/vending", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getAllItems() {
// get all of the Dvds from the data layer
        return dao.getAllItems();
    }

}