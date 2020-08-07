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

import com.wwwandapps.damkalanfinalproject.model.Nbateam;

@Repository
public class NbateamDaoImplementation implements NbateamDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Nbateam findById(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "SELECT * FROM nbateam WHERE id=:id";
        Nbateam result = null;
        try {
            result = namedParameterJdbcTemplate
                    .queryForObject(sql, params, new NbateamMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }
        return result;
    }

    public Nbateam findByName(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);

        String sql = "SELECT * FROM nbateam WHERE name=:name";
        Nbateam result = null;
        try {
            result = namedParameterJdbcTemplate
                    .queryForObject(sql, params, new NbateamMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }
        return result;
    }

    @Override
    public List<Nbateam> findAll() {
        String sql = "SELECT * FROM nbateam";
        List<Nbateam> result = namedParameterJdbcTemplate.query(sql, new NbateamMapper());
        return result;
    }

    @Override
    public void save(Nbateam nbateam) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO NBATEAM(id, name, fullname, city, conference, division) "
                + "VALUES ( :id, :name, :fullname, :city, :conference, :division )";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(nbateam), keyHolder);
        nbateam.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Nbateam nbateam) {
        String sql = "UPDATE nbateam SET  name=:name, fullname=:fullname, "
                + "city=:city, conference=:conference, division=:division WHERE id=:id";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(nbateam));
    }

    @Override
    public void delete(Long id) {

        String sql = "DELETE FROM nbateam WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

    }


    @Override
    public void deleteall() {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        String sql = "DELETE FROM nbateam ";
        namedParameterJdbcTemplate.update(sql,paramSource );

    }

    private SqlParameterSource getSqlParameterByModel(Nbateam nbateam) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", nbateam.getId());
        paramSource.addValue("name", nbateam.getName());
        paramSource.addValue("fullname", nbateam.getFullname());
        paramSource.addValue("city", nbateam.getCity());
        paramSource.addValue("conference", nbateam.getConference());
        paramSource.addValue("division", nbateam.getDivision());
         return paramSource;
    }

    private static final class NbateamMapper implements RowMapper<Nbateam> {

        public Nbateam mapRow(ResultSet rs, int rowNum) throws SQLException {
            Nbateam nbateam = new Nbateam();
            nbateam.setId(rs.getLong("id"));
            nbateam.setName(rs.getString("name"));
            nbateam.setFullname(rs.getString("fullname"));
            nbateam.setCity(rs.getString("city"));
            nbateam.setConference(rs.getString("conference"));
            nbateam.setDivision(rs.getString("division"));
            return nbateam;
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