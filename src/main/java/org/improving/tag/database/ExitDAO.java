package org.improving.tag.database;

import org.improving.tag.Exit;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ExitDAO {

    private final JdbcTemplate jdbcTemplate;
    private final LocationDAO locationDAO;

    public ExitDAO(JdbcTemplate jdbcTemplate, LocationDAO locationDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.locationDAO = locationDAO;
    }


    public List<Exit> findExitsByOriginId(int id) {
        try {
            List<Exit> exits = jdbcTemplate.query("SELECT * FROM exits WHERE OriginId = ?", new Object[] {id},
                    (results, rowNum) -> {
                        Exit exit = new Exit();
                        exit.setName(results.getString("Name"));
                        exit.setDestinationId(results.getInt("DestinationId"));
                        String aliases = results.getString("Aliases");
                        if (null != aliases) {
                            Arrays.stream(aliases.replace(" ", "").split(","))
                                    .forEach(alias -> exit.addAlias(alias));
                        }
                        return exit;
                    });

            return exits;
        } catch (DataAccessException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            return null;
        }
    }
}
