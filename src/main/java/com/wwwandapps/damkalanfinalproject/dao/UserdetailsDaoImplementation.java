package com.wwwandapps.damkalanfinalproject.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.wwwandapps.damkalanfinalproject.model.Userdetails;

@Repository
public class UserdetailsDaoImplementation implements UserdetailsDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Userdetails findById(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String sql = "Select  s.id as id ,s.first_name as firstName, s.email as email,s.city as city ,d.fullname as fullname, s.nbateamid as nbateamid from User s left join Nbateam d on s.nbateamid=d.id WHERE s.id=:id";
        Userdetails result = null;
        try {
            result = namedParameterJdbcTemplate
                    .queryForObject(sql, params, new UserdetailsMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }
        return result;
    }


    @Override
    public List<Userdetails> findAll() {
        String sql = "Select  s.id as id ,s.first_name as firstName, s.email as email,s.city as city ,d.fullname as fullname, s.nbateamid as nbateamid from User as s left join Nbateam d on s.nbateamid=d.id";
        List<Userdetails> result = namedParameterJdbcTemplate.query(sql, new UserdetailsMapper());
        return result;
    }

    @Override
    public void save(Userdetails userdetails) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO USER(id, first_name, email, city, nbateamid) "
                + "VALUES ( :id, :firstName, :email, :city, :nbateamid)";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(userdetails), keyHolder);
        userdetails.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Userdetails userdetails) {
        String sql = "UPDATE USER SET  first_name=:firstName, email=:email, "
                + "city=:city, nbateamid=:nbateamid  WHERE id=:id";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(userdetails));
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM USER WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }

    private SqlParameterSource getSqlParameterByModel(Userdetails userdetails) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", userdetails.getId());
        paramSource.addValue("firstName", userdetails.getFirstName());
        paramSource.addValue("email", userdetails.getEmail());
        paramSource.addValue("fullname", userdetails.getTeamname());
        paramSource.addValue("city", userdetails.getCity());
        paramSource.addValue("nbateamid", userdetails.getNbateamid());
        return paramSource;
    }


    private static final class UserdetailsMapper implements RowMapper<Userdetails> {

        public Userdetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            Userdetails userdetails = new Userdetails();
            userdetails.setId(rs.getLong("id"));
            userdetails.setFirstName(rs.getString("firstName"));
            userdetails.setEmail(rs.getString("email"));
            userdetails.setTeamname(rs.getString("fullname"));
            userdetails.setCity(rs.getString("city"));
            userdetails.setNbateamid(rs.getLong("nbateamid"));
            return userdetails;
        }
    }

    private static List<String> convertDelimitedStringToList(String delimitedString) {
        List<String> result = new ArrayList<String>();
        if (!StringUtils.isEmpty(delimitedString)) {
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
        }
        return result;
    }

    private String convertListToDelimitedString(List<String> list) {
        String result = "";
        if (list != null) {
            result = StringUtils.arrayToCommaDelimitedString(list.toArray());
        }
        return result;
    }

}