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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.wwwandapps.damkalanfinalproject.model.Userandteam;

@Repository
public class UserandteamDaoImplementation implements UserandteamDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Userandteam findById(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String sql = "Select  s.id as id ,s.first_name as firstName, s.email as email,s.city as city ,d.fullname as fullname, s.nbateamid as nbateamid from User s left join Nbateam d on s.nbateamid=d.id WHERE s.id=:id";
        Userandteam result = null;
        try {
            result = namedParameterJdbcTemplate
                    .queryForObject(sql, params, new UserandteamMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }
        return result;
    }

    @Override
    public List<Userandteam> findAll() {
        String sql = "Select  s.id as id ,s.first_name as firstName, s.email as email,s.city as city ,d.fullname as fullname, s.nbateamid as nbateamid from User as s left join Nbateam d on s.nbateamid=d.id";
        List<Userandteam> result = namedParameterJdbcTemplate.query(sql, new UserandteamMapper());
        System.out.println(result.size());
        return result;
    }

    public List<Userandteam> findAllwithcommonteam(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String sql = "Select  s.id as id ,s.first_name as firstName, s.email as email,s.city as city ,d.fullname as fullname, s.nbateamid as nbateamid from User s left join Nbateam d on s.nbateamid=d.id WHERE s.nbateamid=:id";
        List<Userandteam> result = null;
        try {
            result = namedParameterJdbcTemplate
                    .query(sql, params, new UserandteamMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }
        System.out.println(result.size());
        return result;
    }

    @Override
    public void save(Userandteam userandteam) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO USER(id, first_name, email, city, nbateamid) "
                + "VALUES ( :id, :firstName, :email, :city, :nbateamid)";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(userandteam), keyHolder);
        userandteam.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Userandteam userandteam) {
        String sql = "UPDATE USER SET  first_name=:firstName, email=:email, "
                + "city=:city, nbateamid=:nbateamid  WHERE id=:id";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(userandteam));
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM USER WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }

    private SqlParameterSource getSqlParameterByModel(Userandteam userandteam) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", userandteam.getId());
        paramSource.addValue("firstName", userandteam.getFirstName());
        paramSource.addValue("email", userandteam.getEmail());
        paramSource.addValue("fullname", userandteam.getNbateamid());
        paramSource.addValue("city", userandteam.getCity());
        paramSource.addValue("nbateamid", userandteam.getNbateamid());
        return paramSource;
    }


    private static final class UserandteamMapper implements RowMapper<Userandteam> {

        public Userandteam mapRow(ResultSet rs, int rowNum) throws SQLException {
            Userandteam userandteam = new Userandteam();
            userandteam.setId(rs.getLong("id"));
            userandteam.setFirstName(rs.getString("firstName"));
            userandteam.setEmail(rs.getString("email"));
            userandteam.setTeamname(rs.getString("fullname"));
            userandteam.setCity(rs.getString("city"));
            userandteam.setNbateamid(rs.getLong("nbateamid"));
            return userandteam;
        }
    }
}