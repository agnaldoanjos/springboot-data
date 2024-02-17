package com.home.examples;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    private final JdbcTemplate jdbcTemplate;


    public SampleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(UserDto user) {
        int rowsInserted = jdbcTemplate.update("insert into user_entity (first_name,last_name) values (?, ?)", user.getFirstName(), user.getLastName());
        System.out.println("Number of rows updated = " + rowsInserted);
    }

    public void update(UserDto user) {
        int rowsInserted = jdbcTemplate.update("update user_entity set first_name = ?, last_name = ? where id = ?", user.getFirstName(), user.getLastName(), user.getId());
        System.out.println("Number of rows updated = " + rowsInserted);
    }

    public void delete(UserDto user) {
        int rowsDeleted = jdbcTemplate.update("delete from user_entity where id = ?", user.getId());
        System.out.println("Number of rows deleted = " + rowsDeleted);

    }


    public UserDto queryUserById(Integer id) {

        UserDto user = jdbcTemplate.queryForObject("select * from user_entity where id=?", (resultSet, i) -> {
            UserDto userDto = new UserDto();
            userDto.setId(resultSet.getInt("id"));
            userDto.setFirstName(resultSet.getString("first_name"));
            userDto.setLastName(resultSet.getString("last_name"));
            return userDto;
        }, id);
        System.out.println(user);
        return user;
    }

    public List<UserDto> queryFromDatabase(int idLessThan) {

        return jdbcTemplate.query("select id,first_name,last_name from user_entity where id<? order by id", preparedStatement -> preparedStatement.setInt(1, idLessThan), (resultSet, i) -> {
            UserDto userDto = new UserDto();
            userDto.setId(resultSet.getInt("id"));
            userDto.setFirstName(resultSet.getString("first_name"));
            userDto.setLastName(resultSet.getString("last_name"));
            return userDto;
        });

    }
}
