/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookarch.dao;

import com.swcguild.addressbookarch.model.Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoTest {

    private AddressBookDao dao;

    public AddressBookDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("addressbookDao", AddressBookDao.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteAddress() {
// create new address
        Address nc = new Address();
        nc.setFirstName("John");
        nc.setLastName("Doe");
        nc.setAddress("Oracle");
        nc.setCity("john@doe.com");
        nc.setState("john@doe.com");
        nc.setZip("1234445678");
        dao.addAddress(nc);
        Address fromDb = dao.getAddressById(nc.getAddressId());
        assertEquals(fromDb, nc);
        dao.removeAddress(nc.getAddressId());
        assertNull(dao.getAddressById(nc.getAddressId()));
    }

    @Test
    public void addUpdateAddress() {
// create new address
        Address nc = new Address();
        nc.setFirstName("Jimmy");
        nc.setLastName("Smith");
        nc.setAddress("Sun");
        nc.setCity("jimmy@smith.com");
        nc.setState("1112223333");
        nc.setZip("1112223333");
        dao.addAddress(nc);
        nc.setZip("9999999999");
        dao.updateAddress(nc);
        Address fromDb = dao.getAddressById(nc.getAddressId());
        assertEquals(fromDb, nc);
    }

    @Test
    public void getAllAddresss() {
// create new address
        Address nc = new Address();
        nc.setFirstName("Jimmy");
        nc.setLastName("Smith");
        nc.setAddress("Sun");
        nc.setCity("jimmy@smith.com");
        nc.setState("1112223333");
        nc.setZip("1112223333");
        dao.addAddress(nc);
// create new address
        Address nc2 = new Address();
        nc2.setFirstName("John");
        nc2.setLastName("Jones");
        nc2.setAddress("Apple");
        nc2.setCity("john@jones.com");
        nc2.setState("john@jones.com");
        nc2.setZip("5556667777");
        dao.addAddress(nc2);
        List<Address> cList = dao.getAllAddresss();
        assertEquals(cList.size(), 2);
    }

    @Test
    public void searchByCity() {
// create new address
        Address nc = new Address();
        nc.setFirstName("Jimmy");
        nc.setLastName("Smith");
        nc.setAddress("Sun");
        nc.setCity("jimmy@smith.com");
        nc.setState("jimmy@smith.com");
        nc.setZip("1112223333");
        dao.addAddress(nc);
// create new address
        Address nc2 = new Address();
        nc2.setFirstName("John");
        nc2.setLastName("Jones");
        nc2.setAddress("Apple");
        nc2.setCity("john@jones.com");
        nc2.setState("john@jones.com");
        nc2.setZip("5556667777");
        dao.addAddress(nc2);
// create new address - same last name as first address but different
// company
        Address nc3 = new Address();
        nc3.setFirstName("Steve");
        nc3.setLastName("Smith");
        nc3.setAddress("Microsoft");
        nc3.setCity("steve@msft.com");
        nc3.setState("steve@msft.com");
        nc3.setZip("5552221234");
        dao.addAddress(nc3);
// Create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.CITY, "steve@msft.com");
        List<Address> cList = dao.searchByCity(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc3, cList.get(0));
        
    }
        @Test
    public void searchByLastName() {
// create new address
        Address nc = new Address();
        nc.setFirstName("Jimmy");
        nc.setLastName("Smith");
        nc.setAddress("Sun");
        nc.setCity("jimmy@smith.com");
        nc.setState("jimmy@smith.com");
        nc.setZip("1112223333");
        dao.addAddress(nc);
// create new address
        Address nc2 = new Address();
        nc2.setFirstName("John");
        nc2.setLastName("Jones");
        nc2.setAddress("Apple");
        nc2.setCity("john@jones.com");
        nc2.setState("john@jones.com");
        nc2.setZip("5556667777");
        dao.addAddress(nc2);
// create new address - same last name as first address but different
// company
        Address nc3 = new Address();
        nc3.setFirstName("Steve");
        nc3.setLastName("Smith");
        nc3.setAddress("Microsoft");
        nc3.setCity("steve@msft.com");
        nc3.setState("steve@msft.com");
        nc3.setZip("5552221234");
        dao.addAddress(nc3);
    
// New search criteria - look for Smith
        Map<SearchTerm, String> criteria = new HashMap<>();
        List<Address> cList = dao.searchByLastName(criteria);
        criteria.put(SearchTerm.LAST_NAME, "Smith");
        cList = dao.searchByLastName(criteria);
        assertEquals(2, cList.size());
    }
    
    
       @Test
    public void searchByState() {
// create new address
        Address nc = new Address();
        nc.setFirstName("Jimmy");
        nc.setLastName("Smith");
        nc.setAddress("Sun");
        nc.setCity("jimmy@smith.com");
        nc.setState("jimmy@smith.com");
        nc.setZip("1112223333");
        dao.addAddress(nc);
// create new address
        Address nc2 = new Address();
        nc2.setFirstName("John");
        nc2.setLastName("Jones");
        nc2.setAddress("Apple");
        nc2.setCity("john@jones.com");
        nc2.setState("john@jones.com");
        nc2.setZip("5556667777");
        dao.addAddress(nc2);
// create new address - same last name as first address but different
// company
        Address nc3 = new Address();
        nc3.setFirstName("Steve");
        nc3.setLastName("Smith");
        nc3.setAddress("Microsoft");
        nc3.setCity("steve@msft.com");
        nc3.setState("steve@msft.com");
        nc3.setZip("5552221234");
        dao.addAddress(nc3);
    
// New search criteria - look for Smith
        Map<SearchTerm, String> criteria = new HashMap<>();
        List<Address> cList = dao.searchByState(criteria);
        criteria.put(SearchTerm.STATE, "john@jones.com");
        cList = dao.searchByState(criteria);
        assertEquals(1, cList.size());
    }
    
    
  
         @Test
    public void searchByZip() {
// create new address
        Address nc = new Address();
        nc.setFirstName("Jimmy");
        nc.setLastName("Smith");
        nc.setAddress("Sun");
        nc.setCity("jimmy@smith.com");
        nc.setState("jimmy@smith.com");
        nc.setZip("1112223333");
        dao.addAddress(nc);
// create new address
        Address nc2 = new Address();
        nc2.setFirstName("John");
        nc2.setLastName("Jones");
        nc2.setAddress("Apple");
        nc2.setCity("john@jones.com");
        nc2.setState("john@jones.com");
        nc2.setZip("5556667777");
        dao.addAddress(nc2);
// create new address - same last name as first address but different
// company
        Address nc3 = new Address();
        nc3.setFirstName("Steve");
        nc3.setLastName("Smith");
        nc3.setAddress("Microsoft");
        nc3.setCity("steve@msft.com");
        nc3.setState("steve@msft.com");
        nc3.setZip("5552221234");
        dao.addAddress(nc3);
    
// New search criteria - look for Smith
        Map<SearchTerm, String> criteria = new HashMap<>();
        List<Address> cList = dao.searchByZip(criteria);
        criteria.put(SearchTerm.ZIP, "5552221234");
        cList = dao.searchByZip(criteria);
        assertEquals(1, cList.size());
    }
}


