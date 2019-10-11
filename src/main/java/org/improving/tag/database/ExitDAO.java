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
            List<Exit> exits = jdbcTemplate.query("select * from locationexit where OriginId = ?", new Object[] {id},
                    (result, rowNum) -> {
                        Exit exit = new Exit();
                        exit.setId(result.getInt("OriginId"));
                        exit.setName(result.getString("Name"));

                        int destinationID = result.getInt("DestinationId");
                        exit.setDestination(locationDAO.findAll().get(destinationID));

                        List<String> aliases = Arrays.asList(result.getString("Aliases").split(","));
                        exit.setAliases(aliases);

                        return exit;
                    });
            return exits;
        } catch (DataAccessException e) {
            System.out.println("Exception in JDBC: " + e.getMessage());
            return null;
        }
    }
}
