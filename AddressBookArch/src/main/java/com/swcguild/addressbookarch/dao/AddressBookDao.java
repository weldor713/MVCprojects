/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookarch.dao;

import com.swcguild.addressbookarch.model.Address;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface AddressBookDao {
    
  // add the given Address to the data store

    public Address addAddress(Address address);
// remove the Address with the given id from the data store

    public void removeAddress(int addressId);
// update the given Address in the data store

    public void updateAddress(Address address);
// retrieve all Addresss from the data store

    public List<Address> getAllAddresss();
// retrieve the Address with the given id from the data store

    public Address getAddressById(int addressId);
// search for Addresss by the given search criteria values

    public List<Address> searchAddresss(Map<SearchTerm, String> criteria);
}
