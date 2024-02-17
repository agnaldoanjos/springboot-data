package br.home.jdbc.demojdbc.persistence.impl;

import br.home.jdbc.demojdbc.persistence.PersonSpec;
import br.home.jdbc.demojdbc.persistence.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class PersonImpl implements PersonSpec {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Person> findAll() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return jdbcTemplate.query("SELECT ID, NAME, BORN_DATE FROM PERSON", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Person.builder()
                        .id(rs.getInt("ID"))
                        .name(rs.getString("NAME"))
                        .bornDate(LocalDate.parse(rs.getString("BORN_DATE"), formatter))
                        .build();
            }
        });
    }
}
