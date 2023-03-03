package com.example.pafassessment.repository;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.example.pafassessment.model.Userdata;

@Repository
public class AccountsRepository {
    
    @Autowired
    JdbcTemplate template;

    private final String SQL_SELECT_ALL_NAMES = "SELECT * FROM ACCOUNTS";
    private final String SQL_GET_BALANCE_BY_NAME = "select balance from accounts where first_name = ?";
    private final String SQL_GET_NAME_WITH_ID = 
                            "select CONCAT(first_name, ' (', account_id, ')') as account from accounts";
    private final String SQL_UPDATE_BALANCE_BY_NAME = "UPDATE accounts set balance = ? where first_name = ?";
    
    public List<Userdata> getAllNames() {
        
        List<Userdata> names = new LinkedList<>();

        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_ALL_NAMES);

        while(rs.next()){
            names.add(Userdata.fromSQL(rs));
        }
        return names;
    }

    public List<String> getNameWithId() {
        

        //can't seem to use SQL_GET_NAME_WITH_ID, keep getting invalid column name :'(
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_ALL_NAMES);

        List<String> names = new LinkedList<>();
        while(rs.next()) {
        names.add(rs.getString("first_name"));
        }
        
        return names;
    }

    public BigDecimal GetAmount() {

        //using (SQL_GET_BALANCE_BY_NAME) to get user1 balance
        //using (SQL_GET_BALANCE_BY_NAME) to get user2 balance
        //deduct
        //if negative, return error

        return null;

    }
}
