/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryarch.dao;

import com.swcguild.dvdlibraryarch.model.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author parallels
 */
public class DvdListDaoDbImpl implements DvdListDao {
    
    private static final String SQL_INSERT_DVD = 
            "insert into dvds (title, director, releasedate, mpaarating, studio) values (?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE_DVD = 
            "delete from dvds where dvd_id = ?";
    
    private static final String SQL_SELECT_DVD = 
            "select * from dvds where dvd_id = ?";
    
    private static final String SQL_SELECT_ALL_DVDS = 
            "select * from dvds";
    
    private static final String SQL_UPDATE_DVD = 
            "update dvds set title = ?, director = ?, releasedate = ?, mpaarating = ?, studio = ? where dvd_id = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd addDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD, 
                dvd.getTitle(),
                dvd.getDirector(),
                dvd.getReleasedate(),
                dvd.getMpaarating(),
                dvd.getStudio());
        dvd.setDvdId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return dvd;
    }

    @Override
    public void removeDvd(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public void updateDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getTitle(),
                dvd.getDirector(),
                dvd.getReleasedate(),
                dvd.getMpaarating(),
                dvd.getStudio(),
                dvd.getDvdId());
    }

    @Override
    public List<Dvd> getAllDvds() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DvdMapper());
    }

    @Override
    public Dvd getDvdById(int dvdId) {
        try {
        return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), dvdId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria) {
        if (criteria.size() == 0) {
            return getAllDvds();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from dvds where ");
            
            // build the where clause
            int numParams = criteria.size();
            int paramPosition = 0;
            String[] paramVals = new String[numParams];
            
            Set<SearchTerm> keySet = criteria.keySet();
            Iterator<SearchTerm> iter = keySet.iterator();
            while(iter.hasNext()) {
                SearchTerm currentKey = iter.next();
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                
                sQuery.append(currentKey);
                sQuery.append(" = ? ");
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            
            return jdbcTemplate.query(sQuery.toString(), new DvdMapper(), paramVals);
        }
    }
    
    private static final class DvdMapper implements ParameterizedRowMapper<Dvd> {

        @Override
        public Dvd mapRow(ResultSet rs, int i) throws SQLException {
            Dvd dvd = new Dvd();
            dvd.setDvdId(rs.getInt("dvd_id"));
            dvd.setTitle(rs.getString("title"));
            dvd.setDirector(rs.getString("director"));
            dvd.setReleasedate(rs.getString("releasedate"));
            dvd.setMpaarating(rs.getString("mpaarating"));
            dvd.setStudio(rs.getString("studio"));
            return dvd;
        }
        
    }
    
}
