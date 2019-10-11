package org.improving.tag.database;

import org.improving.tag.Exit;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExitDAO {

    private final JdbcTemplate jdbcTemplate;

    public ExitDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Exit> findExitsByOriginId(int id) {
        try {
            List<Exit> exits = jdbcTemplate.query("select * from location as l left join locationexit as e on l" +
                            ".Id = e.OriginId where e.OriginId = " + id,
                    (result, rowNum) -> {
                        Exit exit = new Exit();
                        exit.setId(result.getInt("Id"));
                        exit.setName(result.getString("Name"));
                        return exit;
                    });
            return exits;
        } catch (DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }
}
