package com.wwwandapps.damkalanfinalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
 }