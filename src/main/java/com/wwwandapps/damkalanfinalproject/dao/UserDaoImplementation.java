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

import com.wwwandapps.damkalanfinalproject.model.User;

@Repository
public class UserDaoImplementation implements UserDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User findById(Long id) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String sql = "SELECT * FROM user WHERE id=:id";
        User result = null;
        try {
            result = namedParameterJdbcTemplate
                    .queryForObject(sql, params, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());
        return result;
    }

    @Override
    public void save(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO USER(id, first_name, email, city, nbateamid) "
                + "VALUES ( :id, :firstName, :email, :city, :nbateamid)";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);
        user.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE USER SET  first_name=:firstName, email=:email, "
                + "city=:city, nbateamid=:nbateamid  WHERE id=:id";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM USER WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }

    private SqlParameterSource getSqlParameterByModel(User user) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", user.getId());
        paramSource.addValue("first_name", user.getFirstName());
        paramSource.addValue("email", user.getEmail());
        paramSource.addValue("city", user.getCity());
        paramSource.addValue("nbateamid", user.getTeam());
        return paramSource;
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setEmail(rs.getString("email"));
            user.setCity(rs.getString("city"));
            user.setTeam(rs.getInt("nbateamid"));
            return user;
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