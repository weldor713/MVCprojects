/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryarch.dao;

import com.swcguild.dvdlibraryarch.model.Dvd;
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
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class DvdListDaoTest {

    private DvdListDao dao;

    public DvdListDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {// Ask Spring for my DAO
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (DvdListDao) ctx.getBean("dvdListDao");
// Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from dvds");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteDvd() {
// create new dvd
        Dvd nc = new Dvd();
        nc.setTitle("John");
        nc.setDirector("Doe");
        nc.setReleasedate("Oracle");
        nc.setMpaarating("john@doe.com");
        nc.setStudio("1234445678");
        dao.addDvd(nc);
        Dvd fromDb = dao.getDvdById(nc.getDvdId());
        assertEquals(fromDb, nc);
        dao.removeDvd(nc.getDvdId());
        assertNull(dao.getDvdById(nc.getDvdId()));
    }

    @Test
    public void addUpdateDvd() {
// create new dvd
        Dvd nc = new Dvd();
        nc.setTitle("Jimmy");
        nc.setDirector("Smith");
        nc.setReleasedate("Sun");
        nc.setMpaarating("jimmy@smith.com");
        nc.setStudio("1112223333");
        dao.addDvd(nc);
        nc.setStudio("9999999999");
        dao.updateDvd(nc);
        Dvd fromDb = dao.getDvdById(nc.getDvdId());
        assertEquals(fromDb, nc);
    }

    @Test
    public void getAllDvds() {
// create new dvd
        Dvd nc = new Dvd();
        nc.setTitle("Jimmy");
        nc.setDirector("Smith");
        nc.setReleasedate("Sun");
        nc.setMpaarating("jimmy@smith.com");
        nc.setStudio("1112223333");
        dao.addDvd(nc);
// create new dvd
        Dvd nc2 = new Dvd();
        nc2.setTitle("John");
        nc2.setDirector("Jones");
        nc2.setReleasedate("Apple");
        nc2.setMpaarating("john@jones.com");
        nc2.setStudio("5556667777");
        dao.addDvd(nc2);
        List<Dvd> cList = dao.getAllDvds();
        assertEquals(cList.size(), 2);
    }

    @Test
    public void searchDvds() {
// create new dvd
        Dvd nc = new Dvd();
        nc.setTitle("Jimmy");
        nc.setDirector("Smith");
        nc.setReleasedate("Sun");
        nc.setMpaarating("jimmy@smith.com");
        nc.setStudio("1112223333");
        dao.addDvd(nc);
// create new dvd
        Dvd nc2 = new Dvd();
        nc2.setTitle("John");
        nc2.setDirector("Jones");
        nc2.setReleasedate("Apple");
        nc2.setMpaarating("john@jones.com");
        nc2.setStudio("5556667777");
        dao.addDvd(nc2);
// create new dvd - same director as first dvd but different
// dvd
        Dvd nc3 = new Dvd();
        nc3.setTitle("Steve");
        nc3.setDirector("Smith");
        nc3.setReleasedate("Microsoft");
        nc3.setMpaarating("steve@msft.com");
        nc3.setStudio("5552221234");
        dao.addDvd(nc3);
// Create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.DIRECTOR, "Jones");
        List<Dvd> cList = dao.searchDvds(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc2, cList.get(0));
// New search criteria - look for Smith
        criteria.put(SearchTerm.DIRECTOR, "Smith");
        cList = dao.searchDvds(criteria);
        assertEquals(2, cList.size());
//// Add releasedate to search criteria
        criteria.put(SearchTerm.RELEASEDATE, "Sun");
        cList = dao.searchDvds(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc, cList.get(0));
// Change releasedate to Microsoft, should get back nc3
        criteria.put(SearchTerm.RELEASEDATE, "Microsoft");
        cList = dao.searchDvds(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc3, cList.get(0));
// Change releasedate to Apple, should get back nothing
        criteria.put(SearchTerm.RELEASEDATE, "Apple");
        cList = dao.searchDvds(criteria);
        assertEquals(0, cList.size());
    }
}
