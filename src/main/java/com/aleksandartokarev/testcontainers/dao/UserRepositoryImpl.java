package com.aleksandartokarev.testcontainers.dao;

import com.aleksandartokarev.testcontainers.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM users", new UserMapper());
    }

    @Override
    public Long createUser(User user) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("name", user.getName());

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update("INSERT INTO users(name) values (:name)", parameters, holder, new String[]{"id"});
        Long id = holder.getKey().longValue();
        return id;
    }

    @Override
    public User getUser(Long id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        List<User> users = namedParameterJdbcTemplate.query("SELECT * FROM users WHERE id = :id", parameters, new UserMapper());
        if (users.size() != 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        namedParameterJdbcTemplate.update("DELETE FROM users WHERE id = :id", parameters);
    }


    public class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            return user;
        }
    }
}
