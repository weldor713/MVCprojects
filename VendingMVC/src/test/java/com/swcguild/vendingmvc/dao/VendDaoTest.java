/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmvc.dao;

import com.swcguild.vendingmvc.model.Item;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class VendDaoTest {
    
        private VendDao dao;
    
    public VendDaoTest() {
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
        dao = (VendDao) ctx.getBean("vendDaoDb");
// Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from item");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItem method, of class VendDao.
     */
//    @Test
//    public void testAddItem() {
//        System.out.println("addItem");
//        Item item = null;
//        VendDao instance = new VendDaoImpl();
//        Item expResult = null;
//        Item result = instance.addItem(item);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getItemById method, of class VendDao.
     */
//    @Test
//    public void testGetItemById() {
//        System.out.println("getItemById");
//        int id = 1;
//        VendDao instance = new VendDaoDbImpl();
//        Item expResult = new Item();
//        expResult.setName("Snickers");
//        Item result = instance.getItemById(id);
//        assertEquals(expResult.name, result.name);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllItems method, of class VendDao.
     */
//    @Test
//    public void testGetAllItems() {
//        System.out.println("getAllItems");
//        VendDao instance = new VendDaoImpl();
//        List<Item> expResult = null;
//        List<Item> result = instance.getAllItems();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of updateItem method, of class VendDao.
     */
//    @Test
//    public void testUpdateItem() {
//        System.out.println("updateItem");
//        Item item = null;
//        VendDao instance = new VendDaoImpl();
//        instance.updateItem(item);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }



