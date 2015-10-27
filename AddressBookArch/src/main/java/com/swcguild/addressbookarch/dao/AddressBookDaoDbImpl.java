/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookarch.dao;

import com.swcguild.addressbookarch.model.Address;
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
public class AddressBookDaoDbImpl implements AddressBookDao {
    
    private static final String SQL_INSERT_ADDRESS = 
            "insert into address (first_name, last_name, address, city, state, zip) values (?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE_ADDRESS = 
            "delete from address where address_id = ?";
    
    private static final String SQL_SELECT_ADDRESS = 
            "select * from address where address_id = ?";
    
    private static final String SQL_SELECT_ALL_ADDRESSS = 
            "select * from address";
    
    private static final String SQL_UPDATE_ADDRESS = 
            "update address set first_name = ?, last_name = ?, address = ?, city = ?, state = ?, zip = ? where address_id = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Address addAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS, 
                address.getFirstName(),
                address.getLastName(),
                address.getAddress(),
                address.getCity(),
                address.getState(),
                address.getZip());
        address.setAddressId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return address;
    }

    @Override
    public void removeAddress(int addressId) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, addressId);
    }

    @Override
    public void updateAddress(Address address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getFirstName(),  //here
                address.getLastName(),
                address.getAddress(),
                address.getCity(),
                address.getState(),
                address.getZip(),
                address.getAddressId());
    }

    @Override
    public List<Address> getAllAddresss() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ADDRESSS, new AddressMapper());
    }

    @Override
    public Address getAddressById(int addressId) {
        try {
        return jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS, new AddressMapper(), addressId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

//    @Override
//    public List<Address> searchAddresss(Map<SearchTerm, String> criteria) {
//        if (criteria.size() == 0) {
//            return getAllAddresss();
//        } else {
//            StringBuilder sQuery = new StringBuilder("select * from addresss where ");
//            
//            // build the where clause
//            int numParams = criteria.size();
//            int paramPosition = 0;
//            String[] paramVals = new String[numParams];
//            
//            Set<SearchTerm> keySet = criteria.keySet();
//            Iterator<SearchTerm> iter = keySet.iterator();
//            while(iter.hasNext()) {
//                SearchTerm currentKey = iter.next();
//                if (paramPosition > 0) {
//                    sQuery.append(" and ");
//                }
//                
//                sQuery.append(currentKey);
//                sQuery.append(" = ? ");
//                
//                paramVals[paramPosition] = criteria.get(currentKey);
//                paramPosition++;
//            }
//            
//            return jdbcTemplate.query(sQuery.toString(), new AddressMapper(), paramVals);
//        }
//    }

    @Override
    public List<Address> searchByCity(Map<SearchTerm, String> criteria) {
         if (criteria.size() == 0) {
            return getAllAddresss();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from address where city = ? ");
            
//             build the where clause
            int numParams = criteria.size();
            int paramPosition = 0;
            String[] paramVals = new String[1];
            
            Set<SearchTerm> keySet = criteria.keySet();
            Iterator<SearchTerm> iter = keySet.iterator();
            while(iter.hasNext()) {
                SearchTerm currentKey = iter.next();
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
           return jdbcTemplate.query(sQuery.toString(), new AddressMapper(), paramVals);
         }
            
            
        }
    


    @Override
    public List<Address> searchByLastName(Map<SearchTerm, String> criteria) {
            if (criteria.size() == 0) {
            return getAllAddresss();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from address where last_name = ? ");
            
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
                
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            
            return jdbcTemplate.query(sQuery.toString(), new AddressMapper(), paramVals);
        }
    }

    @Override
    public List<Address> searchByState(Map<SearchTerm, String> criteria) {
       if (criteria.size() == 0) {
            return getAllAddresss();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from address where state = ? ");
            
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
                
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            
            return jdbcTemplate.query(sQuery.toString(), new AddressMapper(), paramVals);
        }
    }

    @Override
    public List<Address> searchByZip(Map<SearchTerm, String> criteria) {
        if (criteria.size() == 0) {
            return getAllAddresss();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from address where zip = ? ");
            
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
                
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            
            return jdbcTemplate.query(sQuery.toString(), new AddressMapper(), paramVals);
        }
    }
    
    private static final class AddressMapper implements ParameterizedRowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {
            Address address = new Address();
            address.setAddressId(rs.getInt("address_id"));
            address.setFirstName(rs.getString("first_name"));
            address.setLastName(rs.getString("last_name"));
            address.setAddress(rs.getString("address"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZip(rs.getString("zip"));
            return address;
        }
        
    }
    
}
